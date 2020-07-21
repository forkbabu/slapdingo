package io.fotoapparat.routine.camera;

import io.fotoapparat.exception.camera.CameraException;
import io.fotoapparat.hardware.CameraDevice;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.orientation.OrientationSensor;
import io.fotoapparat.log.Logger;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.routine.orientation.StartOrientationRoutineKt;
import io.fotoapparat.view.CameraRenderer;
import io.fotoapparat.view.FocalPointSelector;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006j\u0002`\bH\u0000\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\n"}, d2 = {"bootStart", "", "Lio/fotoapparat/hardware/Device;", "orientationSensor", "Lio/fotoapparat/hardware/orientation/OrientationSensor;", "mainThreadErrorCallback", "Lkotlin/Function1;", "Lio/fotoapparat/exception/camera/CameraException;", "Lio/fotoapparat/error/CameraErrorCallback;", "start", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: StartRoutine.kt */
public final class StartRoutineKt {
    public static final void bootStart(Device device, OrientationSensor orientationSensor, Function1<? super CameraException, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(orientationSensor, "orientationSensor");
        Intrinsics.checkParameterIsNotNull(function1, "mainThreadErrorCallback");
        if (!device.hasSelectedCamera()) {
            try {
                start(device, orientationSensor);
                StartOrientationRoutineKt.startOrientationMonitoring(device, orientationSensor);
            } catch (CameraException e) {
                function1.invoke(e);
            }
        } else {
            throw new IllegalStateException("Camera has already started!");
        }
    }

    public static final void start(Device device, OrientationSensor orientationSensor) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(orientationSensor, "orientationSensor");
        device.selectCamera();
        CameraDevice selectedCamera = device.getSelectedCamera();
        selectedCamera.open();
        UpdateConfigurationRoutineKt.updateCameraConfiguration(device, selectedCamera);
        selectedCamera.setDisplayOrientation(orientationSensor.getLastKnownOrientationState());
        Resolution previewResolution = selectedCamera.getPreviewResolution();
        CameraRenderer cameraRenderer$fotoapparat_release = device.getCameraRenderer$fotoapparat_release();
        cameraRenderer$fotoapparat_release.setScaleType(device.getScaleType$fotoapparat_release());
        cameraRenderer$fotoapparat_release.setPreviewResolution(previewResolution);
        FocalPointSelector focusPointSelector$fotoapparat_release = device.getFocusPointSelector$fotoapparat_release();
        if (focusPointSelector$fotoapparat_release != null) {
            focusPointSelector$fotoapparat_release.setFocalPointListener(new StartRoutineKt$start$2(device));
        }
        try {
            selectedCamera.setDisplaySurface(device.getCameraRenderer$fotoapparat_release().getPreview());
            selectedCamera.startPreview();
        } catch (IOException e) {
            Logger logger$fotoapparat_release = device.getLogger$fotoapparat_release();
            logger$fotoapparat_release.log("Can't start preview because of the exception: " + e);
        }
    }
}
