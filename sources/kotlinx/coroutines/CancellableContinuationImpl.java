package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u001b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0014J!\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00028\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0019\u0010 \u001a\u00020\u0010*\u00020!2\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\u0010*\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/AbstractContinuation;", "Lkotlinx/coroutines/CancellableContinuation;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "completeResume", "", "token", "", "getSuccessfulResult", "state", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "nameString", "", "tryResume", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "exception", "", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: CancellableContinuation.kt */
public class CancellableContinuationImpl<T> extends AbstractContinuation<T> implements CancellableContinuation<T>, Runnable {
    private final CoroutineContext context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i) {
        super(continuation, i);
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        this.context = continuation.getContext();
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        initParentJobInternal$kotlinx_coroutines_core((Job) getDelegate().getContext().get(Job.Key));
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        completeStateUpdate((NotCompleted) obj, getState$kotlinx_coroutines_core(), getResumeMode());
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "receiver$0");
        Continuation<T> delegate = getDelegate();
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (!(delegate instanceof DispatchedContinuation)) {
            delegate = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate;
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        resumeImpl(t, coroutineDispatcher2 == coroutineDispatcher ? 3 : getResumeMode());
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher, Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "receiver$0");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        Continuation<T> delegate = getDelegate();
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (!(delegate instanceof DispatchedContinuation)) {
            delegate = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate;
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(th);
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        resumeImpl(completedExceptionally, coroutineDispatcher2 == coroutineDispatcher ? 3 : getResumeMode());
    }

    @Override // kotlinx.coroutines.DispatchedTask, kotlinx.coroutines.AbstractContinuation
    public <T> T getSuccessfulResult(Object obj) {
        return obj instanceof CompletedIdempotentResult ? ((CompletedIdempotentResult) obj).result : obj;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractContinuation
    public String nameString() {
        return "CancellableContinuation(" + DebugKt.toDebugString(getDelegate()) + ')';
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T t, Object obj) {
        Object state$kotlinx_coroutines_core;
        T t2;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof NotCompleted)) {
                if (state$kotlinx_coroutines_core instanceof CompletedIdempotentResult) {
                    CompletedIdempotentResult completedIdempotentResult = (CompletedIdempotentResult) state$kotlinx_coroutines_core;
                    if (completedIdempotentResult.idempotentResume == obj) {
                        if (completedIdempotentResult.result == t) {
                            return completedIdempotentResult.token;
                        }
                        throw new IllegalStateException("Non-idempotent resume".toString());
                    }
                }
                return null;
            } else if (obj == null) {
                t2 = t;
            } else {
                t2 = new CompletedIdempotentResult(obj, t, (NotCompleted) state$kotlinx_coroutines_core);
            }
        } while (!tryUpdateStateToFinal((NotCompleted) state$kotlinx_coroutines_core, t2));
        return state$kotlinx_coroutines_core;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable th) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(th, "exception");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof NotCompleted)) {
                return null;
            }
        } while (!tryUpdateStateToFinal((NotCompleted) state$kotlinx_coroutines_core, new CompletedExceptionally(th)));
        return state$kotlinx_coroutines_core;
    }
}
