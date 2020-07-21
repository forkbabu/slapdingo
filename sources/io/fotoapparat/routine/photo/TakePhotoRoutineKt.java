package io.fotoapparat.routine.photo;

import io.fotoapparat.exception.camera.CameraException;
import io.fotoapparat.hardware.CameraDevice;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.result.Photo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"startPreviewSafely", "", "Lio/fotoapparat/hardware/CameraDevice;", "takePhoto", "Lio/fotoapparat/result/Photo;", "Lio/fotoapparat/hardware/Device;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: TakePhotoRoutine.kt */
public final class TakePhotoRoutineKt {
    public static final Photo takePhoto(Device device) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        return (Photo) BuildersKt__BuildersKt.runBlocking$default(null, new TakePhotoRoutineKt$takePhoto$1(device, null), 1, null);
    }

    /* access modifiers changed from: private */
    public static final void startPreviewSafely(CameraDevice cameraDevice) {
        try {
            cameraDevice.startPreview();
        } catch (CameraException unused) {
        }
    }
}
