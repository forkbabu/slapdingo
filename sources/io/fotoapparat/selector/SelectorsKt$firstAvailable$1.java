package io.fotoapparat.selector;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u0002H\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Output", "Input", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
/* compiled from: Selectors.kt */
final class SelectorsKt$firstAvailable$1 extends Lambda implements Function1<Input, Output> {
    final /* synthetic */ Function1[] $functions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectorsKt$firstAvailable$1(Function1[] function1Arr) {
        super(1);
        this.$functions = function1Arr;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Output invoke(final Input input) {
        return SelectorsKt.findNonNull(this.$functions, new Function1<Function1<? super Input, ? extends Output>, Output>() {
            /* class io.fotoapparat.selector.SelectorsKt$firstAvailable$1.AnonymousClass1 */

            public final Output invoke(Function1<? super Input, ? extends Output> function1) {
                Intrinsics.checkParameterIsNotNull(function1, "it");
                return function1.invoke(input);
            }
        });
    }
}
