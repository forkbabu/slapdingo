package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableObservable<T> source;
    final long timeout;
    final TimeUnit unit;

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.source = connectableObservable;
        this.n = i;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.connection;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.connection = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != ((long) this.n)) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.source.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.source.connect(refConnection);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.connection     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r5)     // Catch:{ all -> 0x003c }
            return
        L_0x0007:
            long r0 = r6.subscriberCount     // Catch:{ all -> 0x003c }
            r2 = 1
            long r0 = r0 - r2
            r6.subscriberCount = r0     // Catch:{ all -> 0x003c }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x003a
            boolean r0 = r6.connected     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0019
            goto L_0x003a
        L_0x0019:
            long r0 = r5.timeout     // Catch:{ all -> 0x003c }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0024
            r5.timeout(r6)     // Catch:{ all -> 0x003c }
            monitor-exit(r5)     // Catch:{ all -> 0x003c }
            return
        L_0x0024:
            io.reactivex.internal.disposables.SequentialDisposable r0 = new io.reactivex.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x003c }
            r0.<init>()     // Catch:{ all -> 0x003c }
            r6.timer = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r5)     // Catch:{ all -> 0x003c }
            io.reactivex.Scheduler r1 = r5.scheduler
            long r2 = r5.timeout
            java.util.concurrent.TimeUnit r4 = r5.unit
            io.reactivex.disposables.Disposable r6 = r1.scheduleDirect(r6, r2, r4)
            r0.replace(r6)
            return
        L_0x003a:
            monitor-exit(r5)
            return
        L_0x003c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableRefCount.cancel(io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection):void");
    }

    /* access modifiers changed from: package-private */
    public void terminated(RefConnection refConnection) {
        synchronized (this) {
            if (this.connection != null) {
                this.connection = null;
                if (refConnection.timer != null) {
                    refConnection.timer.dispose();
                }
                if (this.source instanceof Disposable) {
                    ((Disposable) this.source).dispose();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void timeout(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                this.connection = null;
                DisposableHelper.dispose(refConnection);
                if (this.source instanceof Disposable) {
                    ((Disposable) this.source).dispose();
                }
            }
        }
    }

    static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        public void run() {
            this.parent.timeout(this);
        }

        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.replace(this, disposable);
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final Observer<? super T> actual;
        final RefConnection connection;
        final ObservableRefCount<T> parent;
        Disposable upstream;

        RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.actual = observer;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.cancel(this.connection);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }
}
