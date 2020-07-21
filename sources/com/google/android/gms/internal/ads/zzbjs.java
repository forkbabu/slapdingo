package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbjs implements zzcah {
    private zzbxa zzeti;
    private zzbrx zzetj;
    private zzdkw zzetl;
    private zzdir zzetm;
    private zzdhv zzetn;
    private final /* synthetic */ zzbiz zzeto;
    private zzcvw zzffj;

    private zzbjs(zzbiz zzbiz) {
        this.zzeto = zzbiz;
    }

    @Override // com.google.android.gms.internal.ads.zzcah
    /* renamed from: zzafu */
    public final zzcae zzaeg() {
        zzelg.zza(this.zzeti, zzbxa.class);
        zzelg.zza(this.zzetj, zzbrx.class);
        zzelg.zza(this.zzffj, zzcvw.class);
        return new zzbjr(this.zzeto, new zzbqf(), new zzdlt(), new zzbrl(), new zzcll(), this.zzeti, this.zzetj, new zzdmb(), this.zzffj, this.zzetl, this.zzetm, this.zzetn);
    }

    @Override // com.google.android.gms.internal.ads.zzcah
    public final /* synthetic */ zzcah zzb(zzcvw zzcvw) {
        this.zzffj = (zzcvw) zzelg.checkNotNull(zzcvw);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcah
    public final /* synthetic */ zzcah zzd(zzbrx zzbrx) {
        this.zzetj = (zzbrx) zzelg.checkNotNull(zzbrx);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcah
    public final /* synthetic */ zzcah zzd(zzbxa zzbxa) {
        this.zzeti = (zzbxa) zzelg.checkNotNull(zzbxa);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbru' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbru
    public final /* synthetic */ zzbru<zzcae> zza(zzdhv zzdhv) {
        this.zzetn = zzdhv;
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbru' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbru
    public final /* synthetic */ zzbru<zzcae> zza(zzdir zzdir) {
        this.zzetm = zzdir;
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbru' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbru
    public final /* synthetic */ zzbru<zzcae> zza(zzdkw zzdkw) {
        this.zzetl = zzdkw;
        return this;
    }
}
