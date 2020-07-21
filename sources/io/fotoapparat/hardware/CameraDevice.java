package io.fotoapparat.hardware;

import android.hardware.Camera;
import android.media.MediaRecorder;
import android.view.Surface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.fotoapparat.capability.Capabilities;
import io.fotoapparat.capability.provide.CapabilitiesProviderKt;
import io.fotoapparat.characteristic.Characteristics;
import io.fotoapparat.characteristic.LensPosition;
import io.fotoapparat.characteristic.LensPositionCharacteristicKt;
import io.fotoapparat.coroutines.AwaitBroadcastChannel;
import io.fotoapparat.exception.camera.CameraException;
import io.fotoapparat.hardware.metering.FocalRequest;
import io.fotoapparat.hardware.orientation.Orientation;
import io.fotoapparat.hardware.orientation.OrientationResolverKt;
import io.fotoapparat.hardware.orientation.OrientationState;
import io.fotoapparat.log.Logger;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.parameter.camera.CameraParameters;
import io.fotoapparat.preview.Frame;
import io.fotoapparat.preview.PreviewStream;
import io.fotoapparat.result.FocusResult;
import io.fotoapparat.result.Photo;
import io.fotoapparat.util.StringExtensionsKt;
import io.fotoapparat.view.Preview;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\u0011\u0010#\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010$J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020\u001cH\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0016J\u0019\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u00103J\u0012\u00104\u001a\u00020\u001c2\b\b\u0001\u00105\u001a\u000206H\u0016J\u0012\u00107\u001a\u00020\u001c2\b\b\u0001\u00105\u001a\u000206H\u0002J\u0012\u00108\u001a\u00020\u001c2\b\b\u0001\u00105\u001a\u000206H\u0002J\b\u00109\u001a\u00020\u001cH\u0016J\b\u0010:\u001a\u00020\u001cH\u0016J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u001cH\u0016J3\u0010>\u001a\u00020\u001c2)\u0010?\u001a%\u0012\u0013\u0012\u00110A¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u001c\u0018\u00010@j\u0004\u0018\u0001`EH\u0016J\u0019\u0010F\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010GJ\u0014\u0010H\u001a\u00060\bR\u00020\t*\u00060\bR\u00020\tH\u0002J\f\u0010I\u001a\u00020\u001c*\u00020\tH\u0002J\f\u0010J\u001a\u00020 *\u00020\tH\u0002J\u0014\u0010K\u001a\u00060\bR\u00020\t*\u00060\bR\u00020\tH\u0002J\u001d\u0010L\u001a\u00020\u001c*\u00020\t2\u0006\u00101\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u0010MR\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"Lio/fotoapparat/hardware/CameraDevice;", "", "logger", "Lio/fotoapparat/log/Logger;", "characteristics", "Lio/fotoapparat/characteristic/Characteristics;", "(Lio/fotoapparat/log/Logger;Lio/fotoapparat/characteristic/Characteristics;)V", "cachedCameraParameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "camera", "cameraParameters", "Lio/fotoapparat/coroutines/AwaitBroadcastChannel;", "Lio/fotoapparat/parameter/camera/CameraParameters;", "capabilities", "Lkotlinx/coroutines/CompletableDeferred;", "Lio/fotoapparat/capability/Capabilities;", "getCharacteristics", "()Lio/fotoapparat/characteristic/Characteristics;", "displayOrientation", "Lio/fotoapparat/hardware/orientation/Orientation;", "imageOrientation", "previewOrientation", "previewStream", "Lio/fotoapparat/preview/PreviewStream;", "surface", "Landroid/view/Surface;", "attachRecordingCamera", "", "mediaRecorder", "Landroid/media/MediaRecorder;", "autoFocus", "Lio/fotoapparat/result/FocusResult;", "clearFocalPoint", "close", "getCapabilities", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParameters", "getPreviewResolution", "Lio/fotoapparat/parameter/Resolution;", "lock", "open", "setDisplayOrientation", "orientationState", "Lio/fotoapparat/hardware/orientation/OrientationState;", "setDisplaySurface", "preview", "Lio/fotoapparat/view/Preview;", "setFocalPoint", "focalRequest", "Lio/fotoapparat/hardware/metering/FocalRequest;", "(Lio/fotoapparat/hardware/metering/FocalRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setZoom", FirebaseAnalytics.Param.LEVEL, "", "setZoomSafely", "setZoomUnsafe", "startPreview", "stopPreview", "takePhoto", "Lio/fotoapparat/result/Photo;", "unlock", "updateFrameProcessor", "frameProcessor", "Lkotlin/Function1;", "Lio/fotoapparat/preview/Frame;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "frame", "Lio/fotoapparat/util/FrameProcessor;", "updateParameters", "(Lio/fotoapparat/parameter/camera/CameraParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheLocally", "clearFocusingAreas", "focusSafely", "setInCamera", "updateFocusingAreas", "(Landroid/hardware/Camera;Lio/fotoapparat/hardware/metering/FocalRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: CameraDevice.kt */
public class CameraDevice {
    private Camera.Parameters cachedCameraParameters;
    private Camera camera;
    private final AwaitBroadcastChannel<CameraParameters> cameraParameters = new AwaitBroadcastChannel<>(null, null, 3, null);
    private final CompletableDeferred<Capabilities> capabilities = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    private final Characteristics characteristics;
    private Orientation displayOrientation;
    private Orientation imageOrientation;
    private final Logger logger;
    private Orientation previewOrientation;
    private PreviewStream previewStream;
    private Surface surface;

