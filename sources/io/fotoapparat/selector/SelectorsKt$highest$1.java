package io.fotoapparat.selector;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "", "p1", "", "invoke", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;"}, k = 3, mv = {1, 1, 13})
/* compiled from: Selectors.kt */
final class SelectorsKt$highest$1 extends FunctionReference implements Function1<Iterable<? extends T>, T> {
    public static final SelectorsKt$highest$1 INSTANCE = new SelectorsKt$highest$1();

    SelectorsKt$highest$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "max";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(CollectionsKt.class, "fotoapparat_release");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "max(Ljava/lang/Iterable;)Ljava/lang/Comparable;";
    }

    public final T invoke(Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "p1");
        return CollectionsKt.max(iterable);
    }
}
