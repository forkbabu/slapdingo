package io.fotoapparat.selector;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "", "invoke", "(Ljava/lang/Iterable;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
/* compiled from: Selectors.kt */
final class SelectorsKt$single$1 extends Lambda implements Function1<Iterable<? extends T>, T> {
    final /* synthetic */ Object $preference;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectorsKt$single$1(Object obj) {
        super(1);
        this.$preference = obj;
    }

    public final T invoke(Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        for (T t : iterable) {
            if (Intrinsics.areEqual(t, this.$preference)) {
                return t;
            }
        }
        return null;
    }
}
