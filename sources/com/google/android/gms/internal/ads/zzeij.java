package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeij {
    private static final Class<?> zziig = zzbhh();
    private static final zzeiz<?, ?> zziih = zzbv(false);
    private static final zzeiz<?, ?> zziii = zzbv(true);
    private static final zzeiz<?, ?> zziij = new zzejb();

    public static void zzi(Class<?> cls) {
        Class<?> cls2;
        if (!zzegb.class.isAssignableFrom(cls) && (cls2 = zziig) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzejw zzejw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzejw zzejw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzeer> list, zzejw zzejw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzejw zzejw, zzeih zzeih) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zza(i, list, zzeih);
        }
    }

    public static void zzb(int i, List<?> list, zzejw zzejw, zzeih zzeih) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzejw.zzb(i, list, zzeih);
        }
    }

    static int zzaa(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzegz) {
            zzegz zzegz = (zzegz) list;
            i = 0;
            while (i2 < size) {
                i += zzefl.zzfl(zzegz.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzefl.zzfl(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzaa(list) + (list.size() * zzefl.zzgp(i));
    }

    static int zzab(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzegz) {
            zzegz zzegz = (zzegz) list;
            i = 0;
            while (i2 < size) {
                i += zzefl.zzfm(zzegz.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzefl.zzfm(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzab(list) + (size * zzefl.zzgp(i));
    }

    static int zzac(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzegz) {
            zzegz zzegz = (zzegz) list;
            i = 0;
            while (i2 < size) {
                i += zzefl.zzfn(zzegz.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzefl.zzfn(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzac(list) + (size * zzefl.zzgp(i));
    }

    static int zzad(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            i = 0;
            while (i2 < size) {
                i += zzefl.zzgv(zzege.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzefl.zzgv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zzefl.zzgp(i));
    }

    static int zzae(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            i = 0;
            while (i2 < size) {
                i += zzefl.zzgq(zzege.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzefl.zzgq(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zzefl.zzgp(i));
    }

    static int zzaf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            i = 0;
            while (i2 < size) {
                i += zzefl.zzgr(zzege.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzefl.zzgr(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaf(list) + (size * zzefl.zzgp(i));
    }

    static int zzag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzege) {
            zzege zzege = (zzege) list;
            i = 0;
            while (i2 < size) {
                i += zzefl.zzgs(zzege.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzefl.zzgs(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzag(list) + (size * zzefl.zzgp(i));
    }

    static int zzah(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzefl.zzai(i, 0);
    }

    static int zzai(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzefl.zzn(i, 0);
    }

    static int zzaj(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzefl.zzi(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzgp = zzefl.zzgp(i) * size;
        if (list instanceof zzegw) {
            zzegw zzegw = (zzegw) list;
            while (i4 < size) {
                Object zzhd = zzegw.zzhd(i4);
                if (zzhd instanceof zzeer) {
                    i3 = zzefl.zzai((zzeer) zzhd);
                } else {
                    i3 = zzefl.zzhu((String) zzhd);
                }
                zzgp += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzeer) {
                    i2 = zzefl.zzai((zzeer) obj);
                } else {
                    i2 = zzefl.zzhu((String) obj);
                }
                zzgp += i2;
                i4++;
            }
        }
        return zzgp;
    }

    static int zzc(int i, Object obj, zzeih zzeih) {
        if (obj instanceof zzegu) {
            return zzefl.zza(i, (zzegu) obj);
        }
        return zzefl.zzb(i, (zzehl) obj, zzeih);
    }

    static int zzc(int i, List<?> list, zzeih zzeih) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgp = zzefl.zzgp(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzegu) {
                i2 = zzefl.zza((zzegu) obj);
            } else {
                i2 = zzefl.zza((zzehl) obj, zzeih);
            }
            zzgp += i2;
        }
        return zzgp;
    }

    static int zzd(int i, List<zzeer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgp = size * zzefl.zzgp(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgp += zzefl.zzai(list.get(i2));
        }
        return zzgp;
    }

    static int zzd(int i, List<zzehl> list, zzeih zzeih) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzefl.zzc(i, list.get(i3), zzeih);
        }
        return i2;
    }

    public static zzeiz<?, ?> zzbhe() {
        return zziih;
    }

    public static zzeiz<?, ?> zzbhf() {
        return zziii;
    }

    public static zzeiz<?, ?> zzbhg() {
        return zziij;
    }

    private static zzeiz<?, ?> zzbv(boolean z) {
        try {
            Class<?> zzbhi = zzbhi();
            if (zzbhi == null) {
                return null;
            }
            return (zzeiz) zzbhi.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbhh() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbhi() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzehi zzehi, T t, T t2, long j) {
        zzejf.zza(t, j, zzehi.zzf(zzejf.zzp(t, j), zzejf.zzp(t2, j)));
    }

    static <T, FT extends zzefw<FT>> void zza(zzefq<FT> zzefq, T t, T t2) {
        zzefu<FT> zzah = zzefq.zzah(t2);
        if (!zzah.zzibl.isEmpty()) {
            zzefq.zzai(t).zza(zzah);
        }
    }

    static <T, UT, UB> void zza(zzeiz<UT, UB> zzeiz, T t, T t2) {
        zzeiz.zzi(t, zzeiz.zzk(zzeiz.zzax(t), zzeiz.zzax(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzegi zzegi, UB ub, zzeiz<UT, UB> zzeiz) {
        if (zzegi == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzegi.zzi(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzeiz);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (!zzegi.zzi(intValue2)) {
                    ub = zza(i, intValue2, ub, zzeiz);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzeiz<UT, UB> zzeiz) {
        if (ub == null) {
            ub = zzeiz.zzbhr();
        }
        zzeiz.zza(ub, i, (long) i2);
        return ub;
    }
}
