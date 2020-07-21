package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdxh extends zzdwj<zzdzi> {
    zzdxh() {
        super(zzdzi.class, new zzdxg(zzdwc.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdwm<com.google.android.gms.internal.ads.zzdzl, com.google.android.gms.internal.ads.zzdzi>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzdwm<?, zzdzi> zzaxo() {
        return new zzdxj(this, zzdzl.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzdzi zzdzi) throws GeneralSecurityException {
        zzedv.zzy(zzdzi.getVersion(), 0);
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzdzi zzp(zzeer zzeer) throws zzegl {
        return zzdzi.zzd(zzeer, zzefo.zzbeq());
    }
}
