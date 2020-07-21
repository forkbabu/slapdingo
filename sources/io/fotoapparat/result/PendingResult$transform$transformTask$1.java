package io.fotoapparat.result;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "R", "T", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
/* compiled from: PendingResult.kt */
final class PendingResult$transform$transformTask$1<V> implements Callable<V> {
    final /* synthetic */ Function1 $transformer;
    final /* synthetic */ PendingResult this$0;

    PendingResult$transform$transformTask$1(PendingResult pendingResult, Function1 function1) {
        this.this$0 = pendingResult;
        this.$transformer = function1;
    }

    @Override // java.util.concurrent.Callable
    public final R call() {
        return this.$transformer.invoke(this.this$0.future.get());
    }
}
