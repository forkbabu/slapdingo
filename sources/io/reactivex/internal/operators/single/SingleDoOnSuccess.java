package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnSuccess<T> extends Single<T> {
    final Consumer<? super T> onSuccess;
    final SingleSource<T> source;

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.source = singleSource;
        this.onSuccess = consumer;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnSuccess(singleObserver));
    }

    final class DoOnSuccess implements SingleObserver<T> {
        private final SingleObserver<? super T> s;

        DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.s.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            try {
                SingleDoOnSuccess.this.onSuccess.accept(t);
                this.s.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }
}
