package io.fotoapparat.error;

import android.os.Looper;
import io.fotoapparat.exception.camera.CameraException;
import io.fotoapparat.hardware.ExecutorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cameraException", "Lio/fotoapparat/exception/camera/CameraException;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: ErrorCallbacks.kt */
final class ErrorCallbacksKt$onMainThread$1 extends Lambda implements Function1<CameraException, Unit> {
    final /* synthetic */ Function1 $this_onMainThread;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ErrorCallbacksKt$onMainThread$1(Function1 function1) {
        super(1);
        this.$this_onMainThread = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CameraException cameraException) {
        invoke(cameraException);
        return Unit.INSTANCE;
    }

    public final void invoke(final CameraException cameraException) {
        Intrinsics.checkParameterIsNotNull(cameraException, "cameraException");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.$this_onMainThread.invoke(cameraException);
        } else {
            ExecutorKt.executeMainThread(new Function0<Unit>(this) {
                /* class io.fotoapparat.error.ErrorCallbacksKt$onMainThread$1.AnonymousClass1 */
                final /* synthetic */ ErrorCallbacksKt$onMainThread$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    this.this$0.$this_onMainThread.invoke(cameraException);
                }
            });
        }
    }
}
