package io.fotoapparat.hardware;

import android.hardware.Camera;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.fotoapparat.characteristic.CameraInfoProviderKt;
import io.fotoapparat.characteristic.LensPosition;
import io.fotoapparat.concurrent.CameraExecutor;
import io.fotoapparat.configuration.CameraConfiguration;
import io.fotoapparat.configuration.Configuration;
import io.fotoapparat.exception.camera.UnsupportedLensException;
import io.fotoapparat.hardware.display.Display;
import io.fotoapparat.hardware.orientation.Orientation;
import io.fotoapparat.log.Logger;
import io.fotoapparat.parameter.ScaleType;
import io.fotoapparat.parameter.camera.CameraParameters;
import io.fotoapparat.preview.Frame;
import io.fotoapparat.view.CameraRenderer;
import io.fotoapparat.view.FocalPointSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001Bn\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012#\u0010\u0012\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013j\u0002`\u0016¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\u0018J\u0011\u0010*\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010+J-\u0010,\u001a\u00020-2#\u0010\"\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013j\u0002`\u0016¢\u0006\u0002\b\u0017H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u0011H\u0016J+\u00105\u001a%\u0012\u0013\u0012\u001106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020/\u0018\u00010\u0013j\u0004\u0018\u0001`:H\u0016J%\u0010;\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013j\u0002`\u0016¢\u0006\u0002\b\u0017H\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u001dH\u0016J\b\u0010?\u001a\u00020-H\u0016J\b\u0010@\u001a\u00020/H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020CH\u0016J-\u0010D\u001a\u00020/2#\u0010E\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013j\u0002`\u0016¢\u0006\u0002\b\u0017H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R+\u0010\"\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013j\u0002`\u0016¢\u0006\u0002\b\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0)X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Lio/fotoapparat/hardware/Device;", "", "logger", "Lio/fotoapparat/log/Logger;", "display", "Lio/fotoapparat/hardware/display/Display;", "scaleType", "Lio/fotoapparat/parameter/ScaleType;", "cameraRenderer", "Lio/fotoapparat/view/CameraRenderer;", "focusPointSelector", "Lio/fotoapparat/view/FocalPointSelector;", "executor", "Lio/fotoapparat/concurrent/CameraExecutor;", "numberOfCameras", "", "initialConfiguration", "Lio/fotoapparat/configuration/CameraConfiguration;", "initialLensPositionSelector", "Lkotlin/Function1;", "", "Lio/fotoapparat/characteristic/LensPosition;", "Lio/fotoapparat/selector/LensPositionSelector;", "Lkotlin/ExtensionFunctionType;", "(Lio/fotoapparat/log/Logger;Lio/fotoapparat/hardware/display/Display;Lio/fotoapparat/parameter/ScaleType;Lio/fotoapparat/view/CameraRenderer;Lio/fotoapparat/view/FocalPointSelector;Lio/fotoapparat/concurrent/CameraExecutor;ILio/fotoapparat/configuration/CameraConfiguration;Lkotlin/jvm/functions/Function1;)V", "getCameraRenderer$fotoapparat_release", "()Lio/fotoapparat/view/CameraRenderer;", "cameras", "", "Lio/fotoapparat/hardware/CameraDevice;", "getExecutor$fotoapparat_release", "()Lio/fotoapparat/concurrent/CameraExecutor;", "getFocusPointSelector$fotoapparat_release", "()Lio/fotoapparat/view/FocalPointSelector;", "lensPositionSelector", "getLogger$fotoapparat_release", "()Lio/fotoapparat/log/Logger;", "savedConfiguration", "getScaleType$fotoapparat_release", "()Lio/fotoapparat/parameter/ScaleType;", "selectedCameraDevice", "Lkotlinx/coroutines/CompletableDeferred;", "awaitSelectedCamera", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canSelectCamera", "", "clearSelectedCamera", "", "getCameraParameters", "Lio/fotoapparat/parameter/camera/CameraParameters;", "cameraDevice", "(Lio/fotoapparat/hardware/CameraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfiguration", "getFrameProcessor", "Lio/fotoapparat/preview/Frame;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "frame", "Lio/fotoapparat/util/FrameProcessor;", "getLensPositionSelector", "getScreenOrientation", "Lio/fotoapparat/hardware/orientation/Orientation;", "getSelectedCamera", "hasSelectedCamera", "selectCamera", "updateConfiguration", "newConfiguration", "Lio/fotoapparat/configuration/Configuration;", "updateLensPositionSelector", "newLensPosition", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Device.kt */
public class Device {
    private final CameraRenderer cameraRenderer;
    private final List<CameraDevice> cameras;
    private final Display display;
    private final CameraExecutor executor;
    private final FocalPointSelector focusPointSelector;
    private Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> lensPositionSelector;
    private final Logger logger;
    private CameraConfiguration savedConfiguration;
    private final ScaleType scaleType;
    private CompletableDeferred<CameraDevice> selectedCameraDevice;

