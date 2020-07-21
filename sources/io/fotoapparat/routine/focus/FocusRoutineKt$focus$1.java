package io.fotoapparat.routine.focus;

import io.fotoapparat.hardware.CameraDevice;
import io.fotoapparat.hardware.Device;
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
@DebugMetadata(c = "io/fotoapparat/routine/focus/FocusRoutineKt$focus$1", f = "FocusRoutine.kt", i = {}, l = {10, 13}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FocusRoutine.kt */
final class FocusRoutineKt$focus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FocusResult>, Object> {
    final /* synthetic */ Device $this_focus;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusRoutineKt$focus$1(Device device, Continuation continuation) {
        super(2, continuation);
        this.$this_focus = device;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        FocusRoutineKt$focus$1 focusRoutineKt$focus$1 = new FocusRoutineKt$focus$1(this.$this_focus, continuation);
        focusRoutineKt$focus$1.p$ = (CoroutineScope) obj;
        return focusRoutineKt$focus$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FocusResult> continuation) {
        return ((FocusRoutineKt$focus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (obj instanceof Result.Failure) {
                throw ((Result.Failure) obj).exception;
            }
        } else if (!(obj instanceof Result.Failure)) {
            Device device = this.$this_focus;
            this.label = 1;
            obj = device.awaitSelectedCamera(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Result.Failure) obj).exception;
        }
        return ((CameraDevice) obj).autoFocus();
    }
}
