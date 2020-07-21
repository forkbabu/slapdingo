package io.fotoapparat.capability.provide;

import io.fotoapparat.parameter.FpsRange;
import io.fotoapparat.parameter.camera.convert.FpsRangeConverterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/fotoapparat/parameter/FpsRange;", "it", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: CapabilitiesProvider.kt */
final class CapabilitiesProviderKt$getCapabilities$4 extends Lambda implements Function1<int[], FpsRange> {
    public static final CapabilitiesProviderKt$getCapabilities$4 INSTANCE = new CapabilitiesProviderKt$getCapabilities$4();

    CapabilitiesProviderKt$getCapabilities$4() {
        super(1);
    }

    public final FpsRange invoke(int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "it");
        return FpsRangeConverterKt.toFpsRange(iArr);
    }
}
