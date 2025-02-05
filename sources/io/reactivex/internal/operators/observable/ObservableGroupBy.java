package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super T, ? extends V> valueSelector;

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
        super(observableSource);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i;
        this.delayError = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final Observer<? super GroupedObservable<K, V>> actual;
        final int bufferSize;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        Disposable s;
        final Function<? super T, ? extends V> valueSelector;

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
            this.actual = observer;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Object obj;
            try {
                Object apply = this.keySelector.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                GroupedUnicast<K, V> groupedUnicast = this.groups.get(obj);
                if (groupedUnicast == null) {
                    if (!this.cancelled.get()) {
                        groupedUnicast = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, groupedUnicast);
                        getAndIncrement();
                        this.actual.onNext(groupedUnicast);
                    } else {
                        return;
                    }
                }
                try {
                    groupedUnicast.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.s.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.s.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayList<GroupedUnicast> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (GroupedUnicast groupedUnicast : arrayList) {
                groupedUnicast.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList<GroupedUnicast> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (GroupedUnicast groupedUnicast : arrayList) {
                groupedUnicast.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void cancel(K k) {
            if (k == null) {
                k = NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.s.dispose();
            }
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new GroupedUnicast<>(k, new State(i, groupByObserver, k, z));
        }

        protected GroupedUnicast(K k, State<T, K> state2) {
            super(k);
            this.state = state2;
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super T> observer) {
            this.state.subscribe(observer);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Observer<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once = new AtomicBoolean();
        final GroupByObserver<?, K, T> parent;
        final SpscLinkedArrayQueue<T> queue;

        State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            if (this.once.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.actual.lazySet(observer);
                if (this.cancelled.get()) {
                    this.actual.lazySet(null);
                } else {
                    drain();
                }
            } else {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
                boolean z = this.delayError;
                Observer<? super T> observer = this.actual.get();
                int i = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z2 = this.done;
                            T poll = spscLinkedArrayQueue.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, observer, z)) {
                                if (z3) {
                                    break;
                                }
                                observer.onNext(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i != 0) {
                        if (observer == null) {
                            observer = this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Observer<? super T> observer, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        this.actual.lazySet(null);
                        observer.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.actual.lazySet(null);
                        observer.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.error;
                    this.actual.lazySet(null);
                    if (th2 != null) {
                        observer.onError(th2);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }
    }
}
