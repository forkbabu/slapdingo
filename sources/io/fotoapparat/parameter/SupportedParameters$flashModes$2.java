package io.fotoapparat.parameter;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DebugKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: SupportedParameters.kt */
final class SupportedParameters$flashModes$2 extends Lambda implements Function0<List<? extends String>> {
    final /* synthetic */ SupportedParameters this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SupportedParameters$flashModes$2(SupportedParameters supportedParameters) {
        super(0);
        this.this$0 = supportedParameters;
    }

    /* Return type fixed from 'java.util.List<java.lang.String>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends String> invoke() {
        List<String> supportedFlashModes = this.this$0.cameraParameters.getSupportedFlashModes();
        return supportedFlashModes != null ? supportedFlashModes : CollectionsKt.listOf(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }
}
