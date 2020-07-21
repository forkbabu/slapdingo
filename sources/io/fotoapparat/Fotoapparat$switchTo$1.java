package io.fotoapparat;

import io.fotoapparat.configuration.CameraConfiguration;
import io.fotoapparat.routine.camera.SwitchCameraRoutineKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: Fotoapparat.kt */
final class Fotoapparat$switchTo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CameraConfiguration $cameraConfiguration;
    final /* synthetic */ Function1 $lensPosition;
    final /* synthetic */ Fotoapparat this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Fotoapparat$switchTo$1(Fotoapparat fotoapparat, Function1 function1, CameraConfiguration cameraConfiguration) {
        super(0);
        this.this$0 = fotoapparat;
        this.$lensPosition = function1;
        this.$cameraConfiguration = cameraConfiguration;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        SwitchCameraRoutineKt.switchCamera(this.this$0.device, this.$lensPosition, this.$cameraConfiguration, this.this$0.mainThreadErrorCallback, this.this$0.getOrientationSensor());
    }
}
