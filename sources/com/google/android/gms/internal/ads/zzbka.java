package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbka implements zzcxw {
    private zzbrx zzetj;
    private final /* synthetic */ zzbiz zzeto;
    private zzcym zzfjo;

    private zzbka(zzbiz zzbiz) {
        this.zzeto = zzbiz;
    }

    @Override // com.google.android.gms.internal.ads.zzcxw
    public final zzcxx zzagh() {
        zzelg.zza(this.zzetj, zzbrx.class);
        zzelg.zza(this.zzfjo, zzcym.class);
        return new zzbjz(this.zzeto, this.zzfjo, new zzbqf(), new zzcll(), this.zzetj, new zzdmb());
    }

    @Override // com.google.android.gms.internal.ads.zzcxw
    @Deprecated
    public final /* synthetic */ zzcxw zzf(zzbxa zzbxa) {
        zzelg.checkNotNull(zzbxa);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcxw
    public final /* synthetic */ zzcxw zza(zzcym zzcym) {
        this.zzfjo = (zzcym) zzelg.checkNotNull(zzcym);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcxw
    public final /* synthetic */ zzcxw zzf(zzbrx zzbrx) {
        this.zzetj = (zzbrx) zzelg.checkNotNull(zzbrx);
        return this;
    }
}
