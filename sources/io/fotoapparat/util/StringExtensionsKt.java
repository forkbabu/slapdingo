package io.fotoapparat.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0006H\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00060\u0007H\u0000\"\u001c\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"lineSeparator", "", "kotlin.jvm.PlatformType", "getLineSeparator", "()Ljava/lang/String;", "wrap", "", "", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: StringExtensions.kt */
public final class StringExtensionsKt {
    private static final String lineSeparator = System.getProperty("line.separator");

    public static final String getLineSeparator() {
        return lineSeparator;
    }

    public static final String wrap(Set<? extends Object> set) {
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        StringBuilder sb = new StringBuilder();
        Iterable iterable = set;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object obj : iterable) {
            arrayList.add(lineSeparator + "\t\t" + obj);
        }
        sb.append((List) arrayList);
        sb.append(lineSeparator);
        return sb.toString();
    }

    public static final String wrap(Object obj) {
        if (obj == null) {
            obj = "null";
        }
        return "\t\t" + obj + lineSeparator;
    }
}
