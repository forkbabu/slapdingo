package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdxp extends zzdwm<zzdzu, zzdzt> {
    private final /* synthetic */ zzdxn zzhqz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdxp(zzdxn zzdxn, Class cls) {
        super(cls);
        this.zzhqz = zzdxn;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdzt zze(zzdzu zzdzu) throws GeneralSecurityException {
        zzdzu zzdzu2 = zzdzu;
        return (zzdzt) ((zzegb) zzdzt.zzaza().zzv(zzeer.zzu(zzedu.zzfn(zzdzu2.getKeySize()))).zzb(zzdzu2.zzayz()).zzeu(0).zzbfq());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdzu zzr(zzeer zzeer) throws zzegl {
        return zzdzu.zzi(zzeer, zzefo.zzbeq());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ void zzd(zzdzu zzdzu) throws GeneralSecurityException {
        zzdzu zzdzu2 = zzdzu;
        zzedv.zzfo(zzdzu2.getKeySize());
        if (zzdzu2.zzayz().zzayw() != 12 && zzdzu2.zzayz().zzayw() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
