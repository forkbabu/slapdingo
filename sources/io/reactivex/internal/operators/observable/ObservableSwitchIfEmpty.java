package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> other;

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.other = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.other);
        observer.onSubscribe(switchIfEmptyObserver.arbiter);
        this.source.subscribe(switchIfEmptyObserver);
    }

    static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        final Observer<? super T> actual;
        final SequentialDisposable arbiter = new SequentialDisposable();
        boolean empty = true;
        final ObservableSource<? extends T> other;

        SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.actual = observer;
            this.other = observableSource;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.arbiter.update(disposable);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.empty) {
                this.empty = false;
            }
            this.actual.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.empty) {
                this.empty = false;
                this.other.subscribe(this);
                return;
            }
            this.actual.onComplete();
        }
    }
}
