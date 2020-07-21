package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zziv extends zzit {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zziv() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzla.zzf(obj, j);
        if (list instanceof zziu) {
            obj2 = ((zziu) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzjv) || !(list instanceof zzik)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzik zzik = (zzik) list;
                if (zzik.zza()) {
                    zzik.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzla.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.measurement.zzir} */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzir zzir;
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zziu) {
                list = new zzir(i);
            } else if (!(zzc instanceof zzjv) || !(zzc instanceof zzik)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzik) zzc).zza(i);
            }
            zzla.zza(obj, j, list);
            return list;
        }
        if (zza.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzla.zza(obj, j, arrayList);
            zzir = arrayList;
        } else if (zzc instanceof zzkv) {
            zzir zzir2 = new zzir(zzc.size() + i);
            zzir2.addAll((zzkv) zzc);
            zzla.zza(obj, j, zzir2);
            zzir = zzir2;
        } else if (!(zzc instanceof zzjv) || !(zzc instanceof zzik)) {
            return zzc;
        } else {
            zzik zzik = (zzik) zzc;
            if (zzik.zza()) {
                return zzc;
            }
            zzik zza2 = zzik.zza(zzc.size() + i);
            zzla.zza(obj, j, zza2);
            return zza2;
        }
        return zzir;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzla.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzla.zzf(obj, j);
    }
}
