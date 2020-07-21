package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zziy {
    private static final Class<?> zzaag = zzhw();
    private static final zzjo<?, ?> zzaah = zzn(false);
    private static final zzjo<?, ?> zzaai = zzn(true);
    private static final zzjo<?, ?> zzaaj = new zzjq();

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzgx.class.isAssignableFrom(cls) && (cls2 = zzaag) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzkl zzkl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzkl zzkl) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzfm> list, zzkl zzkl) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzkl zzkl, zziw zziw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zza(i, list, zziw);
        }
    }

    public static void zzb(int i, List<?> list, zzkl zzkl, zziw zziw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkl.zzb(i, list, zziw);
        }
    }

    static int zzq(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzv(zzhv.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgf.zzv(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzq(list) + (list.size() * zzgf.zzbb(i));
    }

    static int zzr(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzw(zzhv.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgf.zzw(list.get(i2).longValue());
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
        return zzr(list) + (size * zzgf.zzbb(i));
    }

    static int zzs(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzx(zzhv.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgf.zzx(list.get(i2).longValue());
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
        return zzs(list) + (size * zzgf.zzbb(i));
    }

    static int zzt(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbh(zzgz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgf.zzbh(list.get(i2).intValue());
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
        return zzt(list) + (size * zzgf.zzbb(i));
    }

    static int zzu(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbc(zzgz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgf.zzbc(list.get(i2).intValue());
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
        return zzu(list) + (size * zzgf.zzbb(i));
    }

    static int zzv(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbd(zzgz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgf.zzbd(list.get(i2).intValue());
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
        return zzv(list) + (size * zzgf.zzbb(i));
    }

    static int zzw(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbe(zzgz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgf.zzbe(list.get(i2).intValue());
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
        return zzw(list) + (size * zzgf.zzbb(i));
    }

    static int zzx(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzo(i, 0);
    }

    static int zzy(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzg(i, 0);
    }

    static int zzz(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbb = zzgf.zzbb(i) * size;
        if (list instanceof zzho) {
            zzho zzho = (zzho) list;
            while (i4 < size) {
                Object raw = zzho.getRaw(i4);
                if (raw instanceof zzfm) {
                    i3 = zzgf.zzb((zzfm) raw);
                } else {
                    i3 = zzgf.zzy((String) raw);
                }
                zzbb += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzfm) {
                    i2 = zzgf.zzb((zzfm) obj);
                } else {
                    i2 = zzgf.zzy((String) obj);
                }
                zzbb += i2;
                i4++;
            }
        }
        return zzbb;
    }

    static int zzc(int i, Object obj, zziw zziw) {
        if (obj instanceof zzhm) {
            return zzgf.zza(i, (zzhm) obj);
        }
        return zzgf.zzb(i, (zzih) obj, zziw);
    }

    static int zzc(int i, List<?> list, zziw zziw) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = zzgf.zzbb(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzhm) {
                i2 = zzgf.zza((zzhm) obj);
            } else {
                i2 = zzgf.zza((zzih) obj, zziw);
            }
            zzbb += i2;
        }
        return zzbb;
    }

    static int zzd(int i, List<zzfm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = size * zzgf.zzbb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbb += zzgf.zzb(list.get(i2));
        }
        return zzbb;
    }

    static int zzd(int i, List<zzih> list, zziw zziw) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzgf.zzc(i, list.get(i3), zziw);
        }
        return i2;
    }

    public static zzjo<?, ?> zzht() {
        return zzaah;
    }

    public static zzjo<?, ?> zzhu() {
        return zzaai;
    }

    public static zzjo<?, ?> zzhv() {
        return zzaaj;
    }

    private static zzjo<?, ?> zzn(boolean z) {
        try {
            Class<?> zzhx = zzhx();
            if (zzhx == null) {
                return null;
            }
            return (zzjo) zzhx.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzhw() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzhx() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzia zzia, T t, T t2, long j) {
        zzju.zza(t, j, zzia.zzc(zzju.zzp(t, j), zzju.zzp(t2, j)));
    }

    static <T, FT extends zzgp<FT>> void zza(zzgk<FT> zzgk, T t, T t2) {
        zzgn<FT> zzf = zzgk.zzf(t2);
        if (!zzf.zztq.isEmpty()) {
            zzgk.zzg(t).zza(zzf);
        }
    }

    static <T, UT, UB> void zza(zzjo<UT, UB> zzjo, T t, T t2) {
        zzjo.zzf(t, zzjo.zzh(zzjo.zzw(t), zzjo.zzw(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzha<?> zzha, UB ub, zzjo<UT, UB> zzjo) {
        if (zzha == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzha.zzh(intValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzjo);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (zzha.zzh(intValue2) == null) {
                    ub = zza(i, intValue2, ub, zzjo);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzhd zzhd, UB ub, zzjo<UT, UB> zzjo) {
        if (zzhd == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzhd.zzg(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(i, intValue, ub, zzjo);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (!zzhd.zzg(intValue2)) {
                    ub = zza(i, intValue2, ub, zzjo);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzjo<UT, UB> zzjo) {
        if (ub == null) {
            ub = zzjo.zzig();
        }
        zzjo.zza(ub, i, (long) i2);
        return ub;
    }
}
