package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzajm extends zzbhs {
    private final /* synthetic */ zzajg zzdfh;

    private zzajm(zzajg zzajg) {
        this.zzdfh = zzajg;
    }

    @Override // com.google.android.gms.internal.ads.zzbhs
    public final void zza(zzbhr zzbhr) {
        if (this.zzdfh.zzdfe != null) {
            this.zzdfh.zzdfe.zzsz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhs
    public final void zzb(zzbhr zzbhr) {
        this.zzdfh.zzg(zzbhr.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbhs
    public final boolean zzc(zzbhr zzbhr) {
        return this.zzdfh.zzg(zzbhr.uri);
    }
}
