package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzegx extends zzegv {
    private static final Class<?> zzigf = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzegx() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzegv
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzegv
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzejf.zzp(obj, j);
        if (list instanceof zzegw) {
            obj2 = ((zzegw) list).zzbgh();
        } else if (!zzigf.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzehx) || !(list instanceof zzegm)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzegm zzegm = (zzegm) list;
                if (zzegm.zzbcy()) {
                    zzegm.zzbcz();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzejf.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.ads.zzegt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.ads.zzegt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.ads.zzegt} */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzegt zzegt;
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzegw) {
                list = new zzegt(i);
            } else if (!(zzc instanceof zzehx) || !(zzc instanceof zzegm)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzegm) zzc).zzfs(i);
            }
            zzejf.zza(obj, j, list);
            return list;
        }
        if (zzigf.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzejf.zza(obj, j, arrayList);
            zzegt = arrayList;
        } else if (zzc instanceof zzeje) {
            zzegt zzegt2 = new zzegt(zzc.size() + i);
            zzegt2.addAll((zzeje) zzc);
            zzejf.zza(obj, j, zzegt2);
            zzegt = zzegt2;
        } else if (!(zzc instanceof zzehx) || !(zzc instanceof zzegm)) {
            return zzc;
        } else {
            zzegm zzegm = (zzegm) zzc;
            if (zzegm.zzbcy()) {
                return zzc;
            }
            zzegm zzfs = zzegm.zzfs(zzc.size() + i);
            zzejf.zza(obj, j, zzfs);
            return zzfs;
        }
        return zzegt;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzegv
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza = zza(obj, j, zzc.size());
        int size = zza.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza;
        }
        zzejf.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzejf.zzp(obj, j);
    }
}
