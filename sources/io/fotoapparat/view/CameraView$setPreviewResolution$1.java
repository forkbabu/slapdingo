package io.fotoapparat.view;

import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
/* compiled from: CameraView.kt */
final class CameraView$setPreviewResolution$1 implements Runnable {
    final /* synthetic */ Resolution $resolution;
    final /* synthetic */ CameraView this$0;

    CameraView$setPreviewResolution$1(CameraView cameraView, Resolution resolution) {
        this.this$0 = cameraView;
        this.$resolution = resolution;
    }

    public final void run() {
        this.this$0.previewResolution = this.$resolution;
        this.this$0.requestLayout();
    }
}
