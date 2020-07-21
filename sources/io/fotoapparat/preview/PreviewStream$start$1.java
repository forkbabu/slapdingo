package io.fotoapparat.preview;

import android.hardware.Camera;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame"}, k = 3, mv = {1, 1, 13})
/* compiled from: PreviewStream.kt */
final class PreviewStream$start$1 implements Camera.PreviewCallback {
    final /* synthetic */ PreviewStream this$0;

    PreviewStream$start$1(PreviewStream previewStream) {
        this.this$0 = previewStream;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        PreviewStream previewStream = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(bArr, "data");
        previewStream.dispatchFrameOnBackgroundThread(bArr);
    }
}
