package io.fotoapparat.parameter.camera.convert;

import io.fotoapparat.parameter.Flash;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"toCode", "", "Lio/fotoapparat/parameter/Flash;", "toFlash", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: FlashConverter.kt */
public final class FlashConverterKt {
    public static final Flash toFlash(String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        switch (str.hashCode()) {
            case 3551:
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    return Flash.On.INSTANCE;
                }
                break;
            case 109935:
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    return Flash.Off.INSTANCE;
                }
                break;
            case 3005871:
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    return Flash.Auto.INSTANCE;
                }
                break;
            case 110547964:
                if (str.equals("torch")) {
                    return Flash.Torch.INSTANCE;
                }
                break;
            case 1081542389:
                if (str.equals("red-eye")) {
                    return Flash.AutoRedEye.INSTANCE;
                }
                break;
        }
        return null;
    }

    public static final String toCode(Flash flash) {
        Intrinsics.checkParameterIsNotNull(flash, "receiver$0");
        if (Intrinsics.areEqual(flash, Flash.On.INSTANCE)) {
            return DebugKt.DEBUG_PROPERTY_VALUE_ON;
        }
        if (Intrinsics.areEqual(flash, Flash.Off.INSTANCE)) {
            return DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        if (Intrinsics.areEqual(flash, Flash.Auto.INSTANCE)) {
            return DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
        }
        if (Intrinsics.areEqual(flash, Flash.Torch.INSTANCE)) {
            return "torch";
        }
        if (Intrinsics.areEqual(flash, Flash.AutoRedEye.INSTANCE)) {
            return "red-eye";
        }
        throw new NoWhenBranchMatchedException();
    }
}
