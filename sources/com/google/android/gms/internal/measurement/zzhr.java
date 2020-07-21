package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzht;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzhr<T extends zzht<T>> {
    private static final zzhr zzd = new zzhr(true);
    final zzkd<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzhr() {
        this.zza = zzkd.zza(16);
    }

    private zzhr(boolean z) {
        this(zzkd.zza(0));
        zzb();
    }

    private zzhr(zzkd<T, Object> zzkd) {
        this.zza = zzkd;
        zzb();
    }

    public static <T extends zzht<T>> zzhr<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhr)) {
            return false;
        }
        return this.zza.equals(((zzhr) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzip(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzip(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzio)) {
            return obj;
        }
        zzio zzio = (zzio) obj;
        return zzio.zza();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzio) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzid) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzio) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzlh r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzie.zza(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzhu.zza
            com.google.android.gms.internal.measurement.zzlo r2 = r2.zza()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzjj
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzio
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzid
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgt
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhr.zza(com.google.android.gms.internal.measurement.zzlh, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            if (!zza((Map.Entry) entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzht<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzlo.MESSAGE) {
            if (key.zzd()) {
                for (zzjj zzjj : (List) entry.getValue()) {
                    if (!zzjj.g_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjj) {
                    if (!((zzjj) value).g_()) {
                        return false;
                    }
                } else if (value instanceof zzio) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzhr<T> zzhr) {
        for (int i = 0; i < zzhr.zza.zzc(); i++) {
            zzb(zzhr.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzhr.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzjs) {
            return ((zzjs) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzjj zzjj;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzio) {
            zzio zzio = (zzio) value;
            value = zzio.zza();
        }
        if (key.zzd()) {
            Object zza2 = zza((zzht) key);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza2).add(zza(obj));
            }
            this.zza.put(key, zza2);
        } else if (key.zzc() == zzlo.MESSAGE) {
            Object zza3 = zza((zzht) key);
            if (zza3 == null) {
                this.zza.put(key, zza(value));
                return;
            }
            if (zza3 instanceof zzjs) {
                zzjj = key.zza((zzjs) zza3, (zzjs) value);
            } else {
                zzjj = key.zza(((zzjj) zza3).zzbq(), (zzjj) value).zzv();
            }
            this.zza.put(key, zzjj);
        } else {
            this.zza.put(key, zza(value));
        }
    }

    static void zza(zzhi zzhi, zzlh zzlh, int i, Object obj) throws IOException {
        if (zzlh == zzlh.GROUP) {
            zzjj zzjj = (zzjj) obj;
            zzie.zza(zzjj);
            zzhi.zza(i, 3);
            zzjj.zza(zzhi);
            zzhi.zza(i, 4);
            return;
        }
        zzhi.zza(i, zzlh.zzb());
        switch (zzhu.zzb[zzlh.ordinal()]) {
            case 1:
                zzhi.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzhi.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzhi.zza(((Long) obj).longValue());
                return;
            case 4:
                zzhi.zza(((Long) obj).longValue());
                return;
            case 5:
                zzhi.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzhi.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzhi.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzhi.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzjj) obj).zza(zzhi);
                return;
            case 10:
                zzhi.zza((zzjj) obj);
                return;
            case 11:
                if (obj instanceof zzgt) {
                    zzhi.zza((zzgt) obj);
                    return;
                } else {
                    zzhi.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzgt) {
                    zzhi.zza((zzgt) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzhi.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzhi.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzhi.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzhi.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzhi.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzhi.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzid) {
                    zzhi.zza(((zzid) obj).zza());
                    return;
                } else {
                    zzhi.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            i += zzc(entry);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzlo.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzht<?>) key, value);
        }
        if (value instanceof zzio) {
            return zzhi.zzb(entry.getKey().zza(), (zzio) value);
        }
        return zzhi.zzb(entry.getKey().zza(), (zzjj) value);
    }

    static int zza(zzlh zzlh, int i, Object obj) {
        int zze = zzhi.zze(i);
        if (zzlh == zzlh.GROUP) {
            zzie.zza((zzjj) obj);
            zze <<= 1;
        }
        return zze + zzb(zzlh, obj);
    }

    private static int zzb(zzlh zzlh, Object obj) {
        switch (zzhu.zzb[zzlh.ordinal()]) {
            case 1:
                return zzhi.zzb(((Double) obj).doubleValue());
            case 2:
                return zzhi.zzb(((Float) obj).floatValue());
            case 3:
                return zzhi.zzd(((Long) obj).longValue());
            case 4:
                return zzhi.zze(((Long) obj).longValue());
            case 5:
                return zzhi.zzf(((Integer) obj).intValue());
            case 6:
                return zzhi.zzg(((Long) obj).longValue());
            case 7:
                return zzhi.zzi(((Integer) obj).intValue());
            case 8:
                return zzhi.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzhi.zzc((zzjj) obj);
            case 10:
                if (obj instanceof zzio) {
                    return zzhi.zza((zzio) obj);
                }
                return zzhi.zzb((zzjj) obj);
            case 11:
                if (obj instanceof zzgt) {
                    return zzhi.zzb((zzgt) obj);
                }
                return zzhi.zzb((String) obj);
            case 12:
                if (obj instanceof zzgt) {
                    return zzhi.zzb((zzgt) obj);
                }
                return zzhi.zzb((byte[]) obj);
            case 13:
                return zzhi.zzg(((Integer) obj).intValue());
            case 14:
                return zzhi.zzj(((Integer) obj).intValue());
            case 15:
                return zzhi.zzh(((Long) obj).longValue());
            case 16:
                return zzhi.zzh(((Integer) obj).intValue());
            case 17:
                return zzhi.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzid) {
                    return zzhi.zzk(((zzid) obj).zza());
                }
                return zzhi.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzht<?> zzht, Object obj) {
        zzlh zzb2 = zzht.zzb();
        int zza2 = zzht.zza();
        if (!zzht.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzht.zze()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzb2, obj2);
            }
            return zzhi.zze(zza2) + i + zzhi.zzl(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzb2, zza2, obj3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhr zzhr = new zzhr();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzhr.zzb((zzht) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzhr.zzb((zzht) entry.getKey(), entry.getValue());
        }
        zzhr.zzc = this.zzc;
        return zzhr;
    }
}
