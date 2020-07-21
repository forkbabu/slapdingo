package io.fotoapparat.parameter.camera.convert;

import android.hardware.Camera;
import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u00060\u0002R\u00020\u0003¨\u0006\u0004"}, d2 = {"toResolution", "Lio/fotoapparat/parameter/Resolution;", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: ResolutionConverter.kt */
public final class ResolutionConverterKt {
    public static final Resolution toResolution(Camera.Size size) {
        Intrinsics.checkParameterIsNotNull(size, "receiver$0");
        return new Resolution(size.width, size.height);
    }
}
