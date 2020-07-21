package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyg extends zzdwm<zzeal, zzeap> {
    private final /* synthetic */ zzdye zzhri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdyg(zzdye zzdye, Class cls) {
        super(cls);
        this.zzhri = zzdye;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzeap zze(zzeal zzeal) throws GeneralSecurityException {
        zzeal zzeal2 = zzeal;
        KeyPair zza = zzedc.zza(zzedc.zza(zzdyq.zza(zzeal2.zzazo().zzazq().zzbad())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzeap) ((zzegb) zzeap.zzazw().zzey(0).zzb((zzeaq) ((zzegb) zzeaq.zzbaa().zzez(0).zzc(zzeal2.zzazo()).zzab(zzeer.zzu(w.getAffineX().toByteArray())).zzac(zzeer.zzu(w.getAffineY().toByteArray())).zzbfq())).zzaa(zzeer.zzu(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzbfq());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzeal zzr(zzeer zzeer) throws zzegl {
        return zzeal.zzn(zzeer, zzefo.zzbeq());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ void zzd(zzeal zzeal) throws GeneralSecurityException {
        zzdyq.zza(zzeal.zzazo());
    }
}
