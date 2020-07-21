package io.fotoapparat.parameter;

import android.hardware.Camera;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a6\u0012\u0014\u0012\u0012 \u0004*\b\u0018\u00010\u0002R\u00020\u00030\u0002R\u00020\u0003 \u0004*\u001a\u0012\u0014\u0012\u0012 \u0004*\b\u0018\u00010\u0002R\u00020\u00030\u0002R\u00020\u0003\u0018\u00010\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: SupportedParameters.kt */
final class SupportedParameters$previewResolutions$2 extends Lambda implements Function0<List<Camera.Size>> {
    final /* synthetic */ SupportedParameters this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SupportedParameters$previewResolutions$2(SupportedParameters supportedParameters) {
        super(0);
        this.this$0 = supportedParameters;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<Camera.Size> invoke() {
        return this.this$0.cameraParameters.getSupportedPreviewSizes();
    }
}
