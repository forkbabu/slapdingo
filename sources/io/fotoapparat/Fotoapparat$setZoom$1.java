package io.fotoapparat;

import io.fotoapparat.routine.zoom.UpdateZoomLevelRoutineKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: Fotoapparat.kt */
final class Fotoapparat$setZoom$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ float $zoomLevel;
    final /* synthetic */ Fotoapparat this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Fotoapparat$setZoom$1(Fotoapparat fotoapparat, float f) {
        super(0);
        this.this$0 = fotoapparat;
        this.$zoomLevel = f;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.logger.recordMethod();
        UpdateZoomLevelRoutineKt.updateZoomLevel(this.this$0.device, this.$zoomLevel);
    }
}
