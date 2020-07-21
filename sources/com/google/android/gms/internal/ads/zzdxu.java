package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdxu extends zzdwj<zzebr> {
    zzdxu() {
        super(zzebr.class, new zzdxx(zzdwc.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.REMOTE;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdwm<com.google.android.gms.internal.ads.zzebu, com.google.android.gms.internal.ads.zzebr>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzdwm<?, zzebr> zzaxo() {
        return new zzdxw(this, zzebu.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzebr zzebr) throws GeneralSecurityException {
        zzedv.zzy(zzebr.getVersion(), 0);
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzebr zzp(zzeer zzeer) throws zzegl {
        return zzebr.zzs(zzeer, zzefo.zzbeq());
    }
}
