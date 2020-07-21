package io.fotoapparat.routine.camera;

import io.fotoapparat.hardware.CameraDevice;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.parameter.camera.CameraParameters;
import io.fotoapparat.preview.Frame;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "io/fotoapparat/routine/camera/UpdateConfigurationRoutineKt$updateCameraConfiguration$1", f = "UpdateConfigurationRoutine.kt", i = {1, 1}, l = {24, 26, 32}, m = "invokeSuspend", n = {"cameraParameters", "frameProcessor"}, s = {"L$0", "L$1"})
/* compiled from: UpdateConfigurationRoutine.kt */
final class UpdateConfigurationRoutineKt$updateCameraConfiguration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraDevice $cameraDevice;
    final /* synthetic */ Device $this_updateCameraConfiguration;
    Object L$0;
    Object L$1;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateConfigurationRoutineKt$updateCameraConfiguration$1(Device device, CameraDevice cameraDevice, Continuation continuation) {
        super(2, continuation);
        this.$this_updateCameraConfiguration = device;
        this.$cameraDevice = cameraDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        UpdateConfigurationRoutineKt$updateCameraConfiguration$1 updateConfigurationRoutineKt$updateCameraConfiguration$1 = new UpdateConfigurationRoutineKt$updateCameraConfiguration$1(this.$this_updateCameraConfiguration, this.$cameraDevice, continuation);
        updateConfigurationRoutineKt$updateCameraConfiguration$1.p$ = (CoroutineScope) obj;
        return updateConfigurationRoutineKt$updateCameraConfiguration$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateConfigurationRoutineKt$updateCameraConfiguration$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function1<Frame, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    function1 = (Function1) this.L$1;
                    CameraParameters cameraParameters = (CameraParameters) this.L$0;
                    if (obj instanceof Result.Failure) {
                        throw ((Result.Failure) obj).exception;
                    }
                    this.$cameraDevice.updateFrameProcessor(function1);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (obj instanceof Result.Failure) {
                throw ((Result.Failure) obj).exception;
            }
        } else if (!(obj instanceof Result.Failure)) {
            Device device = this.$this_updateCameraConfiguration;
            CameraDevice cameraDevice = this.$cameraDevice;
            this.label = 1;
            obj = device.getCameraParameters(cameraDevice, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Result.Failure) obj).exception;
        }
        CameraParameters cameraParameters2 = (CameraParameters) obj;
        Function1<Frame, Unit> frameProcessor = this.$this_updateCameraConfiguration.getFrameProcessor();
        CameraDevice cameraDevice2 = this.$cameraDevice;
        this.L$0 = cameraParameters2;
        this.L$1 = frameProcessor;
        this.label = 2;
        if (cameraDevice2.updateParameters(cameraParameters2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        function1 = frameProcessor;
        this.$cameraDevice.updateFrameProcessor(function1);
        return Unit.INSTANCE;
    }
}
