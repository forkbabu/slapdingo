package io.fotoapparat.view;

import io.fotoapparat.parameter.ScaleType;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
/* compiled from: CameraView.kt */
final class CameraView$onLayout$2 extends MutablePropertyReference0 {
    CameraView$onLayout$2(CameraView cameraView) {
        super(cameraView);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "scaleType";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(CameraView.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getScaleType()Lio/fotoapparat/parameter/ScaleType;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return CameraView.access$getScaleType$p((CameraView) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((CameraView) this.receiver).scaleType = (ScaleType) obj;
    }
}
