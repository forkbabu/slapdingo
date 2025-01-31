package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable s;

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.validate(this.s, disposable, getClass())) {
            this.s = disposable;
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public final void cancel() {
        Disposable disposable = this.s;
        this.s = DisposableHelper.DISPOSED;
        disposable.dispose();
    }
}
