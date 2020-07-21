package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdyr extends zzdwj<zzdzd> {
    zzdyr() {
        super(zzdzd.class, new zzdyu(zzdwp.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.SYMMETRIC;
    }

    /* access modifiers changed from: private */
    public static void zza(zzdzh zzdzh) throws GeneralSecurityException {
        if (zzdzh.zzayg() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzdzh.zzayg() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzep(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 16 bytes");
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdwm<com.google.android.gms.internal.ads.zzdze, com.google.android.gms.internal.ads.zzdzd>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzdwm<?, zzdzd> zzaxo() {
        return new zzdyt(this, zzdze.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzdzd zzdzd) throws GeneralSecurityException {
        zzdzd zzdzd2 = zzdzd;
        zzedv.zzy(zzdzd2.getVersion(), 0);
        zzep(zzdzd2.zzayb().size());
        zza(zzdzd2.zzayc());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzdzd zzp(zzeer zzeer) throws zzegl {
        return zzdzd.zzb(zzeer, zzefo.zzbeq());
    }
}
