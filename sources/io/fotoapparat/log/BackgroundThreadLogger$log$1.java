package io.fotoapparat.log;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: BackgroundThreadLogger.kt */
final class BackgroundThreadLogger$log$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $message;
    final /* synthetic */ BackgroundThreadLogger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundThreadLogger$log$1(BackgroundThreadLogger backgroundThreadLogger, String str) {
        super(0);
        this.this$0 = backgroundThreadLogger;
        this.$message = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.logger.log(this.$message);
    }
}
