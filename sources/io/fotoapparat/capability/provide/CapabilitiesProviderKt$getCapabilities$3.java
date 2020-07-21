package io.fotoapparat.capability.provide;

import io.fotoapparat.parameter.AntiBandingMode;
import io.fotoapparat.parameter.camera.convert.AntiBandingConverterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/fotoapparat/parameter/AntiBandingMode;", "p1", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: CapabilitiesProvider.kt */
final class CapabilitiesProviderKt$getCapabilities$3 extends FunctionReference implements Function1<String, AntiBandingMode> {
    public static final CapabilitiesProviderKt$getCapabilities$3 INSTANCE = new CapabilitiesProviderKt$getCapabilities$3();

    CapabilitiesProviderKt$getCapabilities$3() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "toAntiBandingMode";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(AntiBandingConverterKt.class, "fotoapparat_release");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "toAntiBandingMode(Ljava/lang/String;)Lio/fotoapparat/parameter/AntiBandingMode;";
    }

    public final AntiBandingMode invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "p1");
        return AntiBandingConverterKt.toAntiBandingMode(str);
    }
}
