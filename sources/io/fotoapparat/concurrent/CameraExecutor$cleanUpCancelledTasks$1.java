package io.fotoapparat.concurrent;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/util/concurrent/Future;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: CameraExecutor.kt */
final class CameraExecutor$cleanUpCancelledTasks$1 extends Lambda implements Function1<Future<?>, Boolean> {
    final /* synthetic */ CameraExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraExecutor$cleanUpCancelledTasks$1(CameraExecutor cameraExecutor) {
        super(1);
        this.this$0 = cameraExecutor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Future<?> future) {
        return Boolean.valueOf(invoke(future));
    }

    public final boolean invoke(Future<?> future) {
        Intrinsics.checkParameterIsNotNull(future, "it");
        return !this.this$0.isPending(future);
    }
}
