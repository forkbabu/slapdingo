package io.fotoapparat.hardware;

import io.fotoapparat.characteristic.LensPosition;
import io.fotoapparat.configuration.CameraConfiguration;
import io.fotoapparat.configuration.Configuration;
import io.fotoapparat.parameter.Flash;
import io.fotoapparat.parameter.FocusMode;
import io.fotoapparat.parameter.FpsRange;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.preview.Frame;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032#\u0010\u0004\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0002`\b¢\u0006\u0002\b\tH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"selectCamera", "Lio/fotoapparat/hardware/CameraDevice;", "availableCameras", "", "lensPositionSelector", "Lkotlin/Function1;", "", "Lio/fotoapparat/characteristic/LensPosition;", "Lio/fotoapparat/selector/LensPositionSelector;", "Lkotlin/ExtensionFunctionType;", "updateConfiguration", "Lio/fotoapparat/configuration/CameraConfiguration;", "savedConfiguration", "newConfiguration", "Lio/fotoapparat/configuration/Configuration;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: Device.kt */
public final class DeviceKt {
    public static final CameraConfiguration updateConfiguration(CameraConfiguration cameraConfiguration, Configuration configuration) {
        Function1<Iterable<Resolution>, Resolution> function1;
        Intrinsics.checkParameterIsNotNull(cameraConfiguration, "savedConfiguration");
        Intrinsics.checkParameterIsNotNull(configuration, "newConfiguration");
        Function1<Iterable<? extends Flash>, Flash> flashMode = configuration.getFlashMode();
        if (flashMode == null) {
            flashMode = cameraConfiguration.getFlashMode();
        }
        Function1<Iterable<? extends FocusMode>, FocusMode> focusMode = configuration.getFocusMode();
        if (focusMode == null) {
            focusMode = cameraConfiguration.getFocusMode();
        }
        Function1<IntRange, Integer> exposureCompensation = configuration.getExposureCompensation();
        if (exposureCompensation == null) {
            exposureCompensation = cameraConfiguration.getExposureCompensation();
        }
        Function1<Frame, Unit> frameProcessor = configuration.getFrameProcessor();
        if (frameProcessor == null) {
            frameProcessor = cameraConfiguration.getFrameProcessor();
        }
        Function1<Iterable<FpsRange>, FpsRange> previewFpsRange = configuration.getPreviewFpsRange();
        if (previewFpsRange == null) {
            previewFpsRange = cameraConfiguration.getPreviewFpsRange();
        }
        Function1<Iterable<Integer>, Integer> sensorSensitivity = configuration.getSensorSensitivity();
        if (sensorSensitivity == null) {
            sensorSensitivity = cameraConfiguration.getSensorSensitivity();
        }
        Function1<Iterable<Resolution>, Resolution> pictureResolution = configuration.getPictureResolution();
        if (pictureResolution == null) {
            pictureResolution = cameraConfiguration.getPictureResolution();
        }
        Function1<Iterable<Resolution>, Resolution> previewResolution = configuration.getPreviewResolution();
        if (previewResolution != null) {
            function1 = previewResolution;
        } else {
            function1 = cameraConfiguration.getPreviewResolution();
        }
        return new CameraConfiguration(flashMode, focusMode, null, exposureCompensation, frameProcessor, previewFpsRange, null, sensorSensitivity, pictureResolution, function1, 68, null);
    }

    public static final CameraDevice selectCamera(List<? extends CameraDevice> list, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(list, "availableCameras");
        Intrinsics.checkParameterIsNotNull(function1, "lensPositionSelector");
        Iterable<CameraDevice> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (CameraDevice cameraDevice : iterable) {
            arrayList.add(cameraDevice.getCharacteristics().getLensPosition());
        }
        LensPosition lensPosition = (LensPosition) function1.invoke(CollectionsKt.toSet((List) arrayList));
        Iterator it2 = iterable.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual(((CameraDevice) obj).getCharacteristics().getLensPosition(), lensPosition)) {
                break;
            }
        }
        return (CameraDevice) obj;
    }
}
