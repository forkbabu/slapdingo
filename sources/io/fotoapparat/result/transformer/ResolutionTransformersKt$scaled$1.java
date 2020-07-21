package io.fotoapparat.result.transformer;

import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/fotoapparat/parameter/Resolution;", "input", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: ResolutionTransformers.kt */
final class ResolutionTransformersKt$scaled$1 extends Lambda implements Function1<Resolution, Resolution> {
    final /* synthetic */ float $scaleFactor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ResolutionTransformersKt$scaled$1(float f) {
        super(1);
        this.$scaleFactor = f;
    }

    public final Resolution invoke(Resolution resolution) {
        Intrinsics.checkParameterIsNotNull(resolution, "input");
        return new Resolution((int) (((float) resolution.width) * this.$scaleFactor), (int) (((float) resolution.height) * this.$scaleFactor));
    }
}
