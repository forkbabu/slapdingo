package io.fotoapparat.selector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "", "", "invoke", "(Ljava/lang/Iterable;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
/* compiled from: Selectors.kt */
final class SelectorsKt$filtered$1 extends Lambda implements Function1<Iterable<? extends T>, T> {
    final /* synthetic */ Function1 $predicate;
    final /* synthetic */ Function1 $selector;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectorsKt$filtered$1(Function1 function1, Function1 function12) {
        super(1);
        this.$selector = function1;
        this.$predicate = function12;
    }

    public final T invoke(Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Function1 function1 = this.$selector;
        Function1 function12 = this.$predicate;
        Collection arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((Boolean) function12.invoke(obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return function1.invoke((List) arrayList);
    }
}
