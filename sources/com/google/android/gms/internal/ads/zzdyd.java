package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdyd extends zzdwj<zzece> {
    zzdyd() {
        super(zzece.class, new zzdyc(zzdwc.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdwm<com.google.android.gms.internal.ads.zzecf, com.google.android.gms.internal.ads.zzece>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzdwm<?, zzece> zzaxo() {
        return new zzdyf(this, zzecf.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzece zzece) throws GeneralSecurityException {
        zzece zzece2 = zzece;
        zzedv.zzy(zzece2.getVersion(), 0);
        if (zzece2.zzayb().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzece zzp(zzeer zzeer) throws zzegl {
        return zzece.zzw(zzeer, zzefo.zzbeq());
    }
}
