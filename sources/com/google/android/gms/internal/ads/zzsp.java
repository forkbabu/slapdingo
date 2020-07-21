package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzsp {
    private final int orientation;
    private final zzvf zzacq;
    private final zzyq zzacs;
    private zzww zzbul;
    private final String zzbum;
    private final AppOpenAd.AppOpenAdLoadCallback zzbun;
    private final zzamo zzbuo = new zzamo();
    private final Context zzvr;

    public zzsp(Context context, String str, zzyq zzyq, int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzvr = context;
        this.zzbum = str;
        this.zzacs = zzyq;
        this.orientation = i;
        this.zzbun = appOpenAdLoadCallback;
        this.zzacq = zzvf.zzchh;
    }

    public final void zzmt() {
        try {
            this.zzbul = zzwg.zzpt().zza(this.zzvr, zzvh.zzpj(), this.zzbum, this.zzbuo);
            this.zzbul.zza(new zzvo(this.orientation));
            this.zzbul.zza(new zzsd(this.zzbun));
            this.zzbul.zza(zzvf.zza(this.zzvr, this.zzacs));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }
}
