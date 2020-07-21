package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyy extends zzdwm<zzebb, zzeax> {
    private final /* synthetic */ zzdyw zzhru;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdyy(zzdyw zzdyw, Class cls) {
        super(cls);
        this.zzhru = zzdyw;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzeax zze(zzebb zzebb) throws GeneralSecurityException {
        zzebb zzebb2 = zzebb;
        return (zzeax) ((zzegb) zzeax.zzbaj().zzfc(0).zzd(zzebb2.zzbai()).zzad(zzeer.zzu(zzedu.zzfn(zzebb2.getKeySize()))).zzbfq());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzebb zzr(zzeer zzeer) throws zzegl {
        return zzebb.zzr(zzeer, zzefo.zzbeq());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ void zzd(zzebb zzebb) throws GeneralSecurityException {
        zzebb zzebb2 = zzebb;
        if (zzebb2.getKeySize() >= 16) {
            zzdyw.zza(zzebb2.zzbai());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
