package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzhm {
    public final int index;
    private final zzhv[] zzaeh;
    private final zzoe zzaei;
    private final zzhy[] zzafe;
    private final zzhu zzaff;
    private final zznb zzafl;
    public int zzafz;
    public long zzaga;
    public final zzmz zzagd;
    public final Object zzage;
    public final zznk[] zzagf;
    private final boolean[] zzagg;
    public final long zzagh;
    public boolean zzagi;
    public boolean zzagj;
    public boolean zzagk;
    public zzhm zzagl;
    public zzog zzagm;
    private zzog zzagn;

    public zzhm(zzhv[] zzhvArr, zzhy[] zzhyArr, long j, zzoe zzoe, zzhu zzhu, zznb zznb, Object obj, int i, int i2, boolean z, long j2) {
        this.zzaeh = zzhvArr;
        this.zzafe = zzhyArr;
        this.zzagh = j;
        this.zzaei = zzoe;
        this.zzaff = zzhu;
        this.zzafl = zznb;
        this.zzage = zzpb.checkNotNull(obj);
        this.index = i;
        this.zzafz = i2;
        this.zzagi = z;
        this.zzaga = j2;
        this.zzagf = new zznk[zzhvArr.length];
        this.zzagg = new boolean[zzhvArr.length];
        this.zzagd = zznb.zza(i2, zzhu.zzfc());
    }

    public final long zzev() {
        return this.zzagh - this.zzaga;
    }

    public final void zzc(int i, boolean z) {
        this.zzafz = i;
        this.zzagi = z;
    }

    public final boolean zzew() {
        if (this.zzagj) {
            return !this.zzagk || this.zzagd.zzhq() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzex() throws com.google.android.gms.internal.ads.zzhb {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzoe r0 = r6.zzaei
            com.google.android.gms.internal.ads.zzhy[] r1 = r6.zzafe
            com.google.android.gms.internal.ads.zzmz r2 = r6.zzagd
            com.google.android.gms.internal.ads.zznr r2 = r2.zzho()
            com.google.android.gms.internal.ads.zzog r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzog r1 = r6.zzagn
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0028
        L_0x0016:
            r4 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzof r5 = r0.zzbhq
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0027
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L_0x0024
            goto L_0x0014
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            return r3
        L_0x002b:
            r6.zzagm = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.zzex():boolean");
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzaeh.length]);
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzof zzof = this.zzagm.zzbhq;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzof.length) {
                break;
            }
            boolean[] zArr2 = this.zzagg;
            if (z || !this.zzagm.zza(this.zzagn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzagd.zza(zzof.zzil(), this.zzagg, this.zzagf, zArr, j);
        this.zzagn = this.zzagm;
        this.zzagk = false;
        int i2 = 0;
        while (true) {
            zznk[] zznkArr = this.zzagf;
            if (i2 < zznkArr.length) {
                if (zznkArr[i2] != null) {
                    zzpb.checkState(zzof.zzbf(i2) != null);
                    this.zzagk = true;
                } else {
                    zzpb.checkState(zzof.zzbf(i2) == null);
                }
                i2++;
            } else {
                this.zzaff.zza(this.zzaeh, this.zzagm.zzbhp, zzof);
                return zza;
            }
        }
    }

    public final void release() {
        try {
            this.zzafl.zzb(this.zzagd);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
