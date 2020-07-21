package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzsm extends AppOpenAd {
    private final zzsf zzbuk;

    public zzsm(zzsf zzsf) {
        this.zzbuk = zzsf;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final zzww zzdv() {
        try {
            return this.zzbuk.zzdv();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void zza(zzsl zzsl) {
        try {
            this.zzbuk.zza(zzsl);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
