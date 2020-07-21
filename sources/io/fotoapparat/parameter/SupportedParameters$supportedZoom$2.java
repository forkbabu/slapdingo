package io.fotoapparat.parameter;

import io.fotoapparat.parameter.Zoom;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/fotoapparat/parameter/Zoom;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: SupportedParameters.kt */
final class SupportedParameters$supportedZoom$2 extends Lambda implements Function0<Zoom> {
    final /* synthetic */ SupportedParameters this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SupportedParameters$supportedZoom$2(SupportedParameters supportedParameters) {
        super(0);
        this.this$0 = supportedParameters;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Zoom invoke() {
        Zoom zoom;
        if (this.this$0.cameraParameters.isZoomSupported()) {
            int maxZoom = this.this$0.cameraParameters.getMaxZoom();
            List<Integer> zoomRatios = this.this$0.cameraParameters.getZoomRatios();
            Intrinsics.checkExpressionValueIsNotNull(zoomRatios, "cameraParameters.zoomRatios");
            zoom = new Zoom.VariableZoom(maxZoom, zoomRatios);
        } else {
            zoom = Zoom.FixedZoom.INSTANCE;
        }
        return zoom;
    }
}
