package io.fotoapparat.selector;

import io.fotoapparat.parameter.FpsRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a+\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a#\u0010\t\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a#\u0010\n\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a#\u0010\u000b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a%\u0010\f\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005H\u0002\u001a#\u0010\r\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a#\u0010\u000e\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a#\u0010\u000f\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a%\u0010\u0010\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0007H\u0002*<\u0010\u0013\"\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0002\b\u00052\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0002\b\u0005¨\u0006\u0014"}, d2 = {"containsFps", "Lkotlin/Function1;", "", "Lio/fotoapparat/parameter/FpsRange;", "Lio/fotoapparat/selector/FpsRangeSelector;", "Lkotlin/ExtensionFunctionType;", "fps", "", "exactFixedFps", "highestFixedFps", "highestFps", "highestNonFixedFps", "highestRangeFps", "lowestFixedFps", "lowestFps", "lowestNonFixedFps", "lowestRangeFps", "toFpsIntRepresentation", "", "FpsRangeSelector", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: PreviewFpsRangeSelectors.kt */
public final class PreviewFpsRangeSelectorsKt {
    /* access modifiers changed from: private */
    public static final int toFpsIntRepresentation(float f) {
        return (int) (f * ((float) 1000));
    }

    public static final Function1<Iterable<FpsRange>, FpsRange> containsFps(float f) {
        return SelectorsKt.firstAvailable(exactFixedFps(f), SelectorsKt.filtered(highestNonFixedFps(), new PreviewFpsRangeSelectorsKt$containsFps$1(f)));
    }

    public static final Function1<Iterable<FpsRange>, FpsRange> exactFixedFps(float f) {
        return SelectorsKt.filtered(highestFixedFps(), new PreviewFpsRangeSelectorsKt$exactFixedFps$1(f));
    }

    public static final Function1<Iterable<FpsRange>, FpsRange> highestFps() {
        return SelectorsKt.firstAvailable(highestNonFixedFps(), highestFixedFps());
    }

    public static final Function1<Iterable<FpsRange>, FpsRange> highestNonFixedFps() {
        return SelectorsKt.filtered(highestRangeFps(), PreviewFpsRangeSelectorsKt$highestNonFixedFps$1.INSTANCE);
    }

    public static final Function1<Iterable<FpsRange>, FpsRange> highestFixedFps() {
        return SelectorsKt.filtered(highestRangeFps(), PreviewFpsRangeSelectorsKt$highestFixedFps$1.INSTANCE);
    }

    public static final Function1<Iterable<FpsRange>, FpsRange> lowestFps() {
        return SelectorsKt.firstAvailable(lowestNonFixedFps(), lowestFixedFps());
    }

    public static final Function1<Iterable<FpsRange>, FpsRange> lowestNonFixedFps() {
        return SelectorsKt.filtered(lowestRangeFps(), PreviewFpsRangeSelectorsKt$lowestNonFixedFps$1.INSTANCE);
    }

    public static final Function1<Iterable<FpsRange>, FpsRange> lowestFixedFps() {
        return SelectorsKt.filtered(lowestRangeFps(), PreviewFpsRangeSelectorsKt$lowestFixedFps$1.INSTANCE);
    }

    private static final Function1<Iterable<FpsRange>, FpsRange> highestRangeFps() {
        return PreviewFpsRangeSelectorsKt$highestRangeFps$1.INSTANCE;
    }

    private static final Function1<Iterable<FpsRange>, FpsRange> lowestRangeFps() {
        return PreviewFpsRangeSelectorsKt$lowestRangeFps$1.INSTANCE;
    }
}
