package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzia {
    public static final zzia zzahy = new zzhz();

    public abstract zzib zza(int i, zzib zzib, boolean z, long j);

    public abstract zzic zza(int i, zzic zzic, boolean z);

    public abstract int zzc(Object obj);

    public abstract int zzfe();

    public abstract int zzff();

    public final boolean isEmpty() {
        return zzfe() == 0;
    }

    public final zzib zza(int i, zzib zzib, boolean z) {
        return zza(i, zzib, false, 0L);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if ((zzfe() - 1) == 0) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(int r3, com.google.android.gms.internal.ads.zzic r4, com.google.android.gms.internal.ads.zzib r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            r2.zza(r3, r4, r0)
            r2.zza(r0, r5, r0)
            r4 = 1
            if (r3 != 0) goto L_0x0031
            r3 = -1
            if (r6 == 0) goto L_0x0022
            if (r6 == r4) goto L_0x0020
            r1 = 2
            if (r6 != r1) goto L_0x001a
            int r6 = r2.zzfe()
            int r6 = r6 - r4
            if (r6 != 0) goto L_0x002a
            goto L_0x0020
        L_0x001a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L_0x0020:
            r4 = 0
            goto L_0x002a
        L_0x0022:
            int r6 = r2.zzfe()
            int r6 = r6 - r4
            if (r6 != 0) goto L_0x002a
            r4 = -1
        L_0x002a:
            if (r4 != r3) goto L_0x002d
            return r3
        L_0x002d:
            r2.zza(r4, r5, r0)
            return r0
        L_0x0031:
            int r3 = r3 + r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzia.zza(int, com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzib, int):int");
    }
}
