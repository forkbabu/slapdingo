package io.fotoapparat.routine.camera;

import io.fotoapparat.characteristic.LensPosition;
import io.fotoapparat.configuration.CameraConfiguration;
import io.fotoapparat.exception.camera.CameraException;
import io.fotoapparat.hardware.CameraDevice;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.orientation.OrientationSensor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u0002`\nH\u0000\u001aY\u0010\u000b\u001a\u00020\u0001*\u00020\u00022#\u0010\f\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\bj\u0002`\u000f¢\u0006\u0002\b\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0013"}, d2 = {"restartPreview", "", "Lio/fotoapparat/hardware/Device;", "oldCameraDevice", "Lio/fotoapparat/hardware/CameraDevice;", "orientationSensor", "Lio/fotoapparat/hardware/orientation/OrientationSensor;", "mainThreadErrorCallback", "Lkotlin/Function1;", "Lio/fotoapparat/exception/camera/CameraException;", "Lio/fotoapparat/error/CameraErrorCallback;", "switchCamera", "newLensPositionSelector", "", "Lio/fotoapparat/characteristic/LensPosition;", "Lio/fotoapparat/selector/LensPositionSelector;", "Lkotlin/ExtensionFunctionType;", "newConfiguration", "Lio/fotoapparat/configuration/CameraConfiguration;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: SwitchCameraRoutine.kt */
public final class SwitchCameraRoutineKt {
    public static final void switchCamera(Device device, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1, CameraConfiguration cameraConfiguration, Function1<? super CameraException, Unit> function12, OrientationSensor orientationSensor) {
        CameraDevice cameraDevice;
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "newLensPositionSelector");
        Intrinsics.checkParameterIsNotNull(cameraConfiguration, "newConfiguration");
        Intrinsics.checkParameterIsNotNull(function12, "mainThreadErrorCallback");
        Intrinsics.checkParameterIsNotNull(orientationSensor, "orientationSensor");
        try {
            cameraDevice = device.getSelectedCamera();
        } catch (IllegalStateException unused) {
            cameraDevice = null;
        }
        if (cameraDevice == null) {
            device.updateLensPositionSelector(function1);
            device.updateConfiguration(cameraConfiguration);
        } else if (!Intrinsics.areEqual(device.getLensPositionSelector(), function1)) {
            device.updateLensPositionSelector(function1);
            device.updateConfiguration(cameraConfiguration);
            restartPreview(device, cameraDevice, orientationSensor, function12);
        }
    }

    public static final void restartPreview(Device device, CameraDevice cameraDevice, OrientationSensor orientationSensor, Function1<? super CameraException, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cameraDevice, "oldCameraDevice");
        Intrinsics.checkParameterIsNotNull(orientationSensor, "orientationSensor");
        Intrinsics.checkParameterIsNotNull(function1, "mainThreadErrorCallback");
        StopRoutineKt.stop(device, cameraDevice);
        try {
            StartRoutineKt.start(device, orientationSensor);
        } catch (CameraException e) {
            function1.invoke(e);
        }
    }
}
