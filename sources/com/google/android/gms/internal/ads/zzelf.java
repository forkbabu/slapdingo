package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzelf<T> implements zzela<Set<T>> {
    private static final zzela<Set<Object>> zzipx = zzekz.zzba(Collections.emptySet());
    private final List<zzelj<T>> zzipy;
    private final List<zzelj<Collection<T>>> zzipz;

    public static <T> zzelh<T> zzar(int i, int i2) {
        return new zzelh<>(i, i2);
    }

    private zzelf(List<zzelj<T>> list, List<zzelj<Collection<T>>> list2) {
        this.zzipy = list;
        this.zzipz = list2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        int size = this.zzipy.size();
        ArrayList arrayList = new ArrayList(this.zzipz.size());
        int size2 = this.zzipz.size();
        for (int i = 0; i < size2; i++) {
            Collection<T> collection = this.zzipz.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zzhy = zzekv.zzhy(size);
        int size3 = this.zzipy.size();
        for (int i2 = 0; i2 < size3; i2++) {
            zzhy.add(zzelg.checkNotNull(this.zzipy.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object obj : (Collection) arrayList.get(i3)) {
                zzhy.add(zzelg.checkNotNull(obj));
            }
        }
        return Collections.unmodifiableSet(zzhy);
    }
}
