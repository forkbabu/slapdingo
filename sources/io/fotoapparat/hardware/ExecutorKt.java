package io.fotoapparat.hardware;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0000\u001a\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0000\"\u001c\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0004¨\u0006\u0010"}, d2 = {"frameProcessingExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getFrameProcessingExecutor", "()Ljava/util/concurrent/ExecutorService;", "loggingExecutor", "mainThreadHandler", "Landroid/os/Handler;", "pendingResultExecutor", "getPendingResultExecutor", "executeLoggingThread", "", "function", "Lkotlin/Function0;", "executeMainThread", "", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: Executor.kt */
public final class ExecutorKt {
    private static final ExecutorService frameProcessingExecutor = Executors.newSingleThreadExecutor();
    private static final ExecutorService loggingExecutor = Executors.newSingleThreadExecutor();
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService pendingResultExecutor = Executors.newSingleThreadExecutor();

    public static final ExecutorService getPendingResultExecutor() {
        return pendingResultExecutor;
    }

    public static final ExecutorService getFrameProcessingExecutor() {
        return frameProcessingExecutor;
    }

    public static final void executeLoggingThread(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "function");
        loggingExecutor.execute(new ExecutorKt$executeLoggingThread$1(function0));
    }

    public static final boolean executeMainThread(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "function");
        return mainThreadHandler.post(new ExecutorKt$executeMainThread$1(function0));
    }
}
