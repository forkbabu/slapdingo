package io.fotoapparat.routine.camera;

import io.fotoapparat.concurrent.CameraExecutor;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.metering.FocalRequest;
import io.fotoapparat.result.FocusResult;
import io.fotoapparat.routine.focus.FocusOnPointRoutineKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "focalRequest", "Lio/fotoapparat/hardware/metering/FocalRequest;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: StartRoutine.kt */
final class StartRoutineKt$start$2 extends Lambda implements Function1<FocalRequest, Unit> {
    final /* synthetic */ Device $this_start;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartRoutineKt$start$2(Device device) {
        super(1);
        this.$this_start = device;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FocalRequest focalRequest) {
        invoke(focalRequest);
        return Unit.INSTANCE;
    }

    public final void invoke(final FocalRequest focalRequest) {
        Intrinsics.checkParameterIsNotNull(focalRequest, "focalRequest");
        this.$this_start.getExecutor$fotoapparat_release().execute(new CameraExecutor.Operation(true, new Function0<FocusResult>(this) {
            /* class io.fotoapparat.routine.camera.StartRoutineKt$start$2.AnonymousClass1 */
            final /* synthetic */ StartRoutineKt$start$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final FocusResult invoke() {
                return FocusOnPointRoutineKt.focusOnPoint(this.this$0.$this_start, focalRequest);
            }
        }));
    }
}
