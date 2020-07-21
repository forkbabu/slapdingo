package io.fotoapparat.concurrent;

import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J \u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0007\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u0013"}, d2 = {"Lio/fotoapparat/concurrent/CameraExecutor;", "", "executor", "Ljava/util/concurrent/ExecutorService;", "(Ljava/util/concurrent/ExecutorService;)V", "cancellableTasksQueue", "Ljava/util/LinkedList;", "Ljava/util/concurrent/Future;", "isPending", "", "(Ljava/util/concurrent/Future;)Z", "cancelTasks", "", "cleanUpCancelledTasks", "execute", "T", Annotation.OPERATION, "Lio/fotoapparat/concurrent/CameraExecutor$Operation;", "Operation", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: CameraExecutor.kt */
public final class CameraExecutor {
    private final LinkedList<Future<?>> cancellableTasksQueue;
    private final ExecutorService executor;

    public CameraExecutor() {
        this(null, 1, null);
    }

    public CameraExecutor(ExecutorService executorService) {
        Intrinsics.checkParameterIsNotNull(executorService, "executor");
        this.executor = executorService;
        this.cancellableTasksQueue = new LinkedList<>();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CameraExecutor(java.util.concurrent.ExecutorService r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000d
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newSingleThreadExecutor()
            java.lang.String r2 = "Executors.newSingleThreadExecutor()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
        L_0x000d:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fotoapparat.concurrent.CameraExecutor.<init>(java.util.concurrent.ExecutorService, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final <T> Future<T> execute(Operation<? extends T> operation) {
        Intrinsics.checkParameterIsNotNull(operation, Annotation.OPERATION);
        Future<T> submit = this.executor.submit(new CameraExecutor$execute$future$1(operation));
        if (operation.getCancellable()) {
            this.cancellableTasksQueue.add(submit);
        }
        cleanUpCancelledTasks();
        Intrinsics.checkExpressionValueIsNotNull(submit, "future");
        return submit;
    }

    private final void cleanUpCancelledTasks() {
        CollectionsKt.removeAll((List) this.cancellableTasksQueue, (Function1) new CameraExecutor$cleanUpCancelledTasks$1(this));
    }

    public final void cancelTasks() {
        Collection arrayList = new ArrayList();
        for (Object obj : this.cancellableTasksQueue) {
            if (isPending((Future) obj)) {
                arrayList.add(obj);
            }
        }
        for (Future future : (List) arrayList) {
            future.cancel(true);
        }
        this.cancellableTasksQueue.clear();
    }

    /* access modifiers changed from: private */
    public final boolean isPending(Future<?> future) {
        return !future.isCancelled() && !future.isDone();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/fotoapparat/concurrent/CameraExecutor$Operation;", "T", "", "cancellable", "", "function", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)V", "getCancellable", "()Z", "getFunction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: CameraExecutor.kt */
    public static final class Operation<T> {
        private final boolean cancellable;
        private final Function0<T> function;

        public static /* synthetic */ Operation copy$default(Operation operation, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                z = operation.cancellable;
            }
            if ((i & 2) != 0) {
                function0 = operation.function;
            }
            return operation.copy(z, function0);
        }

        public final boolean component1() {
            return this.cancellable;
        }

        public final Function0<T> component2() {
            return this.function;
        }

        public final Operation<T> copy(boolean z, Function0<? extends T> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "function");
            return new Operation<>(z, function0);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Operation) {
                    Operation operation = (Operation) obj;
                    if (!(this.cancellable == operation.cancellable) || !Intrinsics.areEqual(this.function, operation.function)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.cancellable;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = i * 31;
            Function0<T> function0 = this.function;
            return i3 + (function0 != null ? function0.hashCode() : 0);
        }

        public String toString() {
            return "Operation(cancellable=" + this.cancellable + ", function=" + this.function + ")";
        }

        public Operation(boolean z, Function0<? extends T> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "function");
            this.cancellable = z;
            this.function = function0;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Operation(boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, function0);
        }

        public final boolean getCancellable() {
            return this.cancellable;
        }

        public final Function0<T> getFunction() {
            return this.function;
        }
    }
}
