package io.fotoapparat.selector;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\t\u001a^\u0010\u0000\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001¢\u0006\u0002\b\u0004\"\b\b\u0000\u0010\u0003*\u00020\u00052\u001f\u0010\u0006\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001¢\u0006\u0002\b\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0001\u001af\u0010\t\u001a\u0015\u0012\u0004\u0012\u0002H\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u0001¢\u0006\u0002\b\u0004\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b28\u0010\f\u001a\u001d\u0012\u0019\b\u0001\u0012\u0015\u0012\u0004\u0012\u0002H\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u0001¢\u0006\u0002\b\u00040\r\"\u0015\u0012\u0004\u0012\u0002H\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u0001¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u000e\u001a/\u0010\u000f\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001¢\u0006\u0002\b\u0004\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0010\u001a/\u0010\u0011\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001¢\u0006\u0002\b\u0004\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0010\u001a%\u0010\u0012\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001¢\u0006\u0002\b\u0004\"\u0004\b\u0000\u0010\u0003\u001a2\u0010\u0013\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001¢\u0006\u0002\b\u0004\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0014\u001a\u0002H\u0003¢\u0006\u0002\u0010\u0015\u001a?\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00030\r2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00170\u0001H\u0002¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"filtered", "Lkotlin/Function1;", "", "T", "Lkotlin/ExtensionFunctionType;", "", "selector", "predicate", "", "firstAvailable", "Input", "Output", "functions", "", "([Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "highest", "", "lowest", "nothing", "single", "preference", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "findNonNull", "R", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: Selectors.kt */
public final class SelectorsKt {
    public static final <T> Function1<Iterable<? extends T>, T> nothing() {
        return SelectorsKt$nothing$1.INSTANCE;
    }

    public static final <T> Function1<Iterable<? extends T>, T> single(T t) {
        return new SelectorsKt$single$1(t);
    }

    public static final <T extends Comparable<? super T>> Function1<Iterable<? extends T>, T> highest() {
        return SelectorsKt$highest$1.INSTANCE;
    }

    public static final <T extends Comparable<? super T>> Function1<Iterable<? extends T>, T> lowest() {
        return SelectorsKt$lowest$1.INSTANCE;
    }

    @SafeVarargs
    public static final <Input, Output> Function1<Input, Output> firstAvailable(Function1<? super Input, ? extends Output>... function1Arr) {
        Intrinsics.checkParameterIsNotNull(function1Arr, "functions");
        return new SelectorsKt$firstAvailable$1(function1Arr);
    }

    public static final <T> Function1<Iterable<? extends T>, T> filtered(Function1<? super Iterable<? extends T>, ? extends T> function1, Function1<? super T, Boolean> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Intrinsics.checkParameterIsNotNull(function12, "predicate");
        return new SelectorsKt$filtered$1(function1, function12);
    }

    /* access modifiers changed from: private */
    public static final <T, R> R findNonNull(T[] tArr, Function1<? super T, ? extends R> function1) {
        for (T t : tArr) {
            R invoke = function1.invoke(t);
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }
}
