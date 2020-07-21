package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpn implements zzpf {
    private boolean started;
    private zzhw zzaez = zzhw.zzahs;
    private long zzbkc;
    private long zzbkd;

    public final void start() {
        if (!this.started) {
            this.zzbkd = SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            zzel(zzgb());
            this.started = false;
        }
    }

    public final void zzel(long j) {
        this.zzbkc = j;
        if (this.started) {
            this.zzbkd = SystemClock.elapsedRealtime();
        }
    }

    public final void zza(zzpf zzpf) {
        zzel(zzpf.zzgb());
        this.zzaez = zzpf.zzfr();
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final long zzgb() {
        long j;
        long j2 = this.zzbkc;
        if (!this.started) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbkd;
        if (this.zzaez.zzaht == 1.0f) {
            j = zzhc.zzdp(elapsedRealtime);
        } else {
            j = this.zzaez.zzdu(elapsedRealtime);
        }
        return j2 + j;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final zzhw zzb(zzhw zzhw) {
        if (this.started) {
            zzel(zzgb());
        }
        this.zzaez = zzhw;
        return zzhw;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final zzhw zzfr() {
        return this.zzaez;
    }
}
