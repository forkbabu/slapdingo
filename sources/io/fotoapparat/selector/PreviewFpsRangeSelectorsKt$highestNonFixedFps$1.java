package io.fotoapparat.selector;

import io.fotoapparat.parameter.FpsRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lio/fotoapparat/parameter/FpsRange;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: PreviewFpsRangeSelectors.kt */
final class PreviewFpsRangeSelectorsKt$highestNonFixedFps$1 extends Lambda implements Function1<FpsRange, Boolean> {
    public static final PreviewFpsRangeSelectorsKt$highestNonFixedFps$1 INSTANCE = new PreviewFpsRangeSelectorsKt$highestNonFixedFps$1();

    PreviewFpsRangeSelectorsKt$highestNonFixedFps$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FpsRange fpsRange) {
        return Boolean.valueOf(invoke(fpsRange));
    }

    public final boolean invoke(FpsRange fpsRange) {
        Intrinsics.checkParameterIsNotNull(fpsRange, "it");
        return !fpsRange.isFixed();
    }
}
