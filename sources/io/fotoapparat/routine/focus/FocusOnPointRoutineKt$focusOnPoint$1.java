package io.fotoapparat.routine.focus;

import io.fotoapparat.hardware.CameraDevice;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.metering.FocalRequest;
import io.fotoapparat.result.FocusResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lio/fotoapparat/result/FocusResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "io/fotoapparat/routine/focus/FocusOnPointRoutineKt$focusOnPoint$1", f = "FocusOnPointRoutine.kt", i = {1}, l = {11, 13, 15}, m = "invokeSuspend", n = {"$receiver"}, s = {"L$0"})
/* compiled from: FocusOnPointRoutine.kt */
final class FocusOnPointRoutineKt$focusOnPoint$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FocusResult>, Object> {
    final /* synthetic */ FocalRequest $focalRequest;
    final /* synthetic */ Device $this_focusOnPoint;
    Object L$0;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusOnPointRoutineKt$focusOnPoint$1(Device device, FocalRequest focalRequest, Continuation continuation) {
        super(2, continuation);
        this.$this_focusOnPoint = device;
        this.$focalRequest = focalRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        FocusOnPointRoutineKt$focusOnPoint$1 focusOnPointRoutineKt$focusOnPoint$1 = new FocusOnPointRoutineKt$focusOnPoint$1(this.$this_focusOnPoint, this.$focalRequest, continuation);
        focusOnPointRoutineKt$focusOnPoint$1.p$ = (CoroutineScope) obj;
        return focusOnPointRoutineKt$focusOnPoint$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FocusResult> continuation) {
        return ((FocusOnPointRoutineKt$focusOnPoint$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CameraDevice cameraDevice;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    cameraDevice = (CameraDevice) this.L$0;
                    if (obj instanceof Result.Failure) {
                        throw ((Result.Failure) obj).exception;
                    }
                    return cameraDevice.autoFocus();
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (obj instanceof Result.Failure) {
                throw ((Result.Failure) obj).exception;
            }
        } else if (!(obj instanceof Result.Failure)) {
            Device device = this.$this_focusOnPoint;
            this.label = 1;
            obj = device.awaitSelectedCamera(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Result.Failure) obj).exception;
        }
        CameraDevice cameraDevice2 = (CameraDevice) obj;
        FocalRequest focalRequest = this.$focalRequest;
        this.L$0 = cameraDevice2;
        this.label = 2;
        if (cameraDevice2.setFocalPoint(focalRequest, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        cameraDevice = cameraDevice2;
        return cameraDevice.autoFocus();
    }
}
