package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqg implements zzdpa {
    private final zzcqf zzgjo;

    zzcqg(zzcqf zzcqf) {
        this.zzgjo = zzcqf;
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zza(zzdor zzdor, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zzb(zzdor zzdor, String str) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvp)).booleanValue() && zzdor.RENDERER == zzdor) {
            this.zzgjo.zzff(zzq.zzld().elapsedRealtime());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zza(zzdor zzdor, String str, Throwable th) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvp)).booleanValue() && zzdor.RENDERER == zzdor && this.zzgjo.zzapk() != 0) {
            this.zzgjo.zzer(zzq.zzld().elapsedRealtime() - this.zzgjo.zzapk());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zzc(zzdor zzdor, String str) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvp)).booleanValue() && zzdor.RENDERER == zzdor && this.zzgjo.zzapk() != 0) {
            this.zzgjo.zzer(zzq.zzld().elapsedRealtime() - this.zzgjo.zzapk());
        }
    }
}
