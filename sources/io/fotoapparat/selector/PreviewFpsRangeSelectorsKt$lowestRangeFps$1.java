package io.fotoapparat.selector;

import io.fotoapparat.parameter.FpsRange;
import io.fotoapparat.util.CompareFpsRangeByBounds;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/fotoapparat/parameter/FpsRange;", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: PreviewFpsRangeSelectors.kt */
final class PreviewFpsRangeSelectorsKt$lowestRangeFps$1 extends Lambda implements Function1<Iterable<? extends FpsRange>, FpsRange> {
    public static final PreviewFpsRangeSelectorsKt$lowestRangeFps$1 INSTANCE = new PreviewFpsRangeSelectorsKt$lowestRangeFps$1();

    PreviewFpsRangeSelectorsKt$lowestRangeFps$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ FpsRange invoke(Iterable<? extends FpsRange> iterable) {
        return invoke((Iterable<FpsRange>) iterable);
    }

    public final FpsRange invoke(Iterable<FpsRange> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return (FpsRange) CollectionsKt.minWith(iterable, CompareFpsRangeByBounds.INSTANCE);
    }
}
