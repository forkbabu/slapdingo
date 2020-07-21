package io.fotoapparat;

import android.content.Context;
import io.fotoapparat.hardware.orientation.OrientationSensor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/fotoapparat/hardware/orientation/OrientationSensor;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: Fotoapparat.kt */
final class Fotoapparat$orientationSensor$2 extends Lambda implements Function0<OrientationSensor> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Fotoapparat this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Fotoapparat$orientationSensor$2(Fotoapparat fotoapparat, Context context) {
        super(0);
        this.this$0 = fotoapparat;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final OrientationSensor invoke() {
        return new OrientationSensor(this.$context, this.this$0.device);
    }
}
