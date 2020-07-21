package io.fotoapparat.hardware.orientation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "deviceRotation", "", "Lio/fotoapparat/hardware/orientation/DeviceRotationDegrees;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: OrientationSensor.kt */
final class OrientationSensor$onOrientationChanged$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ OrientationSensor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrientationSensor$onOrientationChanged$1(OrientationSensor orientationSensor) {
        super(1);
        this.this$0 = orientationSensor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        OrientationState orientationState = new OrientationState(OrientationKt.toOrientation(RotationKt.toClosestRightAngle(i)), this.this$0.device.getScreenOrientation());
        if (!Intrinsics.areEqual(orientationState, this.this$0.getLastKnownOrientationState())) {
            this.this$0.setLastKnownOrientationState(orientationState);
            OrientationSensor.access$getListener$p(this.this$0).invoke(orientationState);
        }
    }
}
