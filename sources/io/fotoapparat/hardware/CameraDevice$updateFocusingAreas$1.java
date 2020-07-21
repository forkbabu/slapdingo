package io.fotoapparat.hardware;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@ø\u0001\u0000"}, d2 = {"updateFocusingAreas", "", "Landroid/hardware/Camera;", "focalRequest", "Lio/fotoapparat/hardware/metering/FocalRequest;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "io/fotoapparat/hardware/CameraDevice", f = "CameraDevice.kt", i = {0, 0, 0, 0, 0}, l = {342, 350}, m = "updateFocusingAreas", n = {"this", "$receiver", "focalRequest", "focusingAreas", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5"})
/* compiled from: CameraDevice.kt */
final class CameraDevice$updateFocusingAreas$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraDevice this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraDevice$updateFocusingAreas$1(CameraDevice cameraDevice, Continuation continuation) {
        super(continuation);
        this.this$0 = cameraDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateFocusingAreas(null, null, this);
    }
}
