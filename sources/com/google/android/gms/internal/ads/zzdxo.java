package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdxo extends zzdwj<zzdzy> {
    zzdxo() {
        super(zzdzy.class, new zzdxr(zzdwc.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdwm<com.google.android.gms.internal.ads.zzeab, com.google.android.gms.internal.ads.zzdzy>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzdwm<?, zzdzy> zzaxo() {
        return new zzdxq(this, zzeab.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzdzy zzdzy) throws GeneralSecurityException {
        zzdzy zzdzy2 = zzdzy;
        zzedv.zzy(zzdzy2.getVersion(), 0);
        zzedv.zzfo(zzdzy2.zzayb().size());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzdzy zzp(zzeer zzeer) throws zzegl {
        return zzdzy.zzj(zzeer, zzefo.zzbeq());
    }
}
