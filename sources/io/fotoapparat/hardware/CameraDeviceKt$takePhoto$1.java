package io.fotoapparat.hardware;

import android.hardware.Camera;
import io.fotoapparat.result.Photo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPictureTaken"}, k = 3, mv = {1, 1, 13})
/* compiled from: CameraDevice.kt */
final class CameraDeviceKt$takePhoto$1 implements Camera.PictureCallback {
    final /* synthetic */ int $imageRotation;
    final /* synthetic */ CountDownLatch $latch;
    final /* synthetic */ AtomicReference $photoReference;

    CameraDeviceKt$takePhoto$1(AtomicReference atomicReference, int i, CountDownLatch countDownLatch) {
        this.$photoReference = atomicReference;
        this.$imageRotation = i;
        this.$latch = countDownLatch;
    }

    public final void onPictureTaken(byte[] bArr, Camera camera) {
        AtomicReference atomicReference = this.$photoReference;
        Intrinsics.checkExpressionValueIsNotNull(bArr, "data");
        atomicReference.set(new Photo(bArr, this.$imageRotation));
        this.$latch.countDown();
    }
}
