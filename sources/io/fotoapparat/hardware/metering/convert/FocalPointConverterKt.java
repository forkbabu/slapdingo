package io.fotoapparat.hardware.metering.convert;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import io.fotoapparat.hardware.metering.FocalRequest;
import io.fotoapparat.hardware.metering.PointF;
import io.fotoapparat.parameter.Resolution;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\f\u0010\u0011\u001a\u00020\u0003*\u00020\u0001H\u0002\u001a\u001c\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0006H\u0002\u001a\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\u00020\u00142\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"CAMERA_BOUNDS_RANGE", "", "FOCUS_AREA_HALF_SIZE", "", "WEIGHT", "adjustPointToCameraPreview", "Lio/fotoapparat/hardware/metering/PointF;", "visibleResolution", "Lio/fotoapparat/parameter/Resolution;", "displayOrientationDegrees", "cameraIsMirrored", "", "clamp", "min", "max", "configMatrix", "Landroid/graphics/Matrix;", "ensureAreaBound", "focusBounds", "Landroid/graphics/Rect;", "Lio/fotoapparat/hardware/metering/FocalRequest;", "toBoundsRect", "toFocusAreas", "", "Landroid/hardware/Camera$Area;", "verifyInBounds", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: FocalPointConverter.kt */
public final class FocalPointConverterKt {
    private static final float CAMERA_BOUNDS_RANGE = 2000.0f;
    private static final int FOCUS_AREA_HALF_SIZE = 50;
    private static final int WEIGHT = 1000;

    public static final List<Camera.Area> toFocusAreas(FocalRequest focalRequest, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(focalRequest, "receiver$0");
        return CollectionsKt.listOf(new Camera.Area(focusBounds(focalRequest, (float) i, z), 1000));
    }

    private static final Rect focusBounds(FocalRequest focalRequest, float f, boolean z) {
        return toBoundsRect(adjustPointToCameraPreview(focalRequest.getPoint(), focalRequest.getPreviewResolution(), f, z));
    }

    private static final PointF adjustPointToCameraPreview(PointF pointF, Resolution resolution, float f, boolean z) {
        Matrix configMatrix = configMatrix(new Matrix(), resolution, f, z);
        float[] fArr = {pointF.getX(), pointF.getY()};
        configMatrix.mapPoints(fArr);
        return new PointF(verifyInBounds(fArr[0]), verifyInBounds(fArr[1]));
    }

    private static final Matrix configMatrix(Matrix matrix, Resolution resolution, float f, boolean z) {
        matrix.postScale(CAMERA_BOUNDS_RANGE / ((float) resolution.width), CAMERA_BOUNDS_RANGE / ((float) resolution.height));
        matrix.postTranslate(-1000.0f, -1000.0f);
        matrix.postRotate(-f);
        matrix.postScale(z ? -1.0f : 1.0f, 1.0f);
        return matrix;
    }

    private static final float verifyInBounds(float f) {
        Float valueOf = Float.valueOf(f);
        float floatValue = valueOf.floatValue();
        if (!(floatValue >= -1000.0f && floatValue <= 1000.0f)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.floatValue();
        }
        throw new IllegalArgumentException("Point value should be between -1000.0 and 1000.0. Was " + f);
    }

    private static final Rect toBoundsRect(PointF pointF) {
        float f = (float) 50;
        return new Rect(ensureAreaBound(pointF.getX() - f), ensureAreaBound(pointF.getY() - f), ensureAreaBound(pointF.getX() + f), ensureAreaBound(pointF.getY() + f));
    }

    private static final int ensureAreaBound(float f) {
        return (int) clamp(f, -1000.0f, 1000.0f);
    }

    private static final float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }
}
