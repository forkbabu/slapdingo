package io.fotoapparat.selector;

import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\\\u0010\u0002\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u00072\u0006\u0010\u0002\u001a\u00020\b2#\u0010\t\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u00072\b\b\u0003\u0010\n\u001a\u00020\u0001H\u0007\u001aT\u0010\u000b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u00072#\u0010\t\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u00072\b\b\u0003\u0010\n\u001a\u00020\u0001H\u0007\u001aT\u0010\f\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u00072#\u0010\t\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u00072\b\b\u0003\u0010\n\u001a\u00020\u0001H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"ASPECT_RATIO_EPSILON", "", "aspectRatio", "Lkotlin/Function1;", "", "Lio/fotoapparat/parameter/Resolution;", "Lio/fotoapparat/selector/ResolutionSelector;", "Lkotlin/ExtensionFunctionType;", "", "selector", "tolerance", "standardRatio", "wideRatio", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: AspectRatioSelectors.kt */
public final class AspectRatioSelectorsKt {
    private static final double ASPECT_RATIO_EPSILON = 1.0E-4d;

    public static final Function1<Iterable<Resolution>, Resolution> aspectRatio(float f, Function1<? super Iterable<Resolution>, Resolution> function1) {
        return aspectRatio$default(f, function1, 0.0d, 4, null);
    }

    public static final Function1<Iterable<Resolution>, Resolution> standardRatio(Function1<? super Iterable<Resolution>, Resolution> function1) {
        return standardRatio$default(function1, 0.0d, 2, null);
    }

    public static final Function1<Iterable<Resolution>, Resolution> wideRatio(Function1<? super Iterable<Resolution>, Resolution> function1) {
        return wideRatio$default(function1, 0.0d, 2, null);
    }

    public static /* synthetic */ Function1 standardRatio$default(Function1 function1, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return standardRatio(function1, d);
    }

    public static final Function1<Iterable<Resolution>, Resolution> standardRatio(Function1<? super Iterable<Resolution>, Resolution> function1, double d) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return aspectRatio(1.3333334f, function1, d);
    }

    public static /* synthetic */ Function1 wideRatio$default(Function1 function1, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return wideRatio(function1, d);
    }

    public static final Function1<Iterable<Resolution>, Resolution> wideRatio(Function1<? super Iterable<Resolution>, Resolution> function1, double d) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return aspectRatio(1.7777778f, function1, d);
    }

    public static /* synthetic */ Function1 aspectRatio$default(float f, Function1 function1, double d, int i, Object obj) {
        if ((i & 4) != 0) {
            d = 0.0d;
        }
        return aspectRatio(f, function1, d);
    }

    public static final Function1<Iterable<Resolution>, Resolution> aspectRatio(float f, Function1<? super Iterable<Resolution>, Resolution> function1, double d) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        if (d >= 0.0d && d <= 1.0d) {
            return SelectorsKt.filtered(function1, new AspectRatioSelectorsKt$aspectRatio$1((((double) f) * d) + ASPECT_RATIO_EPSILON, f));
        }
        throw new IllegalArgumentException("Tolerance must be between 0.0 and 1.0.");
    }
}
