package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcxk implements zzbsq {
    private final zzcxb zzgpj;
    private final zzaiw zzgqa;

    zzcxk(zzcxb zzcxb, zzaiw zzaiw) {
        this.zzgpj = zzcxb;
        this.zzgqa = zzaiw;
    }

    @Override // com.google.android.gms.internal.ads.zzbsq
    public final void onAdFailedToLoad(int i) {
        zzcxb zzcxb = this.zzgpj;
        zzaiw zzaiw = this.zzgqa;
        zzcxb.onAdFailedToLoad(i);
        if (zzaiw != null) {
            try {
                zzaiw.onInstreamAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzbba.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
