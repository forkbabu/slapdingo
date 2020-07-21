package io.fotoapparat.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.itextpdf.text.html.HtmlTags;
import io.fotoapparat.exception.camera.UnavailableSurfaceException;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.parameter.ScaleType;
import io.fotoapparat.view.Preview;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J0\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0014J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010$\u001a\u0004\u0018\u00010\u000f*\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/fotoapparat/view/CameraView;", "Landroid/widget/FrameLayout;", "Lio/fotoapparat/view/CameraRenderer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "previewResolution", "Lio/fotoapparat/parameter/Resolution;", "scaleType", "Lio/fotoapparat/parameter/ScaleType;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "textureLatch", "Ljava/util/concurrent/CountDownLatch;", "textureView", "Landroid/view/TextureView;", "getPreview", "Lio/fotoapparat/view/Preview;", "getPreviewAfterLatch", "Lio/fotoapparat/view/Preview$Texture;", "onDetachedFromWindow", "", "onLayout", "changed", "", HtmlTags.ALIGN_LEFT, HtmlTags.ALIGN_TOP, HtmlTags.ALIGN_RIGHT, HtmlTags.ALIGN_BOTTOM, "setPreviewResolution", "resolution", "setScaleType", "tryInitialize", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: CameraView.kt */
public final class CameraView extends FrameLayout implements CameraRenderer {
    /* access modifiers changed from: private */
    public Resolution previewResolution;
    /* access modifiers changed from: private */
    public ScaleType scaleType;
    /* access modifiers changed from: private */
    public SurfaceTexture surfaceTexture;
    /* access modifiers changed from: private */
    public final CountDownLatch textureLatch;
    private final TextureView textureView;

    public CameraView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public static final /* synthetic */ Resolution access$getPreviewResolution$p(CameraView cameraView) {
        Resolution resolution = cameraView.previewResolution;
        if (resolution == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewResolution");
        }
        return resolution;
    }

    public static final /* synthetic */ ScaleType access$getScaleType$p(CameraView cameraView) {
        ScaleType scaleType2 = cameraView.scaleType;
        if (scaleType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaleType");
        }
        return scaleType2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CameraView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.textureLatch = new CountDownLatch(1);
        TextureView textureView2 = new TextureView(context);
        this.textureView = textureView2;
        this.surfaceTexture = tryInitialize(textureView2);
        addView(this.textureView);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.textureLatch.countDown();
    }

    @Override // io.fotoapparat.view.CameraRenderer
    public void setScaleType(ScaleType scaleType2) {
        Intrinsics.checkParameterIsNotNull(scaleType2, "scaleType");
        this.scaleType = scaleType2;
    }

    @Override // io.fotoapparat.view.CameraRenderer
    public void setPreviewResolution(Resolution resolution) {
        Intrinsics.checkParameterIsNotNull(resolution, "resolution");
        post(new CameraView$setPreviewResolution$1(this, resolution));
    }

    @Override // io.fotoapparat.view.CameraRenderer
    public Preview getPreview() {
        Preview.Texture texture;
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 == null || (texture = PreviewKt.toPreview(surfaceTexture2)) == null) {
            texture = getPreviewAfterLatch();
        }
        return texture;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!isInEditMode()) {
            CameraView cameraView = this;
            if (!(cameraView.previewResolution == null || cameraView.scaleType == null)) {
                Resolution resolution = this.previewResolution;
                if (resolution == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewResolution");
                }
                ScaleType scaleType2 = this.scaleType;
                if (scaleType2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scaleType");
                }
                Unit unused = CameraViewKt.layoutTextureView(this, resolution, scaleType2);
                return;
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    private final Preview.Texture getPreviewAfterLatch() {
        Preview.Texture preview;
        this.textureLatch.await();
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null && (preview = PreviewKt.toPreview(surfaceTexture2)) != null) {
            return preview;
        }
        throw new UnavailableSurfaceException();
    }

    private final SurfaceTexture tryInitialize(TextureView textureView2) {
        SurfaceTexture surfaceTexture2 = textureView2.getSurfaceTexture();
        if (surfaceTexture2 != null) {
            return surfaceTexture2;
        }
        textureView2.setSurfaceTextureListener(new TextureAvailabilityListener(new CameraView$tryInitialize$$inlined$also$lambda$1(this, textureView2)));
        return null;
    }
}
