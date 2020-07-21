package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcyi implements zzduu<zzcyv> {
    private final /* synthetic */ zzawq zzgqw;
    private final /* synthetic */ zzcxz zzgqx;

    zzcyi(zzcxz zzcxz, zzawq zzawq) {
        this.zzgqx = zzcxz;
        this.zzgqw = zzawq;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        try {
            zzawq zzawq = this.zzgqw;
            String valueOf = String.valueOf(th.getMessage());
            zzawq.onError(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzcyv zzcyv) {
        zzcyv zzcyv2 = zzcyv;
        try {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcwu)).booleanValue()) {
                if (this.zzgqx.zzbov.zzede >= ((Integer) zzwg.zzpw().zzd(zzaav.zzcww)).intValue()) {
                    if (zzcyv2 == null) {
                        this.zzgqw.zza(null, null, null);
                        return;
                    } else {
                        this.zzgqw.zza(zzcyv2.zzgrf, zzcyv2.zzgrg, zzcyv2.zzgrh);
                        return;
                    }
                }
            }
            if (zzcyv2 == null) {
                this.zzgqw.zzk(null, null);
            } else {
                this.zzgqw.zzk(zzcyv2.zzgrf, zzcyv2.zzgrg);
            }
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
