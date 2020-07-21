package io.fotoapparat.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¨\u0006\u0004"}, d2 = {"toInts", "", "", "", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: ListConvertions.kt */
public final class ListConvertionsKt {
    public static final List<Integer> toInts(List<String> list) {
        Integer num;
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Collection arrayList = new ArrayList();
        for (String str : list) {
            if (str != null) {
                try {
                    num = Integer.valueOf(Integer.parseInt(StringsKt.trim((CharSequence) str).toString()));
                } catch (NumberFormatException unused) {
                    num = null;
                }
                if (num != null) {
                    arrayList.add(num);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        return (List) arrayList;
    }
}
