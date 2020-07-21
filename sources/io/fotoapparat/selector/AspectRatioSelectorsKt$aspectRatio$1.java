package io.fotoapparat.selector;

import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lio/fotoapparat/parameter/Resolution;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: AspectRatioSelectors.kt */
final class AspectRatioSelectorsKt$aspectRatio$1 extends Lambda implements Function1<Resolution, Boolean> {
    final /* synthetic */ float $aspectRatio;
    final /* synthetic */ double $calculatedTolerance;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AspectRatioSelectorsKt$aspectRatio$1(double d, float f) {
        super(1);
        this.$calculatedTolerance = d;
        this.$aspectRatio = f;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Resolution resolution) {
        return Boolean.valueOf(invoke(resolution));
    }

    public final boolean invoke(Resolution resolution) {
        Intrinsics.checkParameterIsNotNull(resolution, "it");
        return ((double) Math.abs(this.$aspectRatio - resolution.getAspectRatio())) <= this.$calculatedTolerance;
    }
}
