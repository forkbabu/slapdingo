package io.fotoapparat;

import io.fotoapparat.error.CameraErrorListener;
import io.fotoapparat.exception.camera.CameraException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lio/fotoapparat/exception/camera/CameraException;", "invoke", "io/fotoapparat/FotoapparatBuilder$cameraErrorCallback$2$1"}, k = 3, mv = {1, 1, 13})
/* compiled from: FotoapparatBuilder.kt */
final class FotoapparatBuilder$cameraErrorCallback$$inlined$apply$lambda$1 extends Lambda implements Function1<CameraException, Unit> {
    final /* synthetic */ CameraErrorListener $callback$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FotoapparatBuilder$cameraErrorCallback$$inlined$apply$lambda$1(CameraErrorListener cameraErrorListener) {
        super(1);
        this.$callback$inlined = cameraErrorListener;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CameraException cameraException) {
        invoke(cameraException);
        return Unit.INSTANCE;
    }

    public final void invoke(CameraException cameraException) {
        Intrinsics.checkParameterIsNotNull(cameraException, "it");
        this.$callback$inlined.onError(cameraException);
    }
}