    public Object getCapabilities(Continuation<? super Capabilities> continuation) {
        return this.logger.recordMethod();
    }

    public Object getParameters(Continuation<? super CameraParameters> continuation) {
        return this.logger.recordMethod();
    }

    public Object setFocalPoint(FocalRequest focalRequest, Continuation<? super Unit> continuation) {
        return setFocalPoint$suspendImpl(this, focalRequest, continuation);
    }

    public Object updateParameters(CameraParameters cameraParameters2, Continuation<? super Unit> continuation) {
        return updateParameters$suspendImpl(this, cameraParameters2, continuation);
    }

    public CameraDevice(Logger logger2, Characteristics characteristics2) {
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(characteristics2, "characteristics");
        this.logger = logger2;
        this.characteristics = characteristics2;
    }

    public final Characteristics getCharacteristics() {
        return this.characteristics;
    }

    public void open() {
        this.logger.recordMethod();
        LensPosition lensPosition = this.characteristics.getLensPosition();
        int cameraId = LensPositionCharacteristicKt.toCameraId(lensPosition);
        try {
            Camera open = Camera.open(cameraId);
            Intrinsics.checkExpressionValueIsNotNull(open, "Camera.open(cameraId)");
            this.camera = open;
            CompletableDeferred<Capabilities> completableDeferred = this.capabilities;
            if (open == null) {
                Intrinsics.throwUninitializedPropertyAccessException("camera");
            }
            completableDeferred.complete(CapabilitiesProviderKt.getCapabilities(open));
            Camera camera2 = this.camera;
            if (camera2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("camera");
            }
            this.previewStream = new PreviewStream(camera2);
        } catch (RuntimeException e) {
            throw new CameraException("Failed to open camera with lens position: " + lensPosition + " and id: " + cameraId, e);
        }
    }

    public void close() {
        this.logger.recordMethod();
        Surface surface2 = this.surface;
        if (surface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("surface");
        }
        surface2.release();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        camera2.release();
    }

    public void startPreview() {
        this.logger.recordMethod();
        try {
            Camera camera2 = this.camera;
            if (camera2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("camera");
            }
            camera2.startPreview();
        } catch (RuntimeException e) {
            throw new CameraException("Failed to start preview for camera with lens " + "position: " + this.characteristics.getLensPosition() + " and id: " + this.characteristics.getCameraId(), e);
        }
    }

    public void stopPreview() {
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        camera2.stopPreview();
    }

    public void unlock() {
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        camera2.unlock();
    }

    public void lock() {
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        camera2.lock();
    }

