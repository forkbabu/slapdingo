package io.fotoapparat.parameter.camera.convert;

import io.fotoapparat.parameter.FpsRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toFpsRange", "Lio/fotoapparat/parameter/FpsRange;", "", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: FpsRangeConverter.kt */
public final class FpsRangeConverterKt {
    public static final FpsRange toFpsRange(int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return new FpsRange(iArr[0], iArr[1]);
    }
}
