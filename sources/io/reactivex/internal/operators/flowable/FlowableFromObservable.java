package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }

    static class SubscriberObserver<T> implements Observer<T>, Subscription {
        private Disposable d;
        private final Subscriber<? super T> s;

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.s.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.s.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.s.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.s.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.dispose();
        }
    }
}
