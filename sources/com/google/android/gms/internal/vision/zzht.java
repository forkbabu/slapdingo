package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzht extends zzhr {
    private static final Class<?> zzyv = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzht() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzhr
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzhr
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzju.zzp(obj, j);
        if (list instanceof zzho) {
            obj2 = ((zzho) list).zzgz();
        } else if (!zzyv.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzit) || !(list instanceof zzhe)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzhe zzhe = (zzhe) list;
                if (zzhe.zzdp()) {
                    zzhe.zzdq();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzju.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.vision.zzhp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.vision.zzhp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.vision.zzhp} */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzhp zzhp;
        List<L> list;
        List<L> zzd = zzd(obj, j);
        if (zzd.isEmpty()) {
            if (zzd instanceof zzho) {
                list = new zzhp(i);
            } else if (!(zzd instanceof zzit) || !(zzd instanceof zzhe)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzhe) zzd).zzah(i);
            }
            zzju.zza(obj, j, list);
            return list;
        }
        if (zzyv.isAssignableFrom(zzd.getClass())) {
            ArrayList arrayList = new ArrayList(zzd.size() + i);
            arrayList.addAll(zzd);
            zzju.zza(obj, j, arrayList);
            zzhp = arrayList;
        } else if (zzd instanceof zzjt) {
            zzhp zzhp2 = new zzhp(zzd.size() + i);
            zzhp2.addAll((zzjt) zzd);
            zzju.zza(obj, j, zzhp2);
            zzhp = zzhp2;
        } else if (!(zzd instanceof zzit) || !(zzd instanceof zzhe)) {
            return zzd;
        } else {
            zzhe zzhe = (zzhe) zzd;
            if (zzhe.zzdp()) {
                return zzd;
            }
            zzhe zzah = zzhe.zzah(zzd.size() + i);
            zzju.zza(obj, j, zzah);
            return zzah;
        }
        return zzhp;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzhr
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzju.zza(obj, j, zzd);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzju.zzp(obj, j);
    }
}
