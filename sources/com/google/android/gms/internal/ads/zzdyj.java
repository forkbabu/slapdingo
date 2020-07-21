package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyj extends zzdwj<zzeaq> {
    public zzdyj() {
        super(zzeaq.class, new zzdyi(zzdwf.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.ASYMMETRIC_PUBLIC;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzeaq zzeaq) throws GeneralSecurityException {
        zzeaq zzeaq2 = zzeaq;
        zzedv.zzy(zzeaq2.getVersion(), 0);
        zzdyq.zza(zzeaq2.zzazo());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzeaq zzp(zzeer zzeer) throws zzegl {
        return zzeaq.zzp(zzeer, zzefo.zzbeq());
    }
}
