package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate2) {
        super(observableSource);
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Boolean> observer) {
        this.source.subscribe(new AnyObserver(observer, this.predicate));
    }

    static final class AnyObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Boolean> actual;
        boolean done;
        final Predicate<? super T> predicate;
        Disposable s;

        AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate2) {
            this.actual = observer;
            this.predicate = predicate2;
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
            if (!this.done) {
                try {
                    if (this.predicate.test(t)) {
                        this.done = true;
                        this.s.dispose();
                        this.actual.onNext(true);
                        this.actual.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.s.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onNext(false);
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s.isDisposed();
        }
    }
}
