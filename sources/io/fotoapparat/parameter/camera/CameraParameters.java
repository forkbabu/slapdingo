package io.fotoapparat.parameter.camera;

import io.fotoapparat.parameter.AntiBandingMode;
import io.fotoapparat.parameter.Flash;
import io.fotoapparat.parameter.FocusMode;
import io.fotoapparat.parameter.FpsRange;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.util.StringExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003Jj\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0007HÖ\u0001J\b\u00102\u001a\u000203H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lio/fotoapparat/parameter/camera/CameraParameters;", "", "flashMode", "Lio/fotoapparat/parameter/Flash;", "focusMode", "Lio/fotoapparat/parameter/FocusMode;", "jpegQuality", "", "exposureCompensation", "previewFpsRange", "Lio/fotoapparat/parameter/FpsRange;", "antiBandingMode", "Lio/fotoapparat/parameter/AntiBandingMode;", "sensorSensitivity", "pictureResolution", "Lio/fotoapparat/parameter/Resolution;", "previewResolution", "(Lio/fotoapparat/parameter/Flash;Lio/fotoapparat/parameter/FocusMode;IILio/fotoapparat/parameter/FpsRange;Lio/fotoapparat/parameter/AntiBandingMode;Ljava/lang/Integer;Lio/fotoapparat/parameter/Resolution;Lio/fotoapparat/parameter/Resolution;)V", "getAntiBandingMode", "()Lio/fotoapparat/parameter/AntiBandingMode;", "getExposureCompensation", "()I", "getFlashMode", "()Lio/fotoapparat/parameter/Flash;", "getFocusMode", "()Lio/fotoapparat/parameter/FocusMode;", "getJpegQuality", "getPictureResolution", "()Lio/fotoapparat/parameter/Resolution;", "getPreviewFpsRange", "()Lio/fotoapparat/parameter/FpsRange;", "getPreviewResolution", "getSensorSensitivity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lio/fotoapparat/parameter/Flash;Lio/fotoapparat/parameter/FocusMode;IILio/fotoapparat/parameter/FpsRange;Lio/fotoapparat/parameter/AntiBandingMode;Ljava/lang/Integer;Lio/fotoapparat/parameter/Resolution;Lio/fotoapparat/parameter/Resolution;)Lio/fotoapparat/parameter/camera/CameraParameters;", "equals", "", "other", "hashCode", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: CameraParameters.kt */
public final class CameraParameters {
    private final AntiBandingMode antiBandingMode;
    private final int exposureCompensation;
    private final Flash flashMode;
    private final FocusMode focusMode;
    private final int jpegQuality;
    private final Resolution pictureResolution;
    private final FpsRange previewFpsRange;
    private final Resolution previewResolution;
    private final Integer sensorSensitivity;

    public static /* synthetic */ CameraParameters copy$default(CameraParameters cameraParameters, Flash flash, FocusMode focusMode2, int i, int i2, FpsRange fpsRange, AntiBandingMode antiBandingMode2, Integer num, Resolution resolution, Resolution resolution2, int i3, Object obj) {
        return cameraParameters.copy((i3 & 1) != 0 ? cameraParameters.flashMode : flash, (i3 & 2) != 0 ? cameraParameters.focusMode : focusMode2, (i3 & 4) != 0 ? cameraParameters.jpegQuality : i, (i3 & 8) != 0 ? cameraParameters.exposureCompensation : i2, (i3 & 16) != 0 ? cameraParameters.previewFpsRange : fpsRange, (i3 & 32) != 0 ? cameraParameters.antiBandingMode : antiBandingMode2, (i3 & 64) != 0 ? cameraParameters.sensorSensitivity : num, (i3 & 128) != 0 ? cameraParameters.pictureResolution : resolution, (i3 & 256) != 0 ? cameraParameters.previewResolution : resolution2);
    }

    public final Flash component1() {
        return this.flashMode;
    }

    public final FocusMode component2() {
        return this.focusMode;
    }

    public final int component3() {
        return this.jpegQuality;
    }

    public final int component4() {
        return this.exposureCompensation;
    }

    public final FpsRange component5() {
        return this.previewFpsRange;
    }

    public final AntiBandingMode component6() {
        return this.antiBandingMode;
    }

    public final Integer component7() {
        return this.sensorSensitivity;
    }

    public final Resolution component8() {
        return this.pictureResolution;
    }

    public final Resolution component9() {
        return this.previewResolution;
    }

