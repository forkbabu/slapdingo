package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdxn extends zzdwj<zzdzt> {
    zzdxn() {
        super(zzdzt.class, new zzdxm(zzdwc.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdwm<com.google.android.gms.internal.ads.zzdzu, com.google.android.gms.internal.ads.zzdzt>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzdwm<?, zzdzt> zzaxo() {
        return new zzdxp(this, zzdzu.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzdzt zzdzt) throws GeneralSecurityException {
        zzdzt zzdzt2 = zzdzt;
        zzedv.zzy(zzdzt2.getVersion(), 0);
        zzedv.zzfo(zzdzt2.zzayb().size());
        if (zzdzt2.zzayz().zzayw() != 12 && zzdzt2.zzayz().zzayw() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzdzt zzp(zzeer zzeer) throws zzegl {
        return zzdzt.zzh(zzeer, zzefo.zzbeq());
    }
}
