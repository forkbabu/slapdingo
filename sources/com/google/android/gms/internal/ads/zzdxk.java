package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdxk extends zzdwm<zzdzp, zzdzm> {
    private final /* synthetic */ zzdxi zzhqy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdxk(zzdxi zzdxi, Class cls) {
        super(cls);
        this.zzhqy = zzdxi;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdzm zze(zzdzp zzdzp) throws GeneralSecurityException {
        zzdzp zzdzp2 = zzdzp;
        return (zzdzm) ((zzegb) zzdzm.zzayr().zzc(zzdzp2.zzayq()).zzu(zzeer.zzu(zzedu.zzfn(zzdzp2.getKeySize()))).zzet(0).zzbfq());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdzp zzr(zzeer zzeer) throws zzegl {
        return zzdzp.zzg(zzeer, zzefo.zzbeq());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ void zzd(zzdzp zzdzp) throws GeneralSecurityException {
        zzdzp zzdzp2 = zzdzp;
        zzedv.zzfo(zzdzp2.getKeySize());
        zzdxi.zza(zzdzp2.zzayq());
    }
}
