package io.fotoapparat.parameter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/ranges/IntRange;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: SupportedParameters.kt */
final class SupportedParameters$jpegQualityRange$2 extends Lambda implements Function0<IntRange> {
    public static final SupportedParameters$jpegQualityRange$2 INSTANCE = new SupportedParameters$jpegQualityRange$2();

    SupportedParameters$jpegQualityRange$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final IntRange invoke() {
        return new IntRange(0, 100);
    }
}