    public Photo takePhoto() {
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        Orientation orientation = this.imageOrientation;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageOrientation");
        }
        return CameraDeviceKt.takePhoto(camera2, orientation.getDegrees());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object updateParameters$suspendImpl(io.fotoapparat.hardware.CameraDevice r4, io.fotoapparat.parameter.camera.CameraParameters r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.fotoapparat.hardware.CameraDevice$updateParameters$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.fotoapparat.hardware.CameraDevice$updateParameters$1 r0 = (io.fotoapparat.hardware.CameraDevice$updateParameters$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.fotoapparat.hardware.CameraDevice$updateParameters$1 r0 = new io.fotoapparat.hardware.CameraDevice$updateParameters$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.fotoapparat.parameter.camera.CameraParameters r5 = (io.fotoapparat.parameter.camera.CameraParameters) r5
            java.lang.Object r4 = r0.L$0
            io.fotoapparat.hardware.CameraDevice r4 = (io.fotoapparat.hardware.CameraDevice) r4
            boolean r0 = r6 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L_0x0034
            goto L_0x0059
        L_0x0034:
            kotlin.Result$Failure r6 = (kotlin.Result.Failure) r6
            java.lang.Throwable r4 = r6.exception
            throw r4
        L_0x0039:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0041:
            boolean r2 = r6 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0094
            io.fotoapparat.log.Logger r6 = r4.logger
            r6.recordMethod()
            io.fotoapparat.coroutines.AwaitBroadcastChannel<io.fotoapparat.parameter.camera.CameraParameters> r6 = r4.cameraParameters
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.send(r5, r0)
            if (r6 != r1) goto L_0x0059
            return r1
        L_0x0059:
            io.fotoapparat.log.Logger r6 = r4.logger
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "New camera parameters are: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r6.log(r0)
            android.hardware.Camera$Parameters r6 = r4.cachedCameraParameters
            if (r6 == 0) goto L_0x0074
            goto L_0x0086
        L_0x0074:
            android.hardware.Camera r6 = r4.camera
            if (r6 != 0) goto L_0x007d
            java.lang.String r0 = "camera"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L_0x007d:
            android.hardware.Camera$Parameters r6 = r6.getParameters()
            java.lang.String r0 = "camera.parameters"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r0)
        L_0x0086:
            android.hardware.Camera$Parameters r5 = io.fotoapparat.parameter.camera.apply.CameraParametersApplicatorKt.applyInto(r5, r6)
            android.hardware.Camera$Parameters r5 = r4.cacheLocally(r5)
            r4.setInCamera(r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0094:
            kotlin.Result$Failure r6 = (kotlin.Result.Failure) r6
            java.lang.Throwable r4 = r6.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fotoapparat.hardware.CameraDevice.updateParameters$suspendImpl(io.fotoapparat.hardware.CameraDevice, io.fotoapparat.parameter.camera.CameraParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void updateFrameProcessor(Function1<? super Frame, Unit> function1) {
        this.logger.recordMethod();
        PreviewStream previewStream2 = this.previewStream;
        if (previewStream2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewStream");
        }
        previewStream2.updateProcessorSafely(function1);
    }

    public void setDisplayOrientation(OrientationState orientationState) {
        Intrinsics.checkParameterIsNotNull(orientationState, "orientationState");
        this.logger.recordMethod();
        this.imageOrientation = OrientationResolverKt.computeImageOrientation(orientationState.getDeviceOrientation(), this.characteristics.getCameraOrientation(), this.characteristics.isMirrored());
        this.displayOrientation = OrientationResolverKt.computeDisplayOrientation(orientationState.getScreenOrientation(), this.characteristics.getCameraOrientation(), this.characteristics.isMirrored());
        this.previewOrientation = OrientationResolverKt.computePreviewOrientation(orientationState.getScreenOrientation(), this.characteristics.getCameraOrientation(), this.characteristics.isMirrored());
        Logger logger2 = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("Orientations: ");
        sb.append(StringExtensionsKt.getLineSeparator());
        sb.append("Screen orientation (preview) is: ");
        sb.append(orientationState.getScreenOrientation());
        sb.append(". ");
        sb.append(StringExtensionsKt.getLineSeparator());
        sb.append("Camera sensor orientation is always at: ");
        sb.append(this.characteristics.getCameraOrientation());
        sb.append(". ");
        sb.append(StringExtensionsKt.getLineSeparator());
        sb.append("Camera is ");
        sb.append(this.characteristics.isMirrored() ? "mirrored." : "not mirrored.");
        logger2.log(sb.toString());
        Logger logger3 = this.logger;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Orientation adjustments: ");
        sb2.append(StringExtensionsKt.getLineSeparator());
        sb2.append("Image orientation will be adjusted by: ");
        Orientation orientation = this.imageOrientation;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageOrientation");
        }
        sb2.append(orientation.getDegrees());
        sb2.append(" degrees. ");
        sb2.append(StringExtensionsKt.getLineSeparator());
        sb2.append("Display orientation will be adjusted by: ");
        Orientation orientation2 = this.displayOrientation;
        if (orientation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayOrientation");
        }
        sb2.append(orientation2.getDegrees());
        sb2.append(" degrees. ");
        sb2.append(StringExtensionsKt.getLineSeparator());
        sb2.append("Preview orientation will be adjusted by: ");
        Orientation orientation3 = this.previewOrientation;
        if (orientation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewOrientation");
        }
        sb2.append(orientation3.getDegrees());
        sb2.append(" degrees.");
        logger3.log(sb2.toString());
        PreviewStream previewStream2 = this.previewStream;
        if (previewStream2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewStream");
        }
        Orientation orientation4 = this.previewOrientation;
        if (orientation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewOrientation");
        }
        previewStream2.setFrameOrientation(orientation4);
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        Orientation orientation5 = this.displayOrientation;
        if (orientation5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayOrientation");
        }
        camera2.setDisplayOrientation(orientation5.getDegrees());
    }

    public void setZoom(float f) {
        this.logger.recordMethod();
        setZoomSafely(f);
    }

    public FocusResult autoFocus() {
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        return focusSafely(camera2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object setFocalPoint$suspendImpl(io.fotoapparat.hardware.CameraDevice r5, io.fotoapparat.hardware.metering.FocalRequest r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.fotoapparat.hardware.CameraDevice$setFocalPoint$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.fotoapparat.hardware.CameraDevice$setFocalPoint$1 r0 = (io.fotoapparat.hardware.CameraDevice$setFocalPoint$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.fotoapparat.hardware.CameraDevice$setFocalPoint$1 r0 = new io.fotoapparat.hardware.CameraDevice$setFocalPoint$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r5 = r0.L$1
            io.fotoapparat.hardware.metering.FocalRequest r5 = (io.fotoapparat.hardware.metering.FocalRequest) r5
            java.lang.Object r5 = r0.L$0
            io.fotoapparat.hardware.CameraDevice r5 = (io.fotoapparat.hardware.CameraDevice) r5
            boolean r5 = r7 instanceof kotlin.Result.Failure
            if (r5 != 0) goto L_0x0036
            goto L_0x008c
        L_0x0036:
            kotlin.Result$Failure r7 = (kotlin.Result.Failure) r7
            java.lang.Throwable r5 = r7.exception
            throw r5
        L_0x003b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0043:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            io.fotoapparat.hardware.metering.FocalRequest r6 = (io.fotoapparat.hardware.metering.FocalRequest) r6
            java.lang.Object r5 = r0.L$0
            io.fotoapparat.hardware.CameraDevice r5 = (io.fotoapparat.hardware.CameraDevice) r5
            boolean r2 = r7 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0051
            goto L_0x006e
        L_0x0051:
            kotlin.Result$Failure r7 = (kotlin.Result.Failure) r7
            java.lang.Throwable r5 = r7.exception
            throw r5
        L_0x0056:
            boolean r2 = r7 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0090
            io.fotoapparat.log.Logger r7 = r5.logger
            r7.recordMethod()
            kotlinx.coroutines.CompletableDeferred<io.fotoapparat.capability.Capabilities> r7 = r5.capabilities
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L_0x006e
            return r1
        L_0x006e:
            io.fotoapparat.capability.Capabilities r7 = (io.fotoapparat.capability.Capabilities) r7
            boolean r7 = io.fotoapparat.hardware.CameraDeviceKt.canSetFocusingAreas(r7)
            if (r7 == 0) goto L_0x008d
            android.hardware.Camera r7 = r5.camera
            if (r7 != 0) goto L_0x007f
            java.lang.String r2 = "camera"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x007f:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.updateFocusingAreas(r7, r6, r0)
            if (r7 != r1) goto L_0x008c
            return r1
        L_0x008c:
            return r7
        L_0x008d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0090:
            kotlin.Result$Failure r7 = (kotlin.Result.Failure) r7
            java.lang.Throwable r5 = r7.exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fotoapparat.hardware.CameraDevice.setFocalPoint$suspendImpl(io.fotoapparat.hardware.CameraDevice, io.fotoapparat.hardware.metering.FocalRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void clearFocalPoint() {
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        clearFocusingAreas(camera2);
    }

    public void setDisplaySurface(Preview preview) throws IOException {
        Intrinsics.checkParameterIsNotNull(preview, "preview");
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        this.surface = CameraDeviceKt.setDisplaySurface(camera2, preview);
    }

    public void attachRecordingCamera(MediaRecorder mediaRecorder) {
        Intrinsics.checkParameterIsNotNull(mediaRecorder, "mediaRecorder");
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        mediaRecorder.setCamera(camera2);
    }

    public Resolution getPreviewResolution() {
        this.logger.recordMethod();
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        Orientation orientation = this.previewOrientation;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewOrientation");
        }
        Resolution access$getPreviewResolution = CameraDeviceKt.getPreviewResolution(camera2, orientation);
        Logger logger2 = this.logger;
        logger2.log("Preview resolution is: " + access$getPreviewResolution);
        return access$getPreviewResolution;
    }

    private final void setZoomSafely(float f) {
        try {
            setZoomUnsafe(f);
        } catch (Exception e) {
            Logger logger2 = this.logger;
            logger2.log("Unable to change zoom level to " + f + " e: " + e.getMessage());
        }
    }

    private final void setZoomUnsafe(float f) {
        Camera.Parameters parameters = this.cachedCameraParameters;
        if (parameters == null) {
            Camera camera2 = this.camera;
            if (camera2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("camera");
            }
            parameters = camera2.getParameters();
        }
        parameters.setZoom((int) (((float) parameters.getMaxZoom()) * f));
        Intrinsics.checkExpressionValueIsNotNull(parameters, "(cachedCameraParameters …toInt()\n                }");
        setInCamera(cacheLocally(parameters));
    }

    private final Camera.Parameters cacheLocally(Camera.Parameters parameters) {
        this.cachedCameraParameters = parameters;
        return parameters;
    }

    private final Camera.Parameters setInCamera(Camera.Parameters parameters) {
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        camera2.setParameters(parameters);
        return parameters;
    }

    private final FocusResult focusSafely(Camera camera2) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            camera2.autoFocus(new CameraDevice$focusSafely$1(countDownLatch));
            try {
                countDownLatch.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
            return FocusResult.Focused.INSTANCE;
        } catch (Exception e) {
            Logger logger2 = this.logger;
            logger2.log("Failed to perform autofocus using device " + this.characteristics.getCameraId() + " e: " + e.getMessage());
            return FocusResult.UnableToFocus.INSTANCE;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object updateFocusingAreas(android.hardware.Camera r6, io.fotoapparat.hardware.metering.FocalRequest r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.fotoapparat.hardware.CameraDevice$updateFocusingAreas$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.fotoapparat.hardware.CameraDevice$updateFocusingAreas$1 r0 = (io.fotoapparat.hardware.CameraDevice$updateFocusingAreas$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.fotoapparat.hardware.CameraDevice$updateFocusingAreas$1 r0 = new io.fotoapparat.hardware.CameraDevice$updateFocusingAreas$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0054
            if (r2 != r3) goto L_0x004c
            java.lang.Object r6 = r0.L$6
            android.hardware.Camera r6 = (android.hardware.Camera) r6
            java.lang.Object r7 = r0.L$5
            android.hardware.Camera$Parameters r7 = (android.hardware.Camera.Parameters) r7
            java.lang.Object r1 = r0.L$4
            android.hardware.Camera$Parameters r1 = (android.hardware.Camera.Parameters) r1
            java.lang.Object r2 = r0.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$2
            io.fotoapparat.hardware.metering.FocalRequest r3 = (io.fotoapparat.hardware.metering.FocalRequest) r3
            java.lang.Object r3 = r0.L$1
            android.hardware.Camera r3 = (android.hardware.Camera) r3
            java.lang.Object r0 = r0.L$0
            io.fotoapparat.hardware.CameraDevice r0 = (io.fotoapparat.hardware.CameraDevice) r0
            boolean r0 = r8 instanceof kotlin.Result.Failure
            if (r0 != 0) goto L_0x0047
            goto L_0x008f
        L_0x0047:
            kotlin.Result$Failure r8 = (kotlin.Result.Failure) r8
            java.lang.Throwable r6 = r8.exception
            throw r6
        L_0x004c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0054:
            boolean r2 = r8 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x00c0
            io.fotoapparat.hardware.orientation.Orientation r8 = r5.displayOrientation
            if (r8 != 0) goto L_0x0061
            java.lang.String r2 = "displayOrientation"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0061:
            int r8 = r8.getDegrees()
            io.fotoapparat.characteristic.Characteristics r2 = r5.characteristics
            boolean r2 = r2.isMirrored()
            java.util.List r2 = io.fotoapparat.hardware.metering.convert.FocalPointConverterKt.toFocusAreas(r7, r8, r2)
            android.hardware.Camera$Parameters r8 = r6.getParameters()
            kotlinx.coroutines.CompletableDeferred<io.fotoapparat.capability.Capabilities> r4 = r5.capabilities
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r2
            r0.L$4 = r8
            r0.L$5 = r8
            r0.L$6 = r6
            r0.label = r3
            java.lang.Object r7 = r4.await(r0)
            if (r7 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r1 = r8
            r8 = r7
            r7 = r1
        L_0x008f:
            io.fotoapparat.capability.Capabilities r8 = (io.fotoapparat.capability.Capabilities) r8
            int r0 = r8.getMaxMeteringAreas()
            if (r0 <= 0) goto L_0x009a
            r7.setMeteringAreas(r2)
        L_0x009a:
            int r0 = r8.getMaxFocusAreas()
            if (r0 <= 0) goto L_0x00ba
            java.util.Set r8 = r8.getFocusModes()
            io.fotoapparat.parameter.FocusMode$Auto r0 = io.fotoapparat.parameter.FocusMode.Auto.INSTANCE
            boolean r8 = r8.contains(r0)
            if (r8 == 0) goto L_0x00b7
            io.fotoapparat.parameter.FocusMode$Auto r8 = io.fotoapparat.parameter.FocusMode.Auto.INSTANCE
            io.fotoapparat.parameter.FocusMode r8 = (io.fotoapparat.parameter.FocusMode) r8
            java.lang.String r8 = io.fotoapparat.parameter.camera.convert.FocusModeConverterKt.toCode(r8)
            r7.setFocusMode(r8)
        L_0x00b7:
            r7.setFocusAreas(r2)
        L_0x00ba:
            r6.setParameters(r1)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00c0:
            kotlin.Result$Failure r8 = (kotlin.Result.Failure) r8
            java.lang.Throwable r6 = r8.exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fotoapparat.hardware.CameraDevice.updateFocusingAreas(android.hardware.Camera, io.fotoapparat.hardware.metering.FocalRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void clearFocusingAreas(Camera camera2) {
        Camera.Parameters parameters = camera2.getParameters();
        List<Camera.Area> list = null;
        parameters.setMeteringAreas(list);
        parameters.setFocusAreas(list);
        camera2.setParameters(parameters);
    }
}
