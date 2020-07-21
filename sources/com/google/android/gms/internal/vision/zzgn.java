package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzgn<T extends zzgp<T>> {
    private static final zzgn zztt = new zzgn(true);
    final zzjb<T, Object> zztq;
    private boolean zztr;
    private boolean zzts;

    private zzgn() {
        this.zztq = zzjb.zzbu(16);
    }

    private zzgn(boolean z) {
        this(zzjb.zzbu(0));
        zzdq();
    }

    private zzgn(zzjb<T, Object> zzjb) {
        this.zztq = zzjb;
        zzdq();
    }

    public static <T extends zzgp<T>> zzgn<T> zzfo() {
        return zztt;
    }

    public final void zzdq() {
        if (!this.zztr) {
            this.zztq.zzdq();
            this.zztr = true;
        }
    }

    public final boolean isImmutable() {
        return this.zztr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgn)) {
            return false;
        }
        return this.zztq.equals(((zzgn) obj).zztq);
    }

    public final int hashCode() {
        return this.zztq.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zzts) {
            return new zzhn(this.zztq.entrySet().iterator());
        }
        return this.zztq.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zzts) {
            return new zzhn(this.zztq.zzia().iterator());
        }
        return this.zztq.zzia().iterator();
    }

    public final Object zza(T t) {
        Object obj = this.zztq.get(t);
        if (!(obj instanceof zzhi)) {
            return obj;
        }
        zzhi zzhi = (zzhi) obj;
        return zzhi.zzgv();
    }

    public final void zza(T t, Object obj) {
        if (!t.zzfv()) {
            zza(t.zzft(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzft(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzhi) {
            this.zzts = true;
        }
        this.zztq.put(t, obj);
    }

    public final void zzb(T t, Object obj) {
        List list;
        if (t.zzfv()) {
            zza(t.zzft(), obj);
            Object zza = zza((zzgp) t);
            if (zza == null) {
                list = new ArrayList();
                this.zztq.put(t, list);
            } else {
                list = (List) zza;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.vision.zzhb) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.vision.zzhi) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.vision.zzkf r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.vision.zzgy.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.vision.zzgq.zztw
            com.google.android.gms.internal.vision.zzki r2 = r2.zziq()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzih
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzhi
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzhb
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzfm
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
            switch-data {1->0x0040, 2->0x003d, 3->0x003a, 4->0x0037, 5->0x0034, 6->0x0031, 7->0x0028, 8->0x001f, 9->0x0016, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzgn.zza(com.google.android.gms.internal.vision.zzkf, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zztq.zzhy(); i++) {
            if (!zzb(this.zztq.zzbv(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zztq.zzhz()) {
            if (!zzb(entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzgp<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzfu() == zzki.MESSAGE) {
            if (key.zzfv()) {
                for (zzih zzih : (List) entry.getValue()) {
                    if (!zzih.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzih) {
                    if (!((zzih) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzhi) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzgn<T> zzgn) {
        for (int i = 0; i < zzgn.zztq.zzhy(); i++) {
            zzc(zzgn.zztq.zzbv(i));
        }
        for (Map.Entry<T, Object> entry : zzgn.zztq.zzhz()) {
            zzc(entry);
        }
    }

    private static Object zzi(Object obj) {
        if (obj instanceof zzim) {
            return ((zzim) obj).zzdn();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        zzih zzih;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzhi) {
            zzhi zzhi = (zzhi) value;
            value = zzhi.zzgv();
        }
        if (key.zzfv()) {
            Object zza = zza((zzgp) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzi(obj));
            }
            this.zztq.put(key, zza);
        } else if (key.zzfu() == zzki.MESSAGE) {
            Object zza2 = zza((zzgp) key);
            if (zza2 == null) {
                this.zztq.put(key, zzi(value));
                return;
            }
            if (zza2 instanceof zzim) {
                zzih = key.zza((zzim) zza2, (zzim) value);
            } else {
                zzih = key.zza(((zzih) zza2).zzgj(), (zzih) value).zzgd();
            }
            this.zztq.put(key, zzih);
        } else {
            this.zztq.put(key, zzi(value));
        }
    }

    static void zza(zzgf zzgf, zzkf zzkf, int i, Object obj) throws IOException {
        if (zzkf == zzkf.GROUP) {
            zzih zzih = (zzih) obj;
            zzgy.zzf(zzih);
            zzgf.writeTag(i, 3);
            zzih.zzb(zzgf);
            zzgf.writeTag(i, 4);
            return;
        }
        zzgf.writeTag(i, zzkf.zzir());
        switch (zzgq.zzsg[zzkf.ordinal()]) {
            case 1:
                zzgf.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzgf.zzs(((Float) obj).floatValue());
                return;
            case 3:
                zzgf.zzs(((Long) obj).longValue());
                return;
            case 4:
                zzgf.zzs(((Long) obj).longValue());
                return;
            case 5:
                zzgf.zzax(((Integer) obj).intValue());
                return;
            case 6:
                zzgf.zzu(((Long) obj).longValue());
                return;
            case 7:
                zzgf.zzba(((Integer) obj).intValue());
                return;
            case 8:
                zzgf.zzk(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzih) obj).zzb(zzgf);
                return;
            case 10:
                zzgf.zzb((zzih) obj);
                return;
            case 11:
                if (obj instanceof zzfm) {
                    zzgf.zza((zzfm) obj);
                    return;
                } else {
                    zzgf.zzx((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzfm) {
                    zzgf.zza((zzfm) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzgf.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzgf.zzay(((Integer) obj).intValue());
                return;
            case 14:
                zzgf.zzba(((Integer) obj).intValue());
                return;
            case 15:
                zzgf.zzu(((Long) obj).longValue());
                return;
            case 16:
                zzgf.zzaz(((Integer) obj).intValue());
                return;
            case 17:
                zzgf.zzt(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzhb) {
                    zzgf.zzax(((zzhb) obj).zzah());
                    return;
                } else {
                    zzgf.zzax(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzfp() {
        int i = 0;
        for (int i2 = 0; i2 < this.zztq.zzhy(); i2++) {
            i += zzd(this.zztq.zzbv(i2));
        }
        for (Map.Entry<T, Object> entry : this.zztq.zzhz()) {
            i += zzd(entry);
        }
        return i;
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzfu() != zzki.MESSAGE || key.zzfv() || key.zzfw()) {
            return zzc(key, value);
        }
        if (value instanceof zzhi) {
            return zzgf.zzb(entry.getKey().zzah(), (zzhi) value);
        }
        return zzgf.zzb(entry.getKey().zzah(), (zzih) value);
    }

    static int zza(zzkf zzkf, int i, Object obj) {
        int zzbb = zzgf.zzbb(i);
        if (zzkf == zzkf.GROUP) {
            zzgy.zzf((zzih) obj);
            zzbb <<= 1;
        }
        return zzbb + zzb(zzkf, obj);
    }

    private static int zzb(zzkf zzkf, Object obj) {
        switch (zzgq.zzsg[zzkf.ordinal()]) {
            case 1:
                return zzgf.zzb(((Double) obj).doubleValue());
            case 2:
                return zzgf.zzt(((Float) obj).floatValue());
            case 3:
                return zzgf.zzv(((Long) obj).longValue());
            case 4:
                return zzgf.zzw(((Long) obj).longValue());
            case 5:
                return zzgf.zzbc(((Integer) obj).intValue());
            case 6:
                return zzgf.zzy(((Long) obj).longValue());
            case 7:
                return zzgf.zzbf(((Integer) obj).intValue());
            case 8:
                return zzgf.zzl(((Boolean) obj).booleanValue());
            case 9:
                return zzgf.zzd((zzih) obj);
            case 10:
                if (obj instanceof zzhi) {
                    return zzgf.zza((zzhi) obj);
                }
                return zzgf.zzc((zzih) obj);
            case 11:
                if (obj instanceof zzfm) {
                    return zzgf.zzb((zzfm) obj);
                }
                return zzgf.zzy((String) obj);
            case 12:
                if (obj instanceof zzfm) {
                    return zzgf.zzb((zzfm) obj);
                }
                return zzgf.zzf((byte[]) obj);
            case 13:
                return zzgf.zzbd(((Integer) obj).intValue());
            case 14:
                return zzgf.zzbg(((Integer) obj).intValue());
            case 15:
                return zzgf.zzz(((Long) obj).longValue());
            case 16:
                return zzgf.zzbe(((Integer) obj).intValue());
            case 17:
                return zzgf.zzx(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzhb) {
                    return zzgf.zzbh(((zzhb) obj).zzah());
                }
                return zzgf.zzbh(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzc(zzgp<?> zzgp, Object obj) {
        zzkf zzft = zzgp.zzft();
        int zzah = zzgp.zzah();
        if (!zzgp.zzfv()) {
            return zza(zzft, zzah, obj);
        }
        int i = 0;
        if (zzgp.zzfw()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzft, obj2);
            }
            return zzgf.zzbb(zzah) + i + zzgf.zzbj(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzft, zzah, obj3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgn zzgn = new zzgn();
        for (int i = 0; i < this.zztq.zzhy(); i++) {
            Map.Entry<T, Object> zzbv = this.zztq.zzbv(i);
            zzgn.zza((zzgp) zzbv.getKey(), zzbv.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zztq.zzhz()) {
            zzgn.zza((zzgp) entry.getKey(), entry.getValue());
        }
        zzgn.zzts = this.zzts;
        return zzgn;
    }
}
