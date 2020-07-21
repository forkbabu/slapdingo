package io.fotoapparat.capability.provide;

import io.fotoapparat.parameter.Flash;
import io.fotoapparat.parameter.camera.convert.FlashConverterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/fotoapparat/parameter/Flash;", "it", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: CapabilitiesProvider.kt */
final class CapabilitiesProviderKt$getCapabilities$1 extends Lambda implements Function1<String, Flash> {
    public static final CapabilitiesProviderKt$getCapabilities$1 INSTANCE = new CapabilitiesProviderKt$getCapabilities$1();

    CapabilitiesProviderKt$getCapabilities$1() {
        super(1);
    }

    public final Flash invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        return FlashConverterKt.toFlash(str);
    }
}
