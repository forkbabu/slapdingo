package io.fotoapparat;

import android.content.Context;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import io.fotoapparat.capability.Capabilities;
import io.fotoapparat.characteristic.LensPosition;
import io.fotoapparat.concurrent.CameraExecutor;
import io.fotoapparat.configuration.CameraConfiguration;
import io.fotoapparat.configuration.Configuration;
import io.fotoapparat.error.ErrorCallbacksKt;
import io.fotoapparat.exception.camera.CameraException;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.display.Display;
import io.fotoapparat.hardware.orientation.OrientationSensor;
import io.fotoapparat.log.Logger;
import io.fotoapparat.log.LoggersKt;
import io.fotoapparat.parameter.ScaleType;
import io.fotoapparat.parameter.camera.CameraParameters;
import io.fotoapparat.result.FocusResult;
import io.fotoapparat.result.PendingResult;
import io.fotoapparat.result.PhotoResult;
import io.fotoapparat.selector.LensPositionSelectorsKt;
import io.fotoapparat.selector.SelectorsKt;
import io.fotoapparat.view.CameraRenderer;
import io.fotoapparat.view.FocalPointSelector;
import java.util.concurrent.Future;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012%\b\u0002\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tj\u0002`\f¢\u0006\u0002\b\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\tj\u0002`\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u0010&\u001a\u00020\u0000J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(J\u0010\u0010*\u001a\f\u0012\u0004\u0012\u00020+0(j\u0002`,J\u0010\u0010-\u001a\f\u0012\u0004\u0012\u00020.0(j\u0002`/J+\u00100\u001a\u0002012#\u00102\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tj\u0002`\f¢\u0006\u0002\b\rJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u0014042\b\b\u0001\u00105\u001a\u000206J\u0006\u00107\u001a\u00020\u0014J\u0006\u00108\u001a\u00020\u0014J3\u00109\u001a\u00020\u00142#\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tj\u0002`\f¢\u0006\u0002\b\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010:\u001a\u00020;J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0014042\u0006\u0010=\u001a\u00020>R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\tj\u0002`\u0015X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006@"}, d2 = {"Lio/fotoapparat/Fotoapparat;", "", "context", "Landroid/content/Context;", "view", "Lio/fotoapparat/view/CameraRenderer;", "focusView", "Lio/fotoapparat/view/FocalPointSelector;", "lensPosition", "Lkotlin/Function1;", "", "Lio/fotoapparat/characteristic/LensPosition;", "Lio/fotoapparat/selector/LensPositionSelector;", "Lkotlin/ExtensionFunctionType;", "scaleType", "Lio/fotoapparat/parameter/ScaleType;", "cameraConfiguration", "Lio/fotoapparat/configuration/CameraConfiguration;", "cameraErrorCallback", "Lio/fotoapparat/exception/camera/CameraException;", "", "Lio/fotoapparat/error/CameraErrorCallback;", "executor", "Lio/fotoapparat/concurrent/CameraExecutor;", "logger", "Lio/fotoapparat/log/Logger;", "(Landroid/content/Context;Lio/fotoapparat/view/CameraRenderer;Lio/fotoapparat/view/FocalPointSelector;Lkotlin/jvm/functions/Function1;Lio/fotoapparat/parameter/ScaleType;Lio/fotoapparat/configuration/CameraConfiguration;Lkotlin/jvm/functions/Function1;Lio/fotoapparat/concurrent/CameraExecutor;Lio/fotoapparat/log/Logger;)V", "device", "Lio/fotoapparat/hardware/Device;", "display", "Lio/fotoapparat/hardware/display/Display;", "mainThreadErrorCallback", "orientationSensor", "Lio/fotoapparat/hardware/orientation/OrientationSensor;", "getOrientationSensor", "()Lio/fotoapparat/hardware/orientation/OrientationSensor;", "orientationSensor$delegate", "Lkotlin/Lazy;", "autoFocus", "focus", "Lio/fotoapparat/result/PendingResult;", "Lio/fotoapparat/result/FocusResult;", "getCapabilities", "Lio/fotoapparat/capability/Capabilities;", "Lio/fotoapparat/result/CapabilitiesResult;", "getCurrentParameters", "Lio/fotoapparat/parameter/camera/CameraParameters;", "Lio/fotoapparat/result/ParametersResult;", "isAvailable", "", "selector", "setZoom", "Ljava/util/concurrent/Future;", "zoomLevel", "", "start", "stop", "switchTo", "takePicture", "Lio/fotoapparat/result/PhotoResult;", "updateConfiguration", "newConfiguration", "Lio/fotoapparat/configuration/Configuration;", "Companion", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Fotoapparat.kt */
public final class Fotoapparat {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Fotoapparat.class), "orientationSensor", "getOrientationSensor()Lio/fotoapparat/hardware/orientation/OrientationSensor;"))};
    public static final Companion Companion = new Companion(null);
    private static final CameraExecutor EXECUTOR = new CameraExecutor(null, 1, null);
    /* access modifiers changed from: private */
    public final Device device;
    private final Display display;
    private final CameraExecutor executor;
    /* access modifiers changed from: private */
    public final Logger logger;
    /* access modifiers changed from: private */
    public final Function1<CameraException, Unit> mainThreadErrorCallback;
    private final Lazy orientationSensor$delegate;

    public Fotoapparat(Context context, CameraRenderer cameraRenderer) {
        this(context, cameraRenderer, null, null, null, null, null, null, null, 508, null);
    }

    public Fotoapparat(Context context, CameraRenderer cameraRenderer, FocalPointSelector focalPointSelector) {
        this(context, cameraRenderer, focalPointSelector, null, null, null, null, null, null, 504, null);
    }

    public Fotoapparat(Context context, CameraRenderer cameraRenderer, FocalPointSelector focalPointSelector, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1) {
        this(context, cameraRenderer, focalPointSelector, function1, null, null, null, null, null, MetaDo.META_DELETEOBJECT, null);
    }

    public Fotoapparat(Context context, CameraRenderer cameraRenderer, FocalPointSelector focalPointSelector, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1, ScaleType scaleType) {
        this(context, cameraRenderer, focalPointSelector, function1, scaleType, null, null, null, null, 480, null);
    }

    public Fotoapparat(Context context, CameraRenderer cameraRenderer, FocalPointSelector focalPointSelector, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1, ScaleType scaleType, CameraConfiguration cameraConfiguration) {
        this(context, cameraRenderer, focalPointSelector, function1, scaleType, cameraConfiguration, null, null, null, 448, null);
    }

    public Fotoapparat(Context context, CameraRenderer cameraRenderer, FocalPointSelector focalPointSelector, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1, ScaleType scaleType, CameraConfiguration cameraConfiguration, Function1<? super CameraException, Unit> function12) {
        this(context, cameraRenderer, focalPointSelector, function1, scaleType, cameraConfiguration, function12, null, null, 384, null);
    }

    public Fotoapparat(Context context, CameraRenderer cameraRenderer, FocalPointSelector focalPointSelector, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1, ScaleType scaleType, CameraConfiguration cameraConfiguration, Function1<? super CameraException, Unit> function12, CameraExecutor cameraExecutor) {
        this(context, cameraRenderer, focalPointSelector, function1, scaleType, cameraConfiguration, function12, cameraExecutor, null, 256, null);
    }

    /* access modifiers changed from: private */
    public final OrientationSensor getOrientationSensor() {
        Lazy lazy = this.orientationSensor$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (OrientationSensor) lazy.getValue();
    }

    @JvmStatic
    public static final FotoapparatBuilder with(Context context) {
        return Companion.with(context);
    }

    public Fotoapparat(Context context, CameraRenderer cameraRenderer, FocalPointSelector focalPointSelector, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1, ScaleType scaleType, CameraConfiguration cameraConfiguration, Function1<? super CameraException, Unit> function12, CameraExecutor cameraExecutor, Logger logger2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(cameraRenderer, "view");
        Intrinsics.checkParameterIsNotNull(function1, "lensPosition");
        Intrinsics.checkParameterIsNotNull(scaleType, "scaleType");
        Intrinsics.checkParameterIsNotNull(cameraConfiguration, "cameraConfiguration");
        Intrinsics.checkParameterIsNotNull(function12, "cameraErrorCallback");
        Intrinsics.checkParameterIsNotNull(cameraExecutor, "executor");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.executor = cameraExecutor;
        this.logger = logger2;
        this.mainThreadErrorCallback = ErrorCallbacksKt.onMainThread(function12);
        Display display2 = new Display(context);
        this.display = display2;
        this.device = new Device(this.logger, display2, scaleType, cameraRenderer, focalPointSelector, this.executor, 0, cameraConfiguration, function1, 64, null);
        this.orientationSensor$delegate = LazyKt.lazy(new Fotoapparat$orientationSensor$2(this, context));
        this.logger.recordMethod();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Fotoapparat(Context context, CameraRenderer cameraRenderer, FocalPointSelector focalPointSelector, Function1 function1, ScaleType scaleType, CameraConfiguration cameraConfiguration, Function1 function12, CameraExecutor cameraExecutor, Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, cameraRenderer, (i & 4) != 0 ? null : focalPointSelector, (i & 8) != 0 ? SelectorsKt.firstAvailable(LensPositionSelectorsKt.back(), LensPositionSelectorsKt.front(), LensPositionSelectorsKt.external()) : function1, (i & 16) != 0 ? ScaleType.CenterCrop : scaleType, (i & 32) != 0 ? CameraConfiguration.Companion.m1default() : cameraConfiguration, (i & 64) != 0 ? AnonymousClass1.INSTANCE : function12, (i & 128) != 0 ? EXECUTOR : cameraExecutor, (i & 256) != 0 ? LoggersKt.none() : logger2);
    }

    public final void start() {
        this.logger.recordMethod();
        this.executor.execute(new CameraExecutor.Operation(false, new Fotoapparat$start$1(this), 1, null));
    }

    public final void stop() {
        this.logger.recordMethod();
        this.executor.cancelTasks();
        this.executor.execute(new CameraExecutor.Operation(false, new Fotoapparat$stop$1(this), 1, null));
    }

    public final PhotoResult takePicture() {
        this.logger.recordMethod();
        return PhotoResult.Companion.fromFuture$fotoapparat_release(this.executor.execute(new CameraExecutor.Operation(true, new Fotoapparat$takePicture$future$1(this.device))), this.logger);
    }

    public final PendingResult<Capabilities> getCapabilities() {
        this.logger.recordMethod();
        return PendingResult.Companion.fromFuture$fotoapparat_release(this.executor.execute(new CameraExecutor.Operation(true, new Fotoapparat$getCapabilities$future$1(this.device))), this.logger);
    }

    public final PendingResult<CameraParameters> getCurrentParameters() {
        this.logger.recordMethod();
        return PendingResult.Companion.fromFuture$fotoapparat_release(this.executor.execute(new CameraExecutor.Operation(true, new Fotoapparat$getCurrentParameters$future$1(this.device))), this.logger);
    }

    public final Future<Unit> updateConfiguration(Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(configuration, "newConfiguration");
        return this.executor.execute(new CameraExecutor.Operation(true, new Fotoapparat$updateConfiguration$1(this, configuration)));
    }

    public final Future<Unit> setZoom(float f) {
        return this.executor.execute(new CameraExecutor.Operation(true, new Fotoapparat$setZoom$1(this, f)));
    }

    public final Fotoapparat autoFocus() {
        Fotoapparat fotoapparat = this;
        fotoapparat.logger.recordMethod();
        fotoapparat.focus();
        return fotoapparat;
    }

    public final PendingResult<FocusResult> focus() {
        this.logger.recordMethod();
        return PendingResult.Companion.fromFuture$fotoapparat_release(this.executor.execute(new CameraExecutor.Operation(true, new Fotoapparat$focus$future$1(this.device))), this.logger);
    }

    public final void switchTo(Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1, CameraConfiguration cameraConfiguration) {
        Intrinsics.checkParameterIsNotNull(function1, "lensPosition");
        Intrinsics.checkParameterIsNotNull(cameraConfiguration, "cameraConfiguration");
        this.logger.recordMethod();
        this.executor.execute(new CameraExecutor.Operation(true, new Fotoapparat$switchTo$1(this, function1, cameraConfiguration)));
    }

    public final boolean isAvailable(Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return this.device.canSelectCamera(function1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/fotoapparat/Fotoapparat$Companion;", "", "()V", "EXECUTOR", "Lio/fotoapparat/concurrent/CameraExecutor;", "with", "Lio/fotoapparat/FotoapparatBuilder;", "context", "Landroid/content/Context;", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Fotoapparat.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FotoapparatBuilder with(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return new FotoapparatBuilder(context);
        }
    }
}
