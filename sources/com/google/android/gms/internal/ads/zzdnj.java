package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdnj {
    private final long zzheu;
    private final zzdnm zzhev = new zzdnm();
    private long zzhew;
    private int zzhex = 0;
    private int zzhey = 0;
    private int zzhez = 0;

    public zzdnj() {
        long currentTimeMillis = zzq.zzld().currentTimeMillis();
        this.zzheu = currentTimeMillis;
        this.zzhew = currentTimeMillis;
    }

    public final void zzatu() {
        this.zzhew = zzq.zzld().currentTimeMillis();
        this.zzhex++;
    }

    public final void zzatv() {
        this.zzhey++;
        this.zzhev.zzhfa = true;
    }

    public final void zzatw() {
        this.zzhez++;
        this.zzhev.zzhez++;
    }

    public final long getCreationTimeMillis() {
        return this.zzheu;
    }

    public final long zzata() {
        return this.zzhew;
    }

    public final int zzatb() {
        return this.zzhex;
    }

    public final zzdnm zzatx() {
        zzdnm zzdnm = (zzdnm) this.zzhev.clone();
        zzdnm zzdnm2 = this.zzhev;
        zzdnm2.zzhfa = false;
        zzdnm2.zzhez = 0;
        return zzdnm;
    }

    public final String zzatm() {
        return "Created: " + this.zzheu + " Last accessed: " + this.zzhew + " Accesses: " + this.zzhex + "\nEntries retrieved: Valid: " + this.zzhey + " Stale: " + this.zzhez;
    }
}
