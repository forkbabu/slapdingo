package io.fotoapparat.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.itextpdf.text.html.HtmlTags;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001e\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0002\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u001f\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/fotoapparat/view/TextureAvailabilityListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "surface", HtmlTags.WIDTH, "", HtmlTags.HEIGHT, "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: TextureAvailabilityListener.kt */
public final class TextureAvailabilityListener implements TextureView.SurfaceTextureListener {
    private final Function1<SurfaceTexture, Unit> onSurfaceTextureAvailable;

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "surface");
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "surface");
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "surface");
    }

    public TextureAvailabilityListener(Function1<? super SurfaceTexture, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "onSurfaceTextureAvailable");
        this.onSurfaceTextureAvailable = function1;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "surface");
        this.onSurfaceTextureAvailable.invoke(surfaceTexture);
    }
}
