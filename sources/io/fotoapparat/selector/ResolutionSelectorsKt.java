package io.fotoapparat.selector;

import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005\u001a#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004¢\u0006\u0002\b\u0005*<\u0010\u0007\"\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0002\b\u00052\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0002\b\u0005¨\u0006\b"}, d2 = {"highestResolution", "Lkotlin/Function1;", "", "Lio/fotoapparat/parameter/Resolution;", "Lio/fotoapparat/selector/ResolutionSelector;", "Lkotlin/ExtensionFunctionType;", "lowestResolution", "ResolutionSelector", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: ResolutionSelectors.kt */
public final class ResolutionSelectorsKt {
    public static final Function1<Iterable<Resolution>, Resolution> highestResolution() {
        return ResolutionSelectorsKt$highestResolution$1.INSTANCE;
    }

    public static final Function1<Iterable<Resolution>, Resolution> lowestResolution() {
        return ResolutionSelectorsKt$lowestResolution$1.INSTANCE;
    }
}
