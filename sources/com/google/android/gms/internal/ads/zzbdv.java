package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbdv implements zzhu {
    private int zzbhz;
    private final zzoo zzejb;
    private long zzejc;
    private long zzejd;
    private long zzeje;
    private long zzejf;
    private boolean zzejg;

    zzbdv() {
        this(15000, 30000, 2500, 5000);
    }

    private zzbdv(int i, int i2, long j, long j2) {
        this.zzejb = new zzoo(true, 65536);
        this.zzejc = 15000000;
        this.zzejd = 30000000;
        this.zzeje = 2500000;
        this.zzejf = 5000000;
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final void zzfa() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final void zza(zzhv[] zzhvArr, zznr zznr, zzof zzof) {
        this.zzbhz = 0;
        for (int i = 0; i < zzhvArr.length; i++) {
            if (zzof.zzbf(i) != null) {
                this.zzbhz += zzpo.zzbr(zzhvArr[i].getTrackType());
            }
        }
        this.zzejb.zzbh(this.zzbhz);
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final void onStopped() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final void zzfb() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final zzoi zzfc() {
        return this.zzejb;
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final synchronized boolean zzc(long j, boolean z) {
        boolean z2;
        long j2 = z ? this.zzejf : this.zzeje;
        if (j2 <= 0 || j >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final synchronized boolean zzdt(long j) {
        boolean z;
        char c;
        z = false;
        if (j > this.zzejd) {
            c = 0;
        } else {
            c = j < this.zzejc ? (char) 2 : 1;
        }
        boolean z2 = this.zzejb.zzip() >= this.zzbhz;
        if (c == 2 || (c == 1 && this.zzejg && !z2)) {
            z = true;
        }
        this.zzejg = z;
        return z;
    }

    public final synchronized void zzdq(int i) {
        this.zzejc = ((long) i) * 1000;
    }

    public final synchronized void zzdr(int i) {
        this.zzejd = ((long) i) * 1000;
    }

    public final synchronized void zzdl(int i) {
        this.zzeje = ((long) i) * 1000;
    }

    public final synchronized void zzdm(int i) {
        this.zzejf = ((long) i) * 1000;
    }

    private final void zzk(boolean z) {
        this.zzbhz = 0;
        this.zzejg = false;
        if (z) {
            this.zzejb.reset();
        }
    }
}
