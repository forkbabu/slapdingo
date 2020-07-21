package io.fotoapparat.routine.orientation;

import io.fotoapparat.concurrent.CameraExecutor;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.orientation.OrientationState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "orientationState", "Lio/fotoapparat/hardware/orientation/OrientationState;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: StartOrientationRoutine.kt */
final class StartOrientationRoutineKt$startOrientationMonitoring$1 extends Lambda implements Function1<OrientationState, Unit> {
    final /* synthetic */ Device $this_startOrientationMonitoring;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartOrientationRoutineKt$startOrientationMonitoring$1(Device device) {
        super(1);
        this.$this_startOrientationMonitoring = device;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OrientationState orientationState) {
        invoke(orientationState);
        return Unit.INSTANCE;
    }

    public final void invoke(final OrientationState orientationState) {
        Intrinsics.checkParameterIsNotNull(orientationState, "orientationState");
        this.$this_startOrientationMonitoring.getExecutor$fotoapparat_release().execute(new CameraExecutor.Operation(true, new Function0<Unit>(this) {
            /* class io.fotoapparat.routine.orientation.StartOrientationRoutineKt$startOrientationMonitoring$1.AnonymousClass1 */
            final /* synthetic */ StartOrientationRoutineKt$startOrientationMonitoring$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                this.this$0.$this_startOrientationMonitoring.getSelectedCamera().setDisplayOrientation(orientationState);
            }
        }));
    }
}
