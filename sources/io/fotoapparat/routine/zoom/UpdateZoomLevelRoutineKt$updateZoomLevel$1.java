package io.fotoapparat.routine.zoom;

import io.fotoapparat.hardware.Device;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "io/fotoapparat/routine/zoom/UpdateZoomLevelRoutineKt$updateZoomLevel$1", f = "UpdateZoomLevelRoutine.kt", i = {1}, l = {16, 20, 21}, m = "invokeSuspend", n = {"cameraDevice"}, s = {"L$0"})
/* compiled from: UpdateZoomLevelRoutine.kt */
final class UpdateZoomLevelRoutineKt$updateZoomLevel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $this_updateZoomLevel;
    final /* synthetic */ float $zoomLevel;
    Object L$0;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateZoomLevelRoutineKt$updateZoomLevel$1(Device device, float f, Continuation continuation) {
        super(2, continuation);
        this.$this_updateZoomLevel = device;
        this.$zoomLevel = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        UpdateZoomLevelRoutineKt$updateZoomLevel$1 updateZoomLevelRoutineKt$updateZoomLevel$1 = new UpdateZoomLevelRoutineKt$updateZoomLevel$1(this.$this_updateZoomLevel, this.$zoomLevel, continuation);
        updateZoomLevelRoutineKt$updateZoomLevel$1.p$ = (CoroutineScope) obj;
        return updateZoomLevelRoutineKt$updateZoomLevel$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateZoomLevelRoutineKt$updateZoomLevel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002e
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            java.lang.Object r0 = r4.L$0
            io.fotoapparat.hardware.CameraDevice r0 = (io.fotoapparat.hardware.CameraDevice) r0
            boolean r1 = r5 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0017
            goto L_0x0051
        L_0x0017:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r5 = r5.exception
            throw r5
        L_0x001c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0024:
            boolean r1 = r5 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0029
            goto L_0x0042
        L_0x0029:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r5 = r5.exception
            throw r5
        L_0x002e:
            boolean r1 = r5 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x0063
            float r5 = r4.$zoomLevel
            io.fotoapparat.routine.zoom.UpdateZoomLevelRoutineKt.ensureInBounds(r5)
            io.fotoapparat.hardware.Device r5 = r4.$this_updateZoomLevel
            r4.label = r3
            java.lang.Object r5 = r5.awaitSelectedCamera(r4)
            if (r5 != r0) goto L_0x0042
            return r0
        L_0x0042:
            io.fotoapparat.hardware.CameraDevice r5 = (io.fotoapparat.hardware.CameraDevice) r5
            r4.L$0 = r5
            r4.label = r2
            java.lang.Object r1 = r5.getCapabilities(r4)
            if (r1 != r0) goto L_0x004f
            return r0
        L_0x004f:
            r0 = r5
            r5 = r1
        L_0x0051:
            io.fotoapparat.capability.Capabilities r5 = (io.fotoapparat.capability.Capabilities) r5
            io.fotoapparat.parameter.Zoom r5 = r5.getZoom()
            boolean r5 = r5 instanceof io.fotoapparat.parameter.Zoom.VariableZoom
            if (r5 == 0) goto L_0x0060
            float r5 = r4.$zoomLevel
            r0.setZoom(r5)
        L_0x0060:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0063:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r5 = r5.exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fotoapparat.routine.zoom.UpdateZoomLevelRoutineKt$updateZoomLevel$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
