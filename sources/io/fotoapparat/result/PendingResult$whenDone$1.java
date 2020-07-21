package io.fotoapparat.result;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0017\u0010\u0003\u001a\u0013\u0018\u0001H\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "p1", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "it", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 13})
/* compiled from: PendingResult.kt */
final class PendingResult$whenDone$1 extends FunctionReference implements Function1<T, Unit> {
    PendingResult$whenDone$1(WhenDoneListener whenDoneListener) {
        super(1, whenDoneListener);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "whenDone";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(WhenDoneListener.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "whenDone(Ljava/lang/Object;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public final void invoke(T t) {
        ((WhenDoneListener) this.receiver).whenDone(t);
    }
}