    public final CameraParameters copy(Flash flash, FocusMode focusMode2, int i, int i2, FpsRange fpsRange, AntiBandingMode antiBandingMode2, Integer num, Resolution resolution, Resolution resolution2) {
        Intrinsics.checkParameterIsNotNull(flash, "flashMode");
        Intrinsics.checkParameterIsNotNull(focusMode2, "focusMode");
        Intrinsics.checkParameterIsNotNull(fpsRange, "previewFpsRange");
        Intrinsics.checkParameterIsNotNull(antiBandingMode2, "antiBandingMode");
        Intrinsics.checkParameterIsNotNull(resolution, "pictureResolution");
        Intrinsics.checkParameterIsNotNull(resolution2, "previewResolution");
        return new CameraParameters(flash, focusMode2, i, i2, fpsRange, antiBandingMode2, num, resolution, resolution2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CameraParameters) {
                CameraParameters cameraParameters = (CameraParameters) obj;
                if (Intrinsics.areEqual(this.flashMode, cameraParameters.flashMode) && Intrinsics.areEqual(this.focusMode, cameraParameters.focusMode)) {
                    if (this.jpegQuality == cameraParameters.jpegQuality) {
                        if (!(this.exposureCompensation == cameraParameters.exposureCompensation) || !Intrinsics.areEqual(this.previewFpsRange, cameraParameters.previewFpsRange) || !Intrinsics.areEqual(this.antiBandingMode, cameraParameters.antiBandingMode) || !Intrinsics.areEqual(this.sensorSensitivity, cameraParameters.sensorSensitivity) || !Intrinsics.areEqual(this.pictureResolution, cameraParameters.pictureResolution) || !Intrinsics.areEqual(this.previewResolution, cameraParameters.previewResolution)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Flash flash = this.flashMode;
        int i = 0;
        int hashCode = (flash != null ? flash.hashCode() : 0) * 31;
        FocusMode focusMode2 = this.focusMode;
        int hashCode2 = (((((hashCode + (focusMode2 != null ? focusMode2.hashCode() : 0)) * 31) + this.jpegQuality) * 31) + this.exposureCompensation) * 31;
        FpsRange fpsRange = this.previewFpsRange;
        int hashCode3 = (hashCode2 + (fpsRange != null ? fpsRange.hashCode() : 0)) * 31;
        AntiBandingMode antiBandingMode2 = this.antiBandingMode;
        int hashCode4 = (hashCode3 + (antiBandingMode2 != null ? antiBandingMode2.hashCode() : 0)) * 31;
        Integer num = this.sensorSensitivity;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Resolution resolution = this.pictureResolution;
        int hashCode6 = (hashCode5 + (resolution != null ? resolution.hashCode() : 0)) * 31;
        Resolution resolution2 = this.previewResolution;
        if (resolution2 != null) {
            i = resolution2.hashCode();
        }
        return hashCode6 + i;
    }

    public CameraParameters(Flash flash, FocusMode focusMode2, int i, int i2, FpsRange fpsRange, AntiBandingMode antiBandingMode2, Integer num, Resolution resolution, Resolution resolution2) {
        Intrinsics.checkParameterIsNotNull(flash, "flashMode");
        Intrinsics.checkParameterIsNotNull(focusMode2, "focusMode");
        Intrinsics.checkParameterIsNotNull(fpsRange, "previewFpsRange");
        Intrinsics.checkParameterIsNotNull(antiBandingMode2, "antiBandingMode");
        Intrinsics.checkParameterIsNotNull(resolution, "pictureResolution");
        Intrinsics.checkParameterIsNotNull(resolution2, "previewResolution");
        this.flashMode = flash;
        this.focusMode = focusMode2;
        this.jpegQuality = i;
        this.exposureCompensation = i2;
        this.previewFpsRange = fpsRange;
        this.antiBandingMode = antiBandingMode2;
        this.sensorSensitivity = num;
        this.pictureResolution = resolution;
        this.previewResolution = resolution2;
    }

    public final Flash getFlashMode() {
        return this.flashMode;
    }

    public final FocusMode getFocusMode() {
        return this.focusMode;
    }

    public final int getJpegQuality() {
        return this.jpegQuality;
    }

    public final int getExposureCompensation() {
        return this.exposureCompensation;
    }

    public final FpsRange getPreviewFpsRange() {
        return this.previewFpsRange;
    }

    public final AntiBandingMode getAntiBandingMode() {
        return this.antiBandingMode;
    }

    public final Integer getSensorSensitivity() {
        return this.sensorSensitivity;
    }

    public final Resolution getPictureResolution() {
        return this.pictureResolution;
    }

    public final Resolution getPreviewResolution() {
        return this.previewResolution;
    }

    public String toString() {
        return "CameraParameters" + StringExtensionsKt.getLineSeparator() + "flashMode:" + StringExtensionsKt.wrap(this.flashMode) + "focusMode:" + StringExtensionsKt.wrap(this.focusMode) + "jpegQuality:" + StringExtensionsKt.wrap(Integer.valueOf(this.jpegQuality)) + "exposureCompensation:" + StringExtensionsKt.wrap(Integer.valueOf(this.exposureCompensation)) + "previewFpsRange:" + StringExtensionsKt.wrap(this.previewFpsRange) + "antiBandingMode:" + StringExtensionsKt.wrap(this.antiBandingMode) + "sensorSensitivity:" + StringExtensionsKt.wrap(this.sensorSensitivity) + "pictureResolution:" + StringExtensionsKt.wrap(this.pictureResolution) + "previewResolution:" + StringExtensionsKt.wrap(this.previewResolution);
    }
}
