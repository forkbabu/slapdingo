package io.fotoapparat.preview;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
/* compiled from: PreviewStream.kt */
final class PreviewStream$dispatchFrameOnBackgroundThread$1 implements Runnable {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ PreviewStream this$0;

    PreviewStream$dispatchFrameOnBackgroundThread$1(PreviewStream previewStream, byte[] bArr) {
        this.this$0 = previewStream;
        this.$data = bArr;
    }

    public final void run() {
        synchronized (this.this$0.frameProcessors) {
            this.this$0.dispatchFrame(this.$data);
            Unit unit = Unit.INSTANCE;
        }
    }
}
