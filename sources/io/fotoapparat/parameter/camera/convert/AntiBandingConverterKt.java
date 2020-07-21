package io.fotoapparat.parameter.camera.convert;

import io.fotoapparat.parameter.AntiBandingMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toAntiBandingMode", "Lio/fotoapparat/parameter/AntiBandingMode;", "", "toCode", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: AntiBandingConverter.kt */
public final class AntiBandingConverterKt {
    public static final AntiBandingMode toAntiBandingMode(String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        switch (str.hashCode()) {
            case 109935:
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    return AntiBandingMode.None.INSTANCE;
                }
                break;
            case 1628397:
                if (str.equals("50hz")) {
                    return AntiBandingMode.HZ50.INSTANCE;
                }
                break;
            case 1658188:
                if (str.equals("60hz")) {
                    return AntiBandingMode.HZ60.INSTANCE;
                }
                break;
            case 3005871:
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    return AntiBandingMode.Auto.INSTANCE;
                }
                break;
        }
        return null;
    }

    public static final String toCode(AntiBandingMode antiBandingMode) {
        Intrinsics.checkParameterIsNotNull(antiBandingMode, "receiver$0");
        if (Intrinsics.areEqual(antiBandingMode, AntiBandingMode.Auto.INSTANCE)) {
            return DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
        }
        if (Intrinsics.areEqual(antiBandingMode, AntiBandingMode.HZ50.INSTANCE)) {
            return "50hz";
        }
        if (Intrinsics.areEqual(antiBandingMode, AntiBandingMode.HZ60.INSTANCE)) {
            return "60hz";
        }
        if (Intrinsics.areEqual(antiBandingMode, AntiBandingMode.None.INSTANCE)) {
            return DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        throw new NoWhenBranchMatchedException();
    }
}
