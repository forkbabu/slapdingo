package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* compiled from: CoroutineExceptionHandlerImpl.kt */
public final class CoroutineExceptionHandlerImplKt {
    private static final List<CoroutineExceptionHandler> handlers;

    static {
        ServiceLoader load = ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader());
        Intrinsics.checkExpressionValueIsNotNull(load, "ServiceLoader.load(servi…serviceClass.classLoader)");
        handlers = CollectionsKt.toList(load);
    }

    public static final void handleCoroutineExceptionImpl(CoroutineContext coroutineContext, Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        for (CoroutineExceptionHandler coroutineExceptionHandler : handlers) {
            try {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, CoroutineExceptionHandlerKt.handlerException(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread2, "currentThread");
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
