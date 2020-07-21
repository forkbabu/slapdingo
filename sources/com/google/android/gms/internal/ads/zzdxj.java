package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdxj extends zzdwm<zzdzl, zzdzi> {
    private final /* synthetic */ zzdxh zzhqx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdxj(zzdxh zzdxh, Class cls) {
        super(cls);
        this.zzhqx = zzdxh;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdzi zze(zzdzl zzdzl) throws GeneralSecurityException {
        zzdzl zzdzl2 = zzdzl;
        return (zzdzi) ((zzegb) zzdzi.zzayl().zzb((zzdzm) new zzdxi().zzaxo().zze(zzdzl2.zzayn())).zzb((zzeax) new zzdyw().zzaxo().zze(zzdzl2.zzayo())).zzes(0).zzbfq());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdzl zzr(zzeer zzeer) throws zzegl {
        return zzdzl.zze(zzeer, zzefo.zzbeq());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ void zzd(zzdzl zzdzl) throws GeneralSecurityException {
        zzdzl zzdzl2 = zzdzl;
        new zzdxi().zzaxo().zzd(zzdzl2.zzayn());
        new zzdyw().zzaxo().zzd(zzdzl2.zzayo());
        zzedv.zzfo(zzdzl2.zzayn().getKeySize());
    }
}
