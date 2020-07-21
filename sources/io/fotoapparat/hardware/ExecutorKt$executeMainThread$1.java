package io.fotoapparat.hardware;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
/* compiled from: Executor.kt */
final class ExecutorKt$executeMainThread$1 implements Runnable {
    final /* synthetic */ Function0 $function;

    ExecutorKt$executeMainThread$1(Function0 function0) {
        this.$function = function0;
    }

    public final void run() {
        this.$function.invoke();
    }
}
