package io.fotoapparat.selector;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a%\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\u0003*0\u0010\t\"\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0002\b\u00052\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0002\b\u0005¨\u0006\n"}, d2 = {"highestQuality", "Lkotlin/Function1;", "Lkotlin/ranges/IntRange;", "", "Lio/fotoapparat/selector/QualitySelector;", "Lkotlin/ExtensionFunctionType;", "lowestQuality", "manualJpegQuality", "quality", "QualitySelector", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: JpegQualitySelectors.kt */
public final class JpegQualitySelectorsKt {
    public static final Function1<IntRange, Integer> manualJpegQuality(int i) {
        return SelectorsKt.single(Integer.valueOf(i));
    }

    public static final Function1<IntRange, Integer> highestQuality() {
        return SelectorsKt.highest();
    }

    public static final Function1<IntRange, Integer> lowestQuality() {
        return SelectorsKt.lowest();
    }
}