    public Object awaitSelectedCamera(Continuation<? super CameraDevice> continuation) {
        return this.selectedCameraDevice.await(continuation);
    }

    public Object getCameraParameters(CameraDevice cameraDevice, Continuation<? super CameraParameters> continuation) {
        return getCameraParameters$suspendImpl(this, cameraDevice, continuation);
    }

    public Device(Logger logger2, Display display2, ScaleType scaleType2, CameraRenderer cameraRenderer2, FocalPointSelector focalPointSelector, CameraExecutor cameraExecutor, int i, CameraConfiguration cameraConfiguration, Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1) {
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(display2, "display");
        Intrinsics.checkParameterIsNotNull(scaleType2, "scaleType");
        Intrinsics.checkParameterIsNotNull(cameraRenderer2, "cameraRenderer");
        Intrinsics.checkParameterIsNotNull(cameraExecutor, "executor");
        Intrinsics.checkParameterIsNotNull(cameraConfiguration, "initialConfiguration");
        Intrinsics.checkParameterIsNotNull(function1, "initialLensPositionSelector");
        this.logger = logger2;
        this.display = display2;
        this.scaleType = scaleType2;
        this.cameraRenderer = cameraRenderer2;
        this.focusPointSelector = focalPointSelector;
        this.executor = cameraExecutor;
        Iterable until = RangesKt.until(0, i);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it2 = until.iterator();
        while (it2.hasNext()) {
            arrayList.add(new CameraDevice(getLogger$fotoapparat_release(), CameraInfoProviderKt.getCharacteristics(((IntIterator) it2).nextInt())));
        }
        this.cameras = (List) arrayList;
        this.lensPositionSelector = function1;
        this.selectedCameraDevice = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.savedConfiguration = CameraConfiguration.Companion.m1default();
        updateLensPositionSelector(function1);
        this.savedConfiguration = cameraConfiguration;
    }

    public Logger getLogger$fotoapparat_release() {
        return this.logger;
    }

    public ScaleType getScaleType$fotoapparat_release() {
        return this.scaleType;
    }

    public CameraRenderer getCameraRenderer$fotoapparat_release() {
        return this.cameraRenderer;
    }

    public final FocalPointSelector getFocusPointSelector$fotoapparat_release() {
        return this.focusPointSelector;
    }

    public final CameraExecutor getExecutor$fotoapparat_release() {
        return this.executor;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Device(Logger logger2, Display display2, ScaleType scaleType2, CameraRenderer cameraRenderer2, FocalPointSelector focalPointSelector, CameraExecutor cameraExecutor, int i, CameraConfiguration cameraConfiguration, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger2, display2, scaleType2, cameraRenderer2, focalPointSelector, cameraExecutor, (i2 & 64) != 0 ? Camera.getNumberOfCameras() : i, cameraConfiguration, function1);
    }

