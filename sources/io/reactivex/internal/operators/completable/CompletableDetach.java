package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class CompletableDetach extends Completable {
    final CompletableSource source;

    public CompletableDetach(CompletableSource completableSource) {
        this.source = completableSource;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new DetachCompletableObserver(completableObserver));
    }

    static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        CompletableObserver actual;
        Disposable d;

        DetachCompletableObserver(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.actual = null;
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.actual;
            if (completableObserver != null) {
                this.actual = null;
                completableObserver.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.actual;
            if (completableObserver != null) {
                this.actual = null;
                completableObserver.onComplete();
            }
        }
    }
}
