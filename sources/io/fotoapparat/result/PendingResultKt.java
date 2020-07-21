package io.fotoapparat.result;

import io.fotoapparat.hardware.ExecutorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0002*\u0016\u0010\u0004\"\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0012\u0004\u0012\u00020\u00060\u0005*\u0016\u0010\u0007\"\b\u0012\u0004\u0012\u00020\b0\u00052\b\u0012\u0004\u0012\u00020\b0\u0005¨\u0006\t"}, d2 = {"notifyOnMainThread", "", "function", "Lkotlin/Function0;", "CapabilitiesResult", "Lio/fotoapparat/result/PendingResult;", "Lio/fotoapparat/capability/Capabilities;", "ParametersResult", "Lio/fotoapparat/parameter/camera/CameraParameters;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: PendingResult.kt */
public final class PendingResultKt {
    /* access modifiers changed from: private */
    public static final void notifyOnMainThread(Function0<Unit> function0) {
        ExecutorKt.executeMainThread(new PendingResultKt$notifyOnMainThread$1(function0));
    }
}
