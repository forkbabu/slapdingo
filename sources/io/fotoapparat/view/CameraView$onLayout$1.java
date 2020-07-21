package io.fotoapparat.view;

import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
/* compiled from: CameraView.kt */
final class CameraView$onLayout$1 extends MutablePropertyReference0 {
    CameraView$onLayout$1(CameraView cameraView) {
        super(cameraView);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "previewResolution";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(CameraView.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getPreviewResolution()Lio/fotoapparat/parameter/Resolution;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return CameraView.access$getPreviewResolution$p((CameraView) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((CameraView) this.receiver).previewResolution = (Resolution) obj;
    }
}
