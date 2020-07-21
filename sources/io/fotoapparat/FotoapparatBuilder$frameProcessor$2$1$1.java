package io.fotoapparat;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.fotoapparat.preview.Frame;
import io.fotoapparat.preview.FrameProcessor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lio/fotoapparat/preview/Frame;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "frame", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: FotoapparatBuilder.kt */
final class FotoapparatBuilder$frameProcessor$2$1$1 extends FunctionReference implements Function1<Frame, Unit> {
    FotoapparatBuilder$frameProcessor$2$1$1(FrameProcessor frameProcessor) {
        super(1, frameProcessor);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "process";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FrameProcessor.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "process(Lio/fotoapparat/preview/Frame;)V";
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Frame frame) {
        invoke(frame);
        return Unit.INSTANCE;
    }

    public final void invoke(Frame frame) {
        Intrinsics.checkParameterIsNotNull(frame, "p1");
        ((FrameProcessor) this.receiver).process(frame);
    }
}
