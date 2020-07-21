package io.fotoapparat.routine.camera;

import io.fotoapparat.configuration.Configuration;
import io.fotoapparat.hardware.CameraDevice;
import io.fotoapparat.hardware.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"updateCameraConfiguration", "", "Lio/fotoapparat/hardware/Device;", "cameraDevice", "Lio/fotoapparat/hardware/CameraDevice;", "updateDeviceConfiguration", "newConfiguration", "Lio/fotoapparat/configuration/Configuration;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: UpdateConfigurationRoutine.kt */
public final class UpdateConfigurationRoutineKt {
    public static final void updateDeviceConfiguration(Device device, Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(configuration, "newConfiguration");
        CameraDevice selectedCamera = device.getSelectedCamera();
        device.updateConfiguration(configuration);
        updateCameraConfiguration(device, selectedCamera);
    }

    public static final void updateCameraConfiguration(Device device, CameraDevice cameraDevice) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cameraDevice, "cameraDevice");
        Object unused = BuildersKt__BuildersKt.runBlocking$default(null, new UpdateConfigurationRoutineKt$updateCameraConfiguration$1(device, cameraDevice, null), 1, null);
    }
}
