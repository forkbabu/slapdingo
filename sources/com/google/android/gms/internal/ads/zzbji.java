package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbji implements zzbmt {
    private zzbxa zzeti;
    private zzbrx zzetj;
    private zzdkw zzetl;
    private zzdir zzetm;
    private zzdhv zzetn;
    private final /* synthetic */ zzbiz zzeto;

    private zzbji(zzbiz zzbiz) {
        this.zzeto = zzbiz;
    }

    @Override // com.google.android.gms.internal.ads.zzbmt
    /* renamed from: zzafg */
    public final zzbmq zzaeg() {
        zzelg.zza(this.zzeti, zzbxa.class);
        zzelg.zza(this.zzetj, zzbrx.class);
        return new zzbjh(this.zzeto, new zzbqf(), new zzdlt(), new zzbrl(), new zzcll(), this.zzeti, this.zzetj, new zzdmb(), this.zzetl, this.zzetm, this.zzetn);
    }

    @Override // com.google.android.gms.internal.ads.zzbmt
    @Deprecated
    public final /* synthetic */ zzbmt zza(zzbnb zzbnb) {
        zzelg.checkNotNull(zzbnb);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbmt
    public final /* synthetic */ zzbmt zzb(zzbrx zzbrx) {
        this.zzetj = (zzbrx) zzelg.checkNotNull(zzbrx);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbmt
    public final /* synthetic */ zzbmt zzb(zzbxa zzbxa) {
        this.zzeti = (zzbxa) zzelg.checkNotNull(zzbxa);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbru' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbru
    public final /* synthetic */ zzbru<zzbmq> zza(zzdhv zzdhv) {
        this.zzetn = zzdhv;
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbru' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbru
    public final /* synthetic */ zzbru<zzbmq> zza(zzdir zzdir) {
        this.zzetm = zzdir;
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbru' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbru
    public final /* synthetic */ zzbru<zzbmq> zza(zzdkw zzdkw) {
        this.zzetl = zzdkw;
        return this;
    }
}
