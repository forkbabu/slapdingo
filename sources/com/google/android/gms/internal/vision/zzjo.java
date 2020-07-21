package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
abstract class zzjo<T, B> {
    zzjo() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzfm zzfm);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzkl zzkl) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzix zzix);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzkl zzkl) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract T zzh(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void zzh(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzig();

    /* access modifiers changed from: package-private */
    public abstract T zzo(B b);

    /* access modifiers changed from: package-private */
    public abstract int zzs(T t);

    /* access modifiers changed from: package-private */
    public abstract T zzw(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzx(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzy(T t);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(B r7, com.google.android.gms.internal.vision.zzix r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.getTag()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0061
            if (r0 == r2) goto L_0x0059
            r3 = 2
            if (r0 == r3) goto L_0x0051
            r3 = 4
            r4 = 3
            if (r0 == r4) goto L_0x0028
            if (r0 == r3) goto L_0x0026
            r3 = 5
            if (r0 != r3) goto L_0x0021
            int r8 = r8.zzeb()
            r6.zzc(r7, r1, r8)
            return r2
        L_0x0021:
            com.google.android.gms.internal.vision.zzhg r7 = com.google.android.gms.internal.vision.zzhh.zzgs()
            throw r7
        L_0x0026:
            r7 = 0
            return r7
        L_0x0028:
            java.lang.Object r0 = r6.zzig()
            int r4 = r1 << 3
            r3 = r3 | r4
        L_0x002f:
            int r4 = r8.zzdv()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x003e
            boolean r4 = r6.zza(r0, r8)
            if (r4 != 0) goto L_0x002f
        L_0x003e:
            int r8 = r8.getTag()
            if (r3 != r8) goto L_0x004c
            java.lang.Object r8 = r6.zzo(r0)
            r6.zza(r7, r1, r8)
            return r2
        L_0x004c:
            com.google.android.gms.internal.vision.zzhh r7 = com.google.android.gms.internal.vision.zzhh.zzgr()
            throw r7
        L_0x0051:
            com.google.android.gms.internal.vision.zzfm r8 = r8.zzee()
            r6.zza(r7, r1, r8)
            return r2
        L_0x0059:
            long r3 = r8.zzea()
            r6.zzb(r7, r1, r3)
            return r2
        L_0x0061:
            long r3 = r8.zzdy()
            r6.zza(r7, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjo.zza(java.lang.Object, com.google.android.gms.internal.vision.zzix):boolean");
    }
}
