package io.fotoapparat.hardware;

import android.hardware.Camera;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "onAutoFocus"}, k = 3, mv = {1, 1, 13})
/* compiled from: CameraDevice.kt */
final class CameraDevice$focusSafely$1 implements Camera.AutoFocusCallback {
    final /* synthetic */ CountDownLatch $latch;

    CameraDevice$focusSafely$1(CountDownLatch countDownLatch) {
        this.$latch = countDownLatch;
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        this.$latch.countDown();
    }
}
