package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
abstract class zzku<T, B> {
    zzku() {
    }

    /* access modifiers changed from: package-private */
    public abstract B zza();

    /* access modifiers changed from: package-private */
    public abstract T zza(B b);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzgt zzgt);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzln zzln) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzjz zzjz);

    /* access modifiers changed from: package-private */
    public abstract T zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(T t, zzln zzln) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T zzc(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void zzd(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zze(T t);

    /* access modifiers changed from: package-private */
    public abstract int zzf(T t);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(B r7, com.google.android.gms.internal.measurement.zzjz r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.zzb()
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
            int r8 = r8.zzj()
            r6.zza(r7, r1, r8)
            return r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zzim r7 = com.google.android.gms.internal.measurement.zzij.zzf()
            throw r7
        L_0x0026:
            r7 = 0
            return r7
        L_0x0028:
            java.lang.Object r0 = r6.zza()
            int r4 = r1 << 3
            r3 = r3 | r4
        L_0x002f:
            int r4 = r8.zza()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x003e
            boolean r4 = r6.zza(r0, r8)
            if (r4 != 0) goto L_0x002f
        L_0x003e:
            int r8 = r8.zzb()
            if (r3 != r8) goto L_0x004c
            java.lang.Object r8 = r6.zza(r0)
            r6.zza(r7, r1, r8)
            return r2
        L_0x004c:
            com.google.android.gms.internal.measurement.zzij r7 = com.google.android.gms.internal.measurement.zzij.zze()
            throw r7
        L_0x0051:
            com.google.android.gms.internal.measurement.zzgt r8 = r8.zzn()
            r6.zza(r7, r1, r8)
            return r2
        L_0x0059:
            long r3 = r8.zzi()
            r6.zzb(r7, r1, r3)
            return r2
        L_0x0061:
            long r3 = r8.zzg()
            r6.zza(r7, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjz):boolean");
    }
}
