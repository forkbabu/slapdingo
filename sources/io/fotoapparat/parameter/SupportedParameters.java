package io.fotoapparat.parameter;

import android.hardware.Camera;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0016\u0010\tR\u001b\u0010\u0018\u001a\u00020\u00198FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001e\u0010\u001bR%\u0010 \u001a\f\u0012\b\u0012\u00060!R\u00020\u00040\r8FX\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b\"\u0010\u0010R%\u0010$\u001a\f\u0012\b\u0012\u00060!R\u00020\u00040\r8FX\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b%\u0010\u0010R!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190\r8FX\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b(\u0010\u0010R)\u0010*\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u000e0\u000e0\r8FX\u0002¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b,\u0010\u0010R!\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\r8FX\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b0\u0010\u0010R\u001b\u00102\u001a\u0002038FX\u0002¢\u0006\f\n\u0004\b6\u0010\u000b\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002088FX\u0002¢\u0006\f\n\u0004\b;\u0010\u000b\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lio/fotoapparat/parameter/SupportedParameters;", "", "cameraParameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "(Landroid/hardware/Camera$Parameters;)V", "exposureCompensationRange", "Lkotlin/ranges/IntRange;", "getExposureCompensationRange", "()Lkotlin/ranges/IntRange;", "exposureCompensationRange$delegate", "Lkotlin/Lazy;", "flashModes", "", "", "getFlashModes", "()Ljava/util/List;", "flashModes$delegate", "focusModes", "getFocusModes", "focusModes$delegate", "jpegQualityRange", "getJpegQualityRange", "jpegQualityRange$delegate", "maxNumFocusAreas", "", "getMaxNumFocusAreas", "()I", "maxNumFocusAreas$delegate", "maxNumMeteringAreas", "getMaxNumMeteringAreas", "maxNumMeteringAreas$delegate", "pictureResolutions", "Landroid/hardware/Camera$Size;", "getPictureResolutions", "pictureResolutions$delegate", "previewResolutions", "getPreviewResolutions", "previewResolutions$delegate", "sensorSensitivities", "getSensorSensitivities", "sensorSensitivities$delegate", "supportedAutoBandingModes", "kotlin.jvm.PlatformType", "getSupportedAutoBandingModes", "supportedAutoBandingModes$delegate", "supportedPreviewFpsRanges", "", "getSupportedPreviewFpsRanges", "supportedPreviewFpsRanges$delegate", "supportedSmoothZoom", "", "getSupportedSmoothZoom", "()Z", "supportedSmoothZoom$delegate", "supportedZoom", "Lio/fotoapparat/parameter/Zoom;", "getSupportedZoom", "()Lio/fotoapparat/parameter/Zoom;", "supportedZoom$delegate", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: SupportedParameters.kt */
public final class SupportedParameters {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "flashModes", "getFlashModes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "focusModes", "getFocusModes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "previewResolutions", "getPreviewResolutions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "pictureResolutions", "getPictureResolutions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "supportedPreviewFpsRanges", "getSupportedPreviewFpsRanges()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "sensorSensitivities", "getSensorSensitivities()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "supportedZoom", "getSupportedZoom()Lio/fotoapparat/parameter/Zoom;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "supportedSmoothZoom", "getSupportedSmoothZoom()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "supportedAutoBandingModes", "getSupportedAutoBandingModes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "jpegQualityRange", "getJpegQualityRange()Lkotlin/ranges/IntRange;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "exposureCompensationRange", "getExposureCompensationRange()Lkotlin/ranges/IntRange;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "maxNumFocusAreas", "getMaxNumFocusAreas()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupportedParameters.class), "maxNumMeteringAreas", "getMaxNumMeteringAreas()I"))};
    /* access modifiers changed from: private */
    public final Camera.Parameters cameraParameters;
    private final Lazy exposureCompensationRange$delegate = LazyKt.lazy(new SupportedParameters$exposureCompensationRange$2(this));
    private final Lazy flashModes$delegate = LazyKt.lazy(new SupportedParameters$flashModes$2(this));
    private final Lazy focusModes$delegate = LazyKt.lazy(new SupportedParameters$focusModes$2(this));
    private final Lazy jpegQualityRange$delegate = LazyKt.lazy(SupportedParameters$jpegQualityRange$2.INSTANCE);
    private final Lazy maxNumFocusAreas$delegate = LazyKt.lazy(new SupportedParameters$maxNumFocusAreas$2(this));
    private final Lazy maxNumMeteringAreas$delegate = LazyKt.lazy(new SupportedParameters$maxNumMeteringAreas$2(this));
    private final Lazy pictureResolutions$delegate = LazyKt.lazy(new SupportedParameters$pictureResolutions$2(this));
    private final Lazy previewResolutions$delegate = LazyKt.lazy(new SupportedParameters$previewResolutions$2(this));
    private final Lazy sensorSensitivities$delegate = LazyKt.lazy(new SupportedParameters$sensorSensitivities$2(this));
    private final Lazy supportedAutoBandingModes$delegate = LazyKt.lazy(new SupportedParameters$supportedAutoBandingModes$2(this));
    private final Lazy supportedPreviewFpsRanges$delegate = LazyKt.lazy(new SupportedParameters$supportedPreviewFpsRanges$2(this));
    private final Lazy supportedSmoothZoom$delegate = LazyKt.lazy(new SupportedParameters$supportedSmoothZoom$2(this));
    private final Lazy supportedZoom$delegate = LazyKt.lazy(new SupportedParameters$supportedZoom$2(this));

    public final IntRange getExposureCompensationRange() {
        Lazy lazy = this.exposureCompensationRange$delegate;
        KProperty kProperty = $$delegatedProperties[10];
        return (IntRange) lazy.getValue();
    }

    public final List<String> getFlashModes() {
        Lazy lazy = this.flashModes$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (List) lazy.getValue();
    }

    public final List<String> getFocusModes() {
        Lazy lazy = this.focusModes$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (List) lazy.getValue();
    }

    public final IntRange getJpegQualityRange() {
        Lazy lazy = this.jpegQualityRange$delegate;
        KProperty kProperty = $$delegatedProperties[9];
        return (IntRange) lazy.getValue();
    }

    public final int getMaxNumFocusAreas() {
        Lazy lazy = this.maxNumFocusAreas$delegate;
        KProperty kProperty = $$delegatedProperties[11];
        return ((Number) lazy.getValue()).intValue();
    }

    public final int getMaxNumMeteringAreas() {
        Lazy lazy = this.maxNumMeteringAreas$delegate;
        KProperty kProperty = $$delegatedProperties[12];
        return ((Number) lazy.getValue()).intValue();
    }

    public final List<Camera.Size> getPictureResolutions() {
        Lazy lazy = this.pictureResolutions$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (List) lazy.getValue();
    }

    public final List<Camera.Size> getPreviewResolutions() {
        Lazy lazy = this.previewResolutions$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (List) lazy.getValue();
    }

    public final List<Integer> getSensorSensitivities() {
        Lazy lazy = this.sensorSensitivities$delegate;
        KProperty kProperty = $$delegatedProperties[5];
        return (List) lazy.getValue();
    }

    public final List<String> getSupportedAutoBandingModes() {
        Lazy lazy = this.supportedAutoBandingModes$delegate;
        KProperty kProperty = $$delegatedProperties[8];
        return (List) lazy.getValue();
    }

    public final List<int[]> getSupportedPreviewFpsRanges() {
        Lazy lazy = this.supportedPreviewFpsRanges$delegate;
        KProperty kProperty = $$delegatedProperties[4];
        return (List) lazy.getValue();
    }

    public final boolean getSupportedSmoothZoom() {
        Lazy lazy = this.supportedSmoothZoom$delegate;
        KProperty kProperty = $$delegatedProperties[7];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    public final Zoom getSupportedZoom() {
        Lazy lazy = this.supportedZoom$delegate;
        KProperty kProperty = $$delegatedProperties[6];
        return (Zoom) lazy.getValue();
    }

    public SupportedParameters(Camera.Parameters parameters) {
        Intrinsics.checkParameterIsNotNull(parameters, "cameraParameters");
        this.cameraParameters = parameters;
    }
}
