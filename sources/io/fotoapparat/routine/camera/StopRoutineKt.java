package io.fotoapparat.routine.camera;

import io.fotoapparat.hardware.CameraDevice;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.orientation.OrientationSensor;
import io.fotoapparat.routine.orientation.StopOrientationRoutineKt;
import io.fotoapparat.view.FocalPointSelector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"shutDown", "", "Lio/fotoapparat/hardware/Device;", "orientationSensor", "Lio/fotoapparat/hardware/orientation/OrientationSensor;", "stop", "cameraDevice", "Lio/fotoapparat/hardware/CameraDevice;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: StopRoutine.kt */
public final class StopRoutineKt {
    public static final void shutDown(Device device, OrientationSensor orientationSensor) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(orientationSensor, "orientationSensor");
        FocalPointSelector focusPointSelector$fotoapparat_release = device.getFocusPointSelector$fotoapparat_release();
        if (focusPointSelector$fotoapparat_release != null) {
            focusPointSelector$fotoapparat_release.setFocalPointListener(StopRoutineKt$shutDown$1.INSTANCE);
        }
        StopOrientationRoutineKt.stopMonitoring(orientationSensor);
        stop(device, device.getSelectedCamera());
    }

    public static final void stop(Device device, CameraDevice cameraDevice) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cameraDevice, "cameraDevice");
        cameraDevice.stopPreview();
        cameraDevice.close();
        device.clearSelectedCamera();
    }
}
