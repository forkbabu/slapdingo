package io.fotoapparat;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.fotoapparat.characteristic.LensPosition;
import io.fotoapparat.configuration.CameraConfiguration;
import io.fotoapparat.error.CameraErrorListener;
import io.fotoapparat.exception.camera.CameraException;
import io.fotoapparat.log.Logger;
import io.fotoapparat.log.LoggersKt;
import io.fotoapparat.parameter.Flash;
import io.fotoapparat.parameter.FocusMode;
import io.fotoapparat.parameter.FpsRange;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.parameter.ScaleType;
import io.fotoapparat.preview.Frame;
import io.fotoapparat.preview.FrameProcessor;
import io.fotoapparat.selector.LensPositionSelectorsKt;
import io.fotoapparat.selector.SelectorsKt;
import io.fotoapparat.view.CameraRenderer;
import io.fotoapparat.view.FocusView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00103\u001a\u000204J\u0012\u00105\u001a\u0002042\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u001e\u0010\u0005\u001a\u00020\u00002\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u00106\u001a\u000207J%\u00108\u001a\u00020\u00002\u001d\u00109\u001a\u0019\u0012\u0004\u0012\u00020:\u0012\u0006\u0012\u0004\u0018\u00010;0\u0006j\u0002`<¢\u0006\u0002\b\u001eJ+\u0010=\u001a\u00020\u00002#\u00109\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u001b\u0012\u0006\u0012\u0004\u0018\u00010>0\u0006j\u0002`?¢\u0006\u0002\b\u001eJ+\u0010@\u001a\u00020\u00002#\u00109\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u001b\u0012\u0006\u0012\u0004\u0018\u00010A0\u0006j\u0002`B¢\u0006\u0002\b\u001eJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010C\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010DJ-\u0010C\u001a\u00020\u00002%\u0010C\u001a!\u0012\u0013\u0012\u00110E¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\b0\u0006j\u0002`IJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(J%\u0010K\u001a\u00020\u00002\u001d\u00109\u001a\u0019\u0012\u0004\u0012\u00020:\u0012\u0006\u0012\u0004\u0018\u00010;0\u0006j\u0002`L¢\u0006\u0002\b\u001eJ+\u0010M\u001a\u00020\u00002#\u00109\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0006j\u0002`\u001d¢\u0006\u0002\b\u001eJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J+\u0010N\u001a\u00020\u00002#\u00109\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u001b\u0012\u0006\u0012\u0004\u0018\u00010O0\u0006j\u0002`P¢\u0006\u0002\b\u001eJ+\u0010Q\u001a\u00020\u00002#\u00109\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0\u001b\u0012\u0006\u0012\u0004\u0018\u00010R0\u0006j\u0002`S¢\u0006\u0002\b\u001eJ+\u0010T\u001a\u00020\u00002#\u00109\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u001b\u0012\u0006\u0012\u0004\u0018\u00010O0\u0006j\u0002`P¢\u0006\u0002\b\u001eJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.J+\u0010V\u001a\u00020\u00002#\u00109\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001b\u0012\u0006\u0012\u0004\u0018\u00010;0\u0006j\u0002`W¢\u0006\u0002\b\u001eR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R7\u0010\u001a\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0006j\u0002`\u001d¢\u0006\u0002\b\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006X"}, d2 = {"Lio/fotoapparat/FotoapparatBuilder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cameraErrorCallback", "Lkotlin/Function1;", "Lio/fotoapparat/exception/camera/CameraException;", "", "Lio/fotoapparat/error/CameraErrorCallback;", "getCameraErrorCallback$fotoapparat_release", "()Lkotlin/jvm/functions/Function1;", "setCameraErrorCallback$fotoapparat_release", "(Lkotlin/jvm/functions/Function1;)V", "configuration", "Lio/fotoapparat/configuration/CameraConfiguration;", "getConfiguration$fotoapparat_release", "()Lio/fotoapparat/configuration/CameraConfiguration;", "setConfiguration$fotoapparat_release", "(Lio/fotoapparat/configuration/CameraConfiguration;)V", "focusView", "Lio/fotoapparat/view/FocusView;", "getFocusView$fotoapparat_release", "()Lio/fotoapparat/view/FocusView;", "setFocusView$fotoapparat_release", "(Lio/fotoapparat/view/FocusView;)V", "lensPositionSelector", "", "Lio/fotoapparat/characteristic/LensPosition;", "Lio/fotoapparat/selector/LensPositionSelector;", "Lkotlin/ExtensionFunctionType;", "getLensPositionSelector$fotoapparat_release", "setLensPositionSelector$fotoapparat_release", "logger", "Lio/fotoapparat/log/Logger;", "getLogger$fotoapparat_release", "()Lio/fotoapparat/log/Logger;", "setLogger$fotoapparat_release", "(Lio/fotoapparat/log/Logger;)V", "renderer", "Lio/fotoapparat/view/CameraRenderer;", "getRenderer$fotoapparat_release", "()Lio/fotoapparat/view/CameraRenderer;", "setRenderer$fotoapparat_release", "(Lio/fotoapparat/view/CameraRenderer;)V", "scaleType", "Lio/fotoapparat/parameter/ScaleType;", "getScaleType$fotoapparat_release", "()Lio/fotoapparat/parameter/ScaleType;", "setScaleType$fotoapparat_release", "(Lio/fotoapparat/parameter/ScaleType;)V", "build", "Lio/fotoapparat/Fotoapparat;", "buildInternal", "callback", "Lio/fotoapparat/error/CameraErrorListener;", "exposureCompensation", "selector", "Lkotlin/ranges/IntRange;", "", "Lio/fotoapparat/selector/ExposureSelector;", "flash", "Lio/fotoapparat/parameter/Flash;", "Lio/fotoapparat/selector/FlashSelector;", "focusMode", "Lio/fotoapparat/parameter/FocusMode;", "Lio/fotoapparat/selector/FocusModeSelector;", "frameProcessor", "Lio/fotoapparat/preview/FrameProcessor;", "Lio/fotoapparat/preview/Frame;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "frame", "Lio/fotoapparat/util/FrameProcessor;", "into", "jpegQuality", "Lio/fotoapparat/selector/QualitySelector;", "lensPosition", "photoResolution", "Lio/fotoapparat/parameter/Resolution;", "Lio/fotoapparat/selector/ResolutionSelector;", "previewFpsRange", "Lio/fotoapparat/parameter/FpsRange;", "Lio/fotoapparat/selector/FpsRangeSelector;", "previewResolution", "previewScaleType", "sensorSensitivity", "Lio/fotoapparat/selector/SensorSensitivitySelector;", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: FotoapparatBuilder.kt */
public final class FotoapparatBuilder {
    private Function1<? super CameraException, Unit> cameraErrorCallback = FotoapparatBuilder$cameraErrorCallback$1.INSTANCE;
    private CameraConfiguration configuration = CameraConfiguration.Companion.m1default();
    private Context context;
    private FocusView focusView;
    private Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> lensPositionSelector = SelectorsKt.firstAvailable(LensPositionSelectorsKt.back(), LensPositionSelectorsKt.front(), LensPositionSelectorsKt.external());
    private Logger logger = LoggersKt.none();
    private CameraRenderer renderer;
    private ScaleType scaleType = ScaleType.CenterCrop;

