package io.fotoapparat.error;

import io.fotoapparat.exception.camera.CameraException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004*\"\u0010\u0005\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0006"}, d2 = {"onMainThread", "Lkotlin/Function1;", "Lio/fotoapparat/exception/camera/CameraException;", "", "Lio/fotoapparat/error/CameraErrorCallback;", "CameraErrorCallback", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: ErrorCallbacks.kt */
public final class ErrorCallbacksKt {
    public static final Function1<CameraException, Unit> onMainThread(Function1<? super CameraException, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "receiver$0");
        return new ErrorCallbacksKt$onMainThread$1(function1);
    }
}
