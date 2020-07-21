package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdxi extends zzdwj<zzdzm> {
    zzdxi() {
        super(zzdzm.class, new zzdxl(zzedp.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdwm<com.google.android.gms.internal.ads.zzdzp, com.google.android.gms.internal.ads.zzdzm>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzdwm<?, zzdzm> zzaxo() {
        return new zzdxk(this, zzdzp.class);
    }

    /* access modifiers changed from: private */
    public static void zza(zzdzq zzdzq) throws GeneralSecurityException {
        if (zzdzq.zzayw() < 12 || zzdzq.zzayw() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzdzm zzdzm) throws GeneralSecurityException {
        zzdzm zzdzm2 = zzdzm;
        zzedv.zzy(zzdzm2.getVersion(), 0);
        zzedv.zzfo(zzdzm2.zzayb().size());
        zza(zzdzm2.zzayq());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzdzm zzp(zzeer zzeer) throws zzegl {
        return zzdzm.zzf(zzeer, zzefo.zzbeq());
    }
}
