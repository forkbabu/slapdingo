package io.fotoapparat.routine.orientation;

import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.orientation.OrientationSensor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"startOrientationMonitoring", "", "Lio/fotoapparat/hardware/Device;", "orientationSensor", "Lio/fotoapparat/hardware/orientation/OrientationSensor;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: StartOrientationRoutine.kt */
public final class StartOrientationRoutineKt {
    public static final void startOrientationMonitoring(Device device, OrientationSensor orientationSensor) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(orientationSensor, "orientationSensor");
        orientationSensor.start(new StartOrientationRoutineKt$startOrientationMonitoring$1(device));
    }
}
