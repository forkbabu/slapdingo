package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler2, long j3, int i, boolean z) {
        super(observableSource);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.maxSize = j3;
        this.bufferSize = i;
        this.restartTimerOnMaxSize = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.timespan != this.timeskip) {
            this.source.subscribe(new WindowSkipObserver(serializedObserver, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
        } else if (this.maxSize == LongCompanionObject.MAX_VALUE) {
            this.source.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.timespan, this.unit, this.scheduler, this.bufferSize));
        } else {
            this.source.subscribe(new WindowExactBoundedObserver(serializedObserver, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
        }
    }

    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        static final Object NEXT = new Object();
        final int bufferSize;
        Disposable s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final long timespan;
        final TimeUnit unit;
        UnicastSubject<T> window;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler2, int i) {
            super(observer, new MpscLinkedQueue());
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.bufferSize = i;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.window = UnicastSubject.create(this.bufferSize);
                Observer observer = this.actual;
                observer.onSubscribe(this);
                observer.onNext(this.window);
                if (!this.cancelled) {
                    Scheduler scheduler2 = this.scheduler;
                    long j = this.timespan;
                    DisposableHelper.replace(this.timer, scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit));
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.terminated) {
                if (fastEnter()) {
                    this.window.onNext(t);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer(NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            disposeTimer();
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void disposeTimer() {
            DisposableHelper.dispose(this.timer);
        }

        public void run() {
            if (this.cancelled) {
                this.terminated = true;
                disposeTimer();
            }
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer observer = this.actual;
            T t = this.window;
            int i = 1;
            while (true) {
                boolean z = this.terminated;
                boolean z2 = this.done;
                T poll = mpscLinkedQueue.poll();
                if (!z2 || !(poll == null || poll == NEXT)) {
                    if (poll == null) {
                        i = leave(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == NEXT) {
                        t.onComplete();
                        if (!z) {
                            t = UnicastSubject.create(this.bufferSize);
                            this.window = t;
                            observer.onNext(t);
                        } else {
                            this.s.dispose();
                        }
                    } else {
                        t.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.window = null;
            mpscLinkedQueue.clear();
            disposeTimer();
            Throwable th = this.error;
            if (th != null) {
                t.onError(th);
            } else {
                t.onComplete();
            }
        }
    }

    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable s;
        final Scheduler scheduler;
        volatile boolean terminated;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final long timespan;
        final TimeUnit unit;
        UnicastSubject<T> window;
        final Scheduler.Worker worker;

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler2, int i, long j2, boolean z) {
            super(observer, new MpscLinkedQueue());
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.bufferSize = i;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler2.createWorker();
            } else {
                this.worker = null;
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Disposable disposable2;
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                Observer observer = this.actual;
                observer.onSubscribe(this);
                if (!this.cancelled) {
                    T create = UnicastSubject.create(this.bufferSize);
                    this.window = create;
                    observer.onNext(create);
                    ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                    if (this.restartTimerOnMaxSize) {
                        Scheduler.Worker worker2 = this.worker;
                        long j = this.timespan;
                        disposable2 = worker2.schedulePeriodically(consumerIndexHolder, j, j, this.unit);
                    } else {
                        Scheduler scheduler2 = this.scheduler;
                        long j2 = this.timespan;
                        disposable2 = scheduler2.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.unit);
                    }
                    DisposableHelper.replace(this.timer, disposable2);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.terminated) {
                if (fastEnter()) {
                    UnicastSubject<T> unicastSubject = this.window;
                    unicastSubject.onNext(t);
                    long j = this.count + 1;
                    if (j >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0;
                        unicastSubject.onComplete();
                        T create = UnicastSubject.create(this.bufferSize);
                        this.window = create;
                        this.actual.onNext(create);
                        if (this.restartTimerOnMaxSize) {
                            this.timer.get().dispose();
                            Scheduler.Worker worker2 = this.worker;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                            long j2 = this.timespan;
                            DisposableHelper.replace(this.timer, worker2.schedulePeriodically(consumerIndexHolder, j2, j2, this.unit));
                        }
                    } else {
                        this.count = j;
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer(NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            disposeTimer();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            disposeTimer();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void disposeTimer() {
            DisposableHelper.dispose(this.timer);
            Scheduler.Worker worker2 = this.worker;
            if (worker2 != null) {
                worker2.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer observer = this.actual;
            T t = this.window;
            int i = 1;
            while (!this.terminated) {
                boolean z = this.done;
                T poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.window = null;
                    mpscLinkedQueue.clear();
                    disposeTimer();
                    Throwable th = this.error;
                    if (th != null) {
                        t.onError(th);
                        return;
                    } else {
                        t.onComplete();
                        return;
                    }
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    T t2 = poll;
                    if (this.restartTimerOnMaxSize || this.producerIndex == ((ConsumerIndexHolder) t2).index) {
                        t.onComplete();
                        this.count = 0;
                        t = UnicastSubject.create(this.bufferSize);
                        this.window = t;
                        observer.onNext(t);
                    }
                } else {
                    t.onNext(NotificationLite.getValue(poll));
                    long j = this.count + 1;
                    if (j >= this.maxSize) {
                        this.producerIndex++;
                        this.count = 0;
                        t.onComplete();
                        t = UnicastSubject.create(this.bufferSize);
                        this.window = t;
                        this.actual.onNext(t);
                        if (this.restartTimerOnMaxSize) {
                            Disposable disposable = this.timer.get();
                            disposable.dispose();
                            Scheduler.Worker worker2 = this.worker;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                            long j2 = this.timespan;
                            Disposable schedulePeriodically = worker2.schedulePeriodically(consumerIndexHolder, j2, j2, this.unit);
                            if (!this.timer.compareAndSet(disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.count = j;
                    }
                }
            }
            this.s.dispose();
            mpscLinkedQueue.clear();
            disposeTimer();
        }

        static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedObserver<?> parent;

            ConsumerIndexHolder(long j, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.index = j;
                this.parent = windowExactBoundedObserver;
            }

            public void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.parent;
                if (!windowExactBoundedObserver.cancelled) {
                    windowExactBoundedObserver.queue.offer(this);
                } else {
                    windowExactBoundedObserver.terminated = true;
                    windowExactBoundedObserver.disposeTimer();
                }
                if (windowExactBoundedObserver.enter()) {
                    windowExactBoundedObserver.drainLoop();
                }
            }
        }
    }

    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        final int bufferSize;
        Disposable s;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        final List<UnicastSubject<T>> windows = new LinkedList();
        final Scheduler.Worker worker;

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker2, int i) {
            super(observer, new MpscLinkedQueue());
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.worker = worker2;
            this.bufferSize = i;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
                if (!this.cancelled) {
                    T create = UnicastSubject.create(this.bufferSize);
                    this.windows.add(create);
                    this.actual.onNext(create);
                    this.worker.schedule(new CompletionTask(create), this.timespan, this.unit);
                    Scheduler.Worker worker2 = this.worker;
                    long j = this.timeskip;
                    worker2.schedulePeriodically(this, j, j, this.unit);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (fastEnter()) {
                for (UnicastSubject<T> unicastSubject : this.windows) {
                    unicastSubject.onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onError(th);
            disposeWorker();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.actual.onComplete();
            disposeWorker();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void disposeWorker() {
            this.worker.dispose();
        }

        /* access modifiers changed from: package-private */
        public void complete(UnicastSubject<T> unicastSubject) {
            this.queue.offer(new SubjectWork(unicastSubject, false));
            if (enter()) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer observer = this.actual;
            List<UnicastSubject<T>> list = this.windows;
            int i = 1;
            while (!this.terminated) {
                boolean z = this.done;
                T poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastSubject<T> unicastSubject : list) {
                            unicastSubject.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> unicastSubject2 : list) {
                            unicastSubject2.onComplete();
                        }
                    }
                    disposeWorker();
                    list.clear();
                    return;
                } else if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    T t = poll;
                    if (!((SubjectWork) t).open) {
                        list.remove(((SubjectWork) t).w);
                        ((SubjectWork) t).w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    } else if (!this.cancelled) {
                        T create = UnicastSubject.create(this.bufferSize);
                        list.add(create);
                        observer.onNext(create);
                        this.worker.schedule(new CompletionTask(create), this.timespan, this.unit);
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject3 : list) {
                        unicastSubject3.onNext(poll);
                    }
                }
            }
            this.s.dispose();
            disposeWorker();
            mpscLinkedQueue.clear();
            list.clear();
        }

        public void run() {
            T subjectWork = new SubjectWork(UnicastSubject.create(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }

        static final class SubjectWork<T> {
            final boolean open;
            final UnicastSubject<T> w;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z) {
                this.w = unicastSubject;
                this.open = z;
            }
        }

        final class CompletionTask implements Runnable {
            private final UnicastSubject<T> w;

            CompletionTask(UnicastSubject<T> unicastSubject) {
                this.w = unicastSubject;
            }

            public void run() {
                WindowSkipObserver.this.complete(this.w);
            }
        }
    }
}
