package io.fotoapparat.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroid/graphics/SurfaceTexture;", "invoke", "io/fotoapparat/view/CameraView$tryInitialize$1$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: CameraView.kt */
final class CameraView$tryInitialize$$inlined$also$lambda$1 extends Lambda implements Function1<SurfaceTexture, Unit> {
    final /* synthetic */ TextureView $this_tryInitialize$inlined;
    final /* synthetic */ CameraView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraView$tryInitialize$$inlined$also$lambda$1(CameraView cameraView, TextureView textureView) {
        super(1);
        this.this$0 = cameraView;
        this.$this_tryInitialize$inlined = textureView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SurfaceTexture surfaceTexture) {
        invoke(surfaceTexture);
        return Unit.INSTANCE;
    }

    public final void invoke(SurfaceTexture surfaceTexture) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "receiver$0");
        this.this$0.surfaceTexture = surfaceTexture;
        this.this$0.textureLatch.countDown();
    }
}
