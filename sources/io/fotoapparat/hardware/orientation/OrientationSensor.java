package io.fotoapparat.hardware.orientation;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.fotoapparat.hardware.Device;
import io.fotoapparat.hardware.orientation.Orientation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u001c\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/fotoapparat/hardware/orientation/OrientationSensor;", "", "context", "Landroid/content/Context;", "device", "Lio/fotoapparat/hardware/Device;", "(Landroid/content/Context;Lio/fotoapparat/hardware/Device;)V", "rotationListener", "Lio/fotoapparat/hardware/orientation/RotationListener;", "(Lio/fotoapparat/hardware/orientation/RotationListener;Lio/fotoapparat/hardware/Device;)V", "lastKnownOrientationState", "Lio/fotoapparat/hardware/orientation/OrientationState;", "getLastKnownOrientationState", "()Lio/fotoapparat/hardware/orientation/OrientationState;", "setLastKnownOrientationState", "(Lio/fotoapparat/hardware/orientation/OrientationState;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "onOrientationChanged", "", "Lio/fotoapparat/hardware/orientation/DeviceRotationDegrees;", "start", "stop", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: OrientationSensor.kt */
public class OrientationSensor {
    /* access modifiers changed from: private */
    public final Device device;
    private OrientationState lastKnownOrientationState;
    /* access modifiers changed from: private */
    public Function1<? super OrientationState, Unit> listener;
    private final Function1<Integer, Unit> onOrientationChanged;
    private final RotationListener rotationListener;

    public OrientationSensor(RotationListener rotationListener2, Device device2) {
        Intrinsics.checkParameterIsNotNull(rotationListener2, "rotationListener");
        Intrinsics.checkParameterIsNotNull(device2, "device");
        this.rotationListener = rotationListener2;
        this.device = device2;
        this.onOrientationChanged = new OrientationSensor$onOrientationChanged$1(this);
        this.lastKnownOrientationState = new OrientationState(Orientation.Vertical.Portrait.INSTANCE, this.device.getScreenOrientation());
        this.rotationListener.setOrientationChanged(this.onOrientationChanged);
    }

    public static final /* synthetic */ Function1 access$getListener$p(OrientationSensor orientationSensor) {
        Function1<? super OrientationState, Unit> function1 = orientationSensor.listener;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        return function1;
    }

    public OrientationState getLastKnownOrientationState() {
        return this.lastKnownOrientationState;
    }

    public void setLastKnownOrientationState(OrientationState orientationState) {
        Intrinsics.checkParameterIsNotNull(orientationState, "<set-?>");
        this.lastKnownOrientationState = orientationState;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrientationSensor(Context context, Device device2) {
        this(new RotationListener(context), device2);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(device2, "device");
    }

    public void start(Function1<? super OrientationState, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = function1;
        this.rotationListener.enable();
    }

    public void stop() {
        this.rotationListener.disable();
    }
}
