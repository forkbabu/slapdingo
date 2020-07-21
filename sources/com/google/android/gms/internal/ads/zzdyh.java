package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyh extends zzdwl<zzdwg, zzeap> {
    zzdyh(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdwl
    public final /* synthetic */ zzdwg zzag(zzeap zzeap) throws GeneralSecurityException {
        zzeap zzeap2 = zzeap;
        zzeam zzazo = zzeap2.zzazv().zzazo();
        zzeat zzazq = zzazo.zzazq();
        zzede zza = zzdyq.zza(zzazq.zzbad());
        byte[] byteArray = zzeap2.zzayb().toByteArray();
        return new zzecv((ECPrivateKey) zzedf.zzhyk.zzhq("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzedc.zza(zza))), zzazq.zzbaf().toByteArray(), zzdyq.zza(zzazq.zzbae()), zzdyq.zza(zzazo.zzazs()), new zzdys(zzazo.zzazr().zzazl()));
    }
}
