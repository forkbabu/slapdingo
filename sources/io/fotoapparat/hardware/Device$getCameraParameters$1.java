package io.fotoapparat.hardware;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.spongycastle.crypto.tls.CipherSuite;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000"}, d2 = {"getCameraParameters", "", "cameraDevice", "Lio/fotoapparat/hardware/CameraDevice;", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/fotoapparat/parameter/camera/CameraParameters;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "io/fotoapparat/hardware/Device", f = "Device.kt", i = {0, 0}, l = {143, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA}, m = "getCameraParameters$suspendImpl", n = {"this", "cameraDevice"}, s = {"L$0", "L$1"})
/* compiled from: Device.kt */
public final class Device$getCameraParameters$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Device this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Device$getCameraParameters$1(Device device, Continuation continuation) {
        super(continuation);
        this.this$0 = device;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Device.getCameraParameters$suspendImpl(this.this$0, null, this);
    }
}
