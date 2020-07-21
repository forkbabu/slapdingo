package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyt extends zzdwm<zzdze, zzdzd> {
    zzdyt(zzdyr zzdyr, Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdzd zze(zzdze zzdze) throws GeneralSecurityException {
        zzdze zzdze2 = zzdze;
        return (zzdzd) ((zzegb) zzdzd.zzayd().zzer(0).zzt(zzeer.zzu(zzedu.zzfn(zzdze2.getKeySize()))).zzd(zzdze2.zzayc()).zzbfq());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdze zzr(zzeer zzeer) throws zzegl {
        return zzdze.zzc(zzeer, zzefo.zzbeq());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ void zzd(zzdze zzdze) throws GeneralSecurityException {
        zzdze zzdze2 = zzdze;
        zzdyr.zza(zzdze2.zzayc());
        zzdyr.zzep(zzdze2.getKeySize());
    }
}
