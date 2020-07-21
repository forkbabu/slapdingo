package io.fotoapparat.view;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import io.fotoapparat.view.Preview;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toPreview", "Lio/fotoapparat/view/Preview$Texture;", "Landroid/graphics/SurfaceTexture;", "Lio/fotoapparat/view/Preview$Surface;", "Landroid/view/SurfaceHolder;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: Preview.kt */
public final class PreviewKt {
    public static final Preview.Texture toPreview(SurfaceTexture surfaceTexture) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "receiver$0");
        return new Preview.Texture(surfaceTexture);
    }

    public static final Preview.Surface toPreview(SurfaceHolder surfaceHolder) {
        Intrinsics.checkParameterIsNotNull(surfaceHolder, "receiver$0");
        return new Preview.Surface(surfaceHolder);
    }
}
