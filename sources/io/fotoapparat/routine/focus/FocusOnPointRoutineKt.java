package io.fotoapparat.routine.focus;

import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.metering.FocalRequest;
import io.fotoapparat.result.FocusResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"focusOnPoint", "Lio/fotoapparat/result/FocusResult;", "Lio/fotoapparat/hardware/Device;", "focalRequest", "Lio/fotoapparat/hardware/metering/FocalRequest;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: FocusOnPointRoutine.kt */
public final class FocusOnPointRoutineKt {
    public static final FocusResult focusOnPoint(Device device, FocalRequest focalRequest) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Intrinsics.checkParameterIsNotNull(focalRequest, "focalRequest");
        return (FocusResult) BuildersKt__BuildersKt.runBlocking$default(null, new FocusOnPointRoutineKt$focusOnPoint$1(device, focalRequest, null), 1, null);
    }
}
