package io.fotoapparat;

import io.fotoapparat.routine.camera.StartRoutineKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: Fotoapparat.kt */
final class Fotoapparat$start$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Fotoapparat this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Fotoapparat$start$1(Fotoapparat fotoapparat) {
        super(0);
        this.this$0 = fotoapparat;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        StartRoutineKt.bootStart(this.this$0.device, this.this$0.getOrientationSensor(), this.this$0.mainThreadErrorCallback);
    }
}