    public FotoapparatBuilder(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Iterable<? extends io.fotoapparat.characteristic.LensPosition>, ? extends io.fotoapparat.characteristic.LensPosition>, kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.characteristic.LensPosition>, io.fotoapparat.characteristic.LensPosition> */
    public final Function1<Iterable<? extends LensPosition>, LensPosition> getLensPositionSelector$fotoapparat_release() {
        return this.lensPositionSelector;
    }

    public final void setLensPositionSelector$fotoapparat_release(Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.lensPositionSelector = function1;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super io.fotoapparat.exception.camera.CameraException, kotlin.Unit>, kotlin.jvm.functions.Function1<io.fotoapparat.exception.camera.CameraException, kotlin.Unit> */
    public final Function1<CameraException, Unit> getCameraErrorCallback$fotoapparat_release() {
        return this.cameraErrorCallback;
    }

    public final void setCameraErrorCallback$fotoapparat_release(Function1<? super CameraException, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.cameraErrorCallback = function1;
    }

    public final CameraRenderer getRenderer$fotoapparat_release() {
        return this.renderer;
    }

    public final void setRenderer$fotoapparat_release(CameraRenderer cameraRenderer) {
        this.renderer = cameraRenderer;
    }

    public final FocusView getFocusView$fotoapparat_release() {
        return this.focusView;
    }

    public final void setFocusView$fotoapparat_release(FocusView focusView2) {
        this.focusView = focusView2;
    }

    public final ScaleType getScaleType$fotoapparat_release() {
        return this.scaleType;
    }

    public final void setScaleType$fotoapparat_release(ScaleType scaleType2) {
        Intrinsics.checkParameterIsNotNull(scaleType2, "<set-?>");
        this.scaleType = scaleType2;
    }

    public final Logger getLogger$fotoapparat_release() {
        return this.logger;
    }

    public final void setLogger$fotoapparat_release(Logger logger2) {
        Intrinsics.checkParameterIsNotNull(logger2, "<set-?>");
        this.logger = logger2;
    }

    public final CameraConfiguration getConfiguration$fotoapparat_release() {
        return this.configuration;
    }

    public final void setConfiguration$fotoapparat_release(CameraConfiguration cameraConfiguration) {
        Intrinsics.checkParameterIsNotNull(cameraConfiguration, "<set-?>");
        this.configuration = cameraConfiguration;
    }

    public final FotoapparatBuilder lensPosition(Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.lensPositionSelector = function1;
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder previewScaleType(ScaleType scaleType2) {
        Intrinsics.checkParameterIsNotNull(scaleType2, "scaleType");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.scaleType = scaleType2;
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder photoResolution(Function1<? super Iterable<Resolution>, Resolution> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, null, null, null, null, null, null, null, function1, null, 767, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder previewResolution(Function1<? super Iterable<Resolution>, Resolution> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, null, null, null, null, null, null, null, null, function1, 511, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder focusMode(Function1<? super Iterable<? extends FocusMode>, ? extends FocusMode> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, function1, null, null, null, null, null, null, null, null, PointerIconCompat.TYPE_GRABBING, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder flash(Function1<? super Iterable<? extends Flash>, ? extends Flash> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, function1, null, null, null, null, null, null, null, null, null, 1022, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder previewFpsRange(Function1<? super Iterable<FpsRange>, FpsRange> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, null, null, null, null, function1, null, null, null, null, 991, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder sensorSensitivity(Function1<? super Iterable<Integer>, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, null, null, null, null, null, null, function1, null, null, 895, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder jpegQuality(Function1<? super IntRange, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, null, function1, null, null, null, null, null, null, null, PointerIconCompat.TYPE_ZOOM_OUT, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder exposureCompensation(Function1<? super IntRange, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, null, null, function1, null, null, null, null, null, null, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder frameProcessor(Function1<? super Frame, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "frameProcessor");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, null, null, null, function1, null, null, null, null, null, 1007, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder frameProcessor(FrameProcessor frameProcessor) {
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.configuration = CameraConfiguration.copy$default(fotoapparatBuilder.configuration, null, null, null, null, (Function1) (frameProcessor != null ? new FotoapparatBuilder$frameProcessor$2$1$1(frameProcessor) : null), null, null, null, null, null, 1007, null);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder logger(Logger logger2) {
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.logger = logger2;
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder cameraErrorCallback(CameraErrorListener cameraErrorListener) {
        Intrinsics.checkParameterIsNotNull(cameraErrorListener, "callback");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.cameraErrorCallback = new FotoapparatBuilder$cameraErrorCallback$$inlined$apply$lambda$1(cameraErrorListener);
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder cameraErrorCallback(Function1<? super CameraException, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.cameraErrorCallback = function1;
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder into(CameraRenderer cameraRenderer) {
        Intrinsics.checkParameterIsNotNull(cameraRenderer, "renderer");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.renderer = cameraRenderer;
        return fotoapparatBuilder;
    }

    public final FotoapparatBuilder focusView(FocusView focusView2) {
        Intrinsics.checkParameterIsNotNull(focusView2, "focusView");
        FotoapparatBuilder fotoapparatBuilder = this;
        fotoapparatBuilder.focusView = focusView2;
        return fotoapparatBuilder;
    }

    public final Fotoapparat build() {
        return buildInternal(this.renderer);
    }

    private final Fotoapparat buildInternal(CameraRenderer cameraRenderer) {
        if (cameraRenderer != null) {
            return new Fotoapparat(this.context, cameraRenderer, this.focusView, this.lensPositionSelector, this.scaleType, this.configuration, this.cameraErrorCallback, null, this.logger, 128, null);
        }
        throw new IllegalStateException("CameraRenderer is mandatory.");
    }
}
