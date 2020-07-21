package io.fotoapparat.result;

import io.fotoapparat.concurrent.EnsureBgThreadKt;
import io.fotoapparat.hardware.ExecutorKt;
import io.fotoapparat.log.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001aB%\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ+\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0001\u0010\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u0002H\u000e0\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0000\"\u0004\b\u0001\u0010\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000e0\u0010J\u001c\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00160\u0010J\u0014\u0010\u0018\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lio/fotoapparat/result/PendingResult;", "T", "", "future", "Ljava/util/concurrent/Future;", "logger", "Lio/fotoapparat/log/Logger;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Future;Lio/fotoapparat/log/Logger;Ljava/util/concurrent/Executor;)V", "resultUnsafe", "getResultUnsafe", "()Ljava/lang/Object;", "adapt", "R", "adapter", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "await", "transform", "transformer", "whenAvailable", "", "callback", "whenDone", "Lio/fotoapparat/result/WhenDoneListener;", "Companion", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: PendingResult.kt */
public class PendingResult<T> {
    public static final Companion Companion = new Companion(null);
    private final Executor executor;
    /* access modifiers changed from: private */
    public final Future<T> future;
    /* access modifiers changed from: private */
    public final Logger logger;

    public PendingResult(Future<T> future2, Logger logger2, Executor executor2) {
        Intrinsics.checkParameterIsNotNull(future2, "future");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(executor2, "executor");
        this.future = future2;
        this.logger = logger2;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    public final T getResultUnsafe() {
        EnsureBgThreadKt.ensureBackgroundThread();
        return this.future.get();
    }

    public final <R> PendingResult<R> transform(Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "transformer");
        FutureTask futureTask = new FutureTask(new PendingResult$transform$transformTask$1(this, function1));
        this.executor.execute(futureTask);
        return new PendingResult<>(futureTask, this.logger, this.executor);
    }

    public final T await() throws ExecutionException, InterruptedException {
        return this.future.get();
    }

    public final <R> R adapt(Function1<? super Future<T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "adapter");
        return function1.invoke(this.future);
    }

    public final void whenAvailable(Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        this.executor.execute(new PendingResult$whenAvailable$1(this, function1));
    }

    public final void whenDone(WhenDoneListener<? super T> whenDoneListener) {
        Intrinsics.checkParameterIsNotNull(whenDoneListener, "callback");
        whenAvailable(new PendingResult$whenDone$1(whenDoneListener));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/fotoapparat/result/PendingResult$Companion;", "", "()V", "fromFuture", "Lio/fotoapparat/result/PendingResult;", "T", "future", "Ljava/util/concurrent/Future;", "logger", "Lio/fotoapparat/log/Logger;", "fromFuture$fotoapparat_release", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: PendingResult.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> PendingResult<T> fromFuture$fotoapparat_release(Future<T> future, Logger logger) {
            Intrinsics.checkParameterIsNotNull(future, "future");
            Intrinsics.checkParameterIsNotNull(logger, "logger");
            ExecutorService pendingResultExecutor = ExecutorKt.getPendingResultExecutor();
            Intrinsics.checkExpressionValueIsNotNull(pendingResultExecutor, "pendingResultExecutor");
            return new PendingResult<>(future, logger, pendingResultExecutor);
        }
    }
}
