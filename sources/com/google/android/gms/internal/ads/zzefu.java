package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzefu<T extends zzefw<T>> {
    private static final zzefu zzibo = new zzefu(true);
    final zzeim<T, Object> zzibl;
    private boolean zzibm;
    private boolean zzibn;

    private zzefu() {
        this.zzibl = zzeim.zzhn(16);
    }

    private zzefu(boolean z) {
        this(zzeim.zzhn(0));
        zzbcz();
    }

    private zzefu(zzeim<T, Object> zzeim) {
        this.zzibl = zzeim;
        zzbcz();
    }

    public static <T extends zzefw<T>> zzefu<T> zzbev() {
        return zzibo;
    }

    public final void zzbcz() {
        if (!this.zzibm) {
            this.zzibl.zzbcz();
            this.zzibm = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzibm;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzefu)) {
            return false;
        }
        return this.zzibl.equals(((zzefu) obj).zzibl);
    }

    public final int hashCode() {
        return this.zzibl.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zzibn) {
            return new zzegr(this.zzibl.entrySet().iterator());
        }
        return this.zzibl.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zzibn) {
            return new zzegr(this.zzibl.zzbhl().iterator());
        }
        return this.zzibl.zzbhl().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zzibl.get(t);
        if (!(obj instanceof zzegq)) {
            return obj;
        }
        zzegq zzegq = (zzegq) obj;
        return zzegq.zzbge();
    }

    private final void zza(T t, Object obj) {
        if (!t.zzbez()) {
            zza(t.zzbex(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzbex(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzegq) {
            this.zzibn = true;
        }
        this.zzibl.put(t, obj);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzegg) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzegq) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.ads.zzejq r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzegd.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzeft.zzibk
            com.google.android.gms.internal.ads.zzejt r2 = r2.zzbib()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzehl
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzegq
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzegg
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzeer
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefu.zza(com.google.android.gms.internal.ads.zzejq, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzibl.zzbhj(); i++) {
            if (!zzb(this.zzibl.zzho(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zzibl.zzbhk()) {
            if (!zzb(entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzefw<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzbey() == zzejt.MESSAGE) {
            if (key.zzbez()) {
                for (zzehl zzehl : (List) entry.getValue()) {
                    if (!zzehl.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzehl) {
                    if (!((zzehl) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzegq) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzefu<T> zzefu) {
        for (int i = 0; i < zzefu.zzibl.zzbhj(); i++) {
            zzc(zzefu.zzibl.zzho(i));
        }
        for (Map.Entry<T, Object> entry : zzefu.zzibl.zzbhk()) {
            zzc(entry);
        }
    }

    private static Object zzak(Object obj) {
        if (obj instanceof zzehu) {
            return ((zzehu) obj).zzbcv();
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
        zzehl zzehl;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzegq) {
            zzegq zzegq = (zzegq) value;
            value = zzegq.zzbge();
        }
        if (key.zzbez()) {
            Object zza = zza((zzefw) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzak(obj));
            }
            this.zzibl.put(key, zza);
        } else if (key.zzbey() == zzejt.MESSAGE) {
            Object zza2 = zza((zzefw) key);
            if (zza2 == null) {
                this.zzibl.put(key, zzak(value));
                return;
            }
            if (zza2 instanceof zzehu) {
                zzehl = key.zza((zzehu) zza2, (zzehu) value);
            } else {
                zzehl = key.zza(((zzehl) zza2).zzbfi(), (zzehl) value).zzbfq();
            }
            this.zzibl.put(key, zzehl);
        } else {
            this.zzibl.put(key, zzak(value));
        }
    }

    static void zza(zzefl zzefl, zzejq zzejq, int i, Object obj) throws IOException {
        if (zzejq == zzejq.GROUP) {
            zzehl zzehl = (zzehl) obj;
            zzegd.zzk(zzehl);
            zzefl.writeTag(i, 3);
            zzehl.zzb(zzefl);
            zzefl.writeTag(i, 4);
            return;
        }
        zzefl.writeTag(i, zzejq.zzbic());
        switch (zzeft.zziau[zzejq.ordinal()]) {
            case 1:
                zzefl.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzefl.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzefl.zzfi(((Long) obj).longValue());
                return;
            case 4:
                zzefl.zzfi(((Long) obj).longValue());
                return;
            case 5:
                zzefl.zzgl(((Integer) obj).intValue());
                return;
            case 6:
                zzefl.zzfk(((Long) obj).longValue());
                return;
            case 7:
                zzefl.zzgo(((Integer) obj).intValue());
                return;
            case 8:
                zzefl.zzbs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzehl) obj).zzb(zzefl);
                return;
            case 10:
                zzefl.zzg((zzehl) obj);
                return;
            case 11:
                if (obj instanceof zzeer) {
                    zzefl.zzah((zzeer) obj);
                    return;
                } else {
                    zzefl.zzht((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzeer) {
                    zzefl.zzah((zzeer) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzefl.zzk(bArr, 0, bArr.length);
                return;
            case 13:
                zzefl.zzgm(((Integer) obj).intValue());
                return;
            case 14:
                zzefl.zzgo(((Integer) obj).intValue());
                return;
            case 15:
                zzefl.zzfk(((Long) obj).longValue());
                return;
            case 16:
                zzefl.zzgn(((Integer) obj).intValue());
                return;
            case 17:
                zzefl.zzfj(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzegg) {
                    zzefl.zzgl(((zzegg) obj).zzw());
                    return;
                } else {
                    zzefl.zzgl(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzbew() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzibl.zzbhj(); i2++) {
            i += zzd(this.zzibl.zzho(i2));
        }
        for (Map.Entry<T, Object> entry : this.zzibl.zzbhk()) {
            i += zzd(entry);
        }
        return i;
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzbey() != zzejt.MESSAGE || key.zzbez() || key.zzbfa()) {
            return zzb((zzefw<?>) key, value);
        }
        if (value instanceof zzegq) {
            return zzefl.zzb(entry.getKey().zzw(), (zzegq) value);
        }
        return zzefl.zzb(entry.getKey().zzw(), (zzehl) value);
    }

    static int zza(zzejq zzejq, int i, Object obj) {
        int zzgp = zzefl.zzgp(i);
        if (zzejq == zzejq.GROUP) {
            zzegd.zzk((zzehl) obj);
            zzgp <<= 1;
        }
        return zzgp + zzb(zzejq, obj);
    }

    private static int zzb(zzejq zzejq, Object obj) {
        switch (zzeft.zziau[zzejq.ordinal()]) {
            case 1:
                return zzefl.zzc(((Double) obj).doubleValue());
            case 2:
                return zzefl.zzg(((Float) obj).floatValue());
            case 3:
                return zzefl.zzfl(((Long) obj).longValue());
            case 4:
                return zzefl.zzfm(((Long) obj).longValue());
            case 5:
                return zzefl.zzgq(((Integer) obj).intValue());
            case 6:
                return zzefl.zzfo(((Long) obj).longValue());
            case 7:
                return zzefl.zzgt(((Integer) obj).intValue());
            case 8:
                return zzefl.zzbt(((Boolean) obj).booleanValue());
            case 9:
                return zzefl.zzi((zzehl) obj);
            case 10:
                if (obj instanceof zzegq) {
                    return zzefl.zza((zzegq) obj);
                }
                return zzefl.zzh((zzehl) obj);
            case 11:
                if (obj instanceof zzeer) {
                    return zzefl.zzai((zzeer) obj);
                }
                return zzefl.zzhu((String) obj);
            case 12:
                if (obj instanceof zzeer) {
                    return zzefl.zzai((zzeer) obj);
                }
                return zzefl.zzx((byte[]) obj);
            case 13:
                return zzefl.zzgr(((Integer) obj).intValue());
            case 14:
                return zzefl.zzgu(((Integer) obj).intValue());
            case 15:
                return zzefl.zzfp(((Long) obj).longValue());
            case 16:
                return zzefl.zzgs(((Integer) obj).intValue());
            case 17:
                return zzefl.zzfn(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzegg) {
                    return zzefl.zzgv(((zzegg) obj).zzw());
                }
                return zzefl.zzgv(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzefw<?> zzefw, Object obj) {
        zzejq zzbex = zzefw.zzbex();
        int zzw = zzefw.zzw();
        if (!zzefw.zzbez()) {
            return zza(zzbex, zzw, obj);
        }
        int i = 0;
        if (zzefw.zzbfa()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzbex, obj2);
            }
            return zzefl.zzgp(zzw) + i + zzefl.zzgx(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzbex, zzw, obj3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzefu zzefu = new zzefu();
        for (int i = 0; i < this.zzibl.zzbhj(); i++) {
            Map.Entry<T, Object> zzho = this.zzibl.zzho(i);
            zzefu.zza((zzefw) zzho.getKey(), zzho.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zzibl.zzbhk()) {
            zzefu.zza((zzefw) entry.getKey(), entry.getValue());
        }
        zzefu.zzibn = this.zzibn;
        return zzefu;
    }
}
