package io.fotoapparat.routine.zoom;

import io.fotoapparat.exception.LevelOutOfRangeException;
import io.fotoapparat.hardware.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0002H\u0000¨\u0006\u0006"}, d2 = {"ensureInBounds", "", "", "updateZoomLevel", "Lio/fotoapparat/hardware/Device;", "zoomLevel", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: UpdateZoomLevelRoutine.kt */
public final class UpdateZoomLevelRoutineKt {
    public static final void updateZoomLevel(Device device, float f) {
        Intrinsics.checkParameterIsNotNull(device, "receiver$0");
        Object unused = BuildersKt__BuildersKt.runBlocking$default(null, new UpdateZoomLevelRoutineKt$updateZoomLevel$1(device, f, null), 1, null);
    }

    /* access modifiers changed from: private */
    public static final void ensureInBounds(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new LevelOutOfRangeException(f);
        }
    }
}