    public boolean canSelectCamera(Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "lensPositionSelector");
        return DeviceKt.selectCamera(this.cameras, function1) != null;
    }

    public void selectCamera() {
        getLogger$fotoapparat_release().recordMethod();
        CameraDevice selectCamera = DeviceKt.selectCamera(this.cameras, this.lensPositionSelector);
        if (selectCamera != null) {
            this.selectedCameraDevice.complete(selectCamera);
        } else {
            this.selectedCameraDevice.completeExceptionally(new UnsupportedLensException());
        }
    }

    public void clearSelectedCamera() {
        this.selectedCameraDevice = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    public CameraDevice getSelectedCamera() {
        try {
            return this.selectedCameraDevice.getCompleted();
        } catch (IllegalStateException unused) {
            throw new IllegalStateException("Camera has not started!");
        }
    }

    public boolean hasSelectedCamera() {
        return this.selectedCameraDevice.isCompleted();
    }

    public Orientation getScreenOrientation() {
        return this.display.getOrientation();
    }

    public void updateLensPositionSelector(Function1<? super Iterable<? extends LensPosition>, ? extends LensPosition> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "newLensPosition");
        getLogger$fotoapparat_release().recordMethod();
        this.lensPositionSelector = function1;
    }

    public void updateConfiguration(Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(configuration, "newConfiguration");
        getLogger$fotoapparat_release().recordMethod();
        this.savedConfiguration = DeviceKt.updateConfiguration(this.savedConfiguration, configuration);
    }

    public CameraConfiguration getConfiguration() {
        return this.savedConfiguration;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object getCameraParameters$suspendImpl(io.fotoapparat.hardware.Device r5, io.fotoapparat.hardware.CameraDevice r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.fotoapparat.hardware.Device$getCameraParameters$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.fotoapparat.hardware.Device$getCameraParameters$1 r0 = (io.fotoapparat.hardware.Device$getCameraParameters$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.fotoapparat.hardware.Device$getCameraParameters$1 r0 = new io.fotoapparat.hardware.Device$getCameraParameters$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r5 = r0.L$2
            io.fotoapparat.configuration.CameraConfiguration r5 = (io.fotoapparat.configuration.CameraConfiguration) r5
            java.lang.Object r6 = r0.L$1
            io.fotoapparat.hardware.CameraDevice r6 = (io.fotoapparat.hardware.CameraDevice) r6
            java.lang.Object r6 = r0.L$0
            io.fotoapparat.hardware.Device r6 = (io.fotoapparat.hardware.Device) r6
            boolean r6 = r7 instanceof kotlin.Result.Failure
            if (r6 != 0) goto L_0x0037
            goto L_0x005c
        L_0x0037:
            kotlin.Result$Failure r7 = (kotlin.Result.Failure) r7
            java.lang.Throwable r5 = r7.exception
            throw r5
        L_0x003c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0044:
            boolean r2 = r7 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0063
            io.fotoapparat.configuration.CameraConfiguration r7 = r5.savedConfiguration
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r5 = r6.getCapabilities(r0)
            if (r5 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x005c:
            io.fotoapparat.capability.Capabilities r7 = (io.fotoapparat.capability.Capabilities) r7
            io.fotoapparat.parameter.camera.CameraParameters r5 = io.fotoapparat.parameter.camera.provide.CameraParametersProviderKt.getCameraParameters(r7, r5)
            return r5
        L_0x0063:
            kotlin.Result$Failure r7 = (kotlin.Result.Failure) r7
            java.lang.Throwable r5 = r7.exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fotoapparat.hardware.Device.getCameraParameters$suspendImpl(io.fotoapparat.hardware.Device, io.fotoapparat.hardware.CameraDevice, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Function1<Frame, Unit> getFrameProcessor() {
        return this.savedConfiguration.getFrameProcessor();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Iterable<? extends io.fotoapparat.characteristic.LensPosition>, ? extends io.fotoapparat.characteristic.LensPosition>, kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.characteristic.LensPosition>, io.fotoapparat.characteristic.LensPosition> */
    public Function1<Iterable<? extends LensPosition>, LensPosition> getLensPositionSelector() {
        return this.lensPositionSelector;
    }
}
