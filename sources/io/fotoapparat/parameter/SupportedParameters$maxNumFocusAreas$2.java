package io.fotoapparat.parameter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: SupportedParameters.kt */
final class SupportedParameters$maxNumFocusAreas$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ SupportedParameters this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SupportedParameters$maxNumFocusAreas$2(SupportedParameters supportedParameters) {
        super(0);
        this.this$0 = supportedParameters;
    }

    /* Return type fixed from 'int' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        return this.this$0.cameraParameters.getMaxNumFocusAreas();
    }
}
