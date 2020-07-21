package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdxq extends zzdwm<zzeab, zzdzy> {
    private final /* synthetic */ zzdxo zzhra;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdxq(zzdxo zzdxo, Class cls) {
        super(cls);
        this.zzhra = zzdxo;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdzy zze(zzeab zzeab) throws GeneralSecurityException {
        return (zzdzy) ((zzegb) zzdzy.zzazf().zzw(zzeer.zzu(zzedu.zzfn(zzeab.getKeySize()))).zzev(0).zzbfq());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzeab zzr(zzeer zzeer) throws zzegl {
        return zzeab.zzk(zzeer, zzefo.zzbeq());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ void zzd(zzeab zzeab) throws GeneralSecurityException {
        zzedv.zzfo(zzeab.getKeySize());
    }
}
