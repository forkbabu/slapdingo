package io.fotoapparat.preview;

import android.hardware.Camera;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.itextpdf.text.Annotation;
import io.fotoapparat.hardware.ExecutorKt;
import io.fotoapparat.hardware.orientation.Orientation;
import io.fotoapparat.parameter.Resolution;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\u0016\u001a\u00020\u00122%\u0010\u0017\u001a!\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rj\u0002`\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J1\u0010\"\u001a\u00020\u00122)\u0010#\u001a%\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0013J\f\u0010$\u001a\u00020\u0012*\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u001b*\u00060&R\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR3\u0010\u000b\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rj\u0002`\u00130\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lio/fotoapparat/preview/PreviewStream;", "", "camera", "Landroid/hardware/Camera;", "(Landroid/hardware/Camera;)V", "frameOrientation", "Lio/fotoapparat/hardware/orientation/Orientation;", "getFrameOrientation", "()Lio/fotoapparat/hardware/orientation/Orientation;", "setFrameOrientation", "(Lio/fotoapparat/hardware/orientation/Orientation;)V", "frameProcessors", "Ljava/util/LinkedHashSet;", "Lkotlin/Function1;", "Lio/fotoapparat/preview/Frame;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "frame", "", "Lio/fotoapparat/util/FrameProcessor;", "previewResolution", "Lio/fotoapparat/parameter/Resolution;", "addProcessor", "processor", "clearProcessors", "dispatchFrame", "image", "", "dispatchFrameOnBackgroundThread", "data", "ensurePreviewSizeAvailable", "returnFrameToBuffer", "start", "stop", "updateProcessorSafely", "frameProcessor", "addFrameToBuffer", "allocateBuffer", "Landroid/hardware/Camera$Parameters;", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: PreviewStream.kt */
public final class PreviewStream {
    private final Camera camera;
    private Orientation frameOrientation = Orientation.Vertical.Portrait.INSTANCE;
    /* access modifiers changed from: private */
    public final LinkedHashSet<Function1<Frame, Unit>> frameProcessors = new LinkedHashSet<>();
    private Resolution previewResolution;

    public PreviewStream(Camera camera2) {
        Intrinsics.checkParameterIsNotNull(camera2, "camera");
        this.camera = camera2;
    }

    public final Orientation getFrameOrientation() {
        return this.frameOrientation;
    }

    public final void setFrameOrientation(Orientation orientation) {
        Intrinsics.checkParameterIsNotNull(orientation, "<set-?>");
        this.frameOrientation = orientation;
    }

    private final void clearProcessors() {
        synchronized (this.frameProcessors) {
            this.frameProcessors.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void addProcessor(Function1<? super Frame, Unit> function1) {
        synchronized (this.frameProcessors) {
            this.frameProcessors.add(function1);
        }
    }

    private final void start() {
        addFrameToBuffer(this.camera);
        this.camera.setPreviewCallbackWithBuffer(new PreviewStream$start$1(this));
    }

    private final void stop() {
        this.camera.setPreviewCallbackWithBuffer(null);
    }

    public final void updateProcessorSafely(Function1<? super Frame, Unit> function1) {
        clearProcessors();
        if (function1 == null) {
            stop();
            return;
        }
        addProcessor(function1);
        start();
    }

    private final void addFrameToBuffer(Camera camera2) {
        Camera.Parameters parameters = camera2.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(parameters, Annotation.PARAMETERS);
        camera2.addCallbackBuffer(allocateBuffer(parameters));
    }

    private final byte[] allocateBuffer(Camera.Parameters parameters) {
        PreviewStreamKt.ensureNv21Format(parameters);
        this.previewResolution = new Resolution(parameters.getPreviewSize().width, parameters.getPreviewSize().height);
        Camera.Size previewSize = parameters.getPreviewSize();
        Intrinsics.checkExpressionValueIsNotNull(previewSize, "previewSize");
        return new byte[PreviewStreamKt.bytesPerFrame(previewSize)];
    }

    /* access modifiers changed from: private */
    public final void dispatchFrameOnBackgroundThread(byte[] bArr) {
        ExecutorKt.getFrameProcessingExecutor().execute(new PreviewStream$dispatchFrameOnBackgroundThread$1(this, bArr));
    }

    /* access modifiers changed from: private */
    public final void dispatchFrame(byte[] bArr) {
        Frame frame = new Frame(ensurePreviewSizeAvailable(), bArr, this.frameOrientation.getDegrees());
        Iterator it2 = this.frameProcessors.iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(frame);
        }
        returnFrameToBuffer(frame);
    }

    private final Resolution ensurePreviewSizeAvailable() {
        Resolution resolution = this.previewResolution;
        if (resolution != null) {
            return resolution;
        }
        throw new IllegalStateException("previewSize is null. Frame was not added?");
    }

    private final void returnFrameToBuffer(Frame frame) {
        this.camera.addCallbackBuffer(frame.getImage());
    }
}
