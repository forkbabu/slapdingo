package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzty;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcao implements zzo, zzbua {
    private final zzbbd zzboy;
    private final zzbfn zzdfp;
    private final zzdkk zzfol;
    private IObjectWrapper zzfom;
    private final zzty.zza.C0018zza zzfuc;
    private final Context zzvr;

    public zzcao(Context context, zzbfn zzbfn, zzdkk zzdkk, zzbbd zzbbd, zzty.zza.C0018zza zza) {
        this.zzvr = context;
        this.zzdfp = zzbfn;
        this.zzfol = zzdkk;
        this.zzboy = zzbbd;
        this.zzfuc = zza;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void onAdLoaded() {
        if ((this.zzfuc == zzty.zza.C0018zza.REWARD_BASED_VIDEO_AD || this.zzfuc == zzty.zza.C0018zza.INTERSTITIAL) && this.zzfol.zzdse && this.zzdfp != null && zzq.zzll().zzp(this.zzvr)) {
            int i = this.zzboy.zzedd;
            int i2 = this.zzboy.zzede;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            IObjectWrapper zza = zzq.zzll().zza(sb.toString(), this.zzdfp.getWebView(), "", "javascript", this.zzfol.zzhab.optInt("media_type", -1) == 0 ? null : "javascript");
            this.zzfom = zza;
            if (zza != null && this.zzdfp.getView() != null) {
                zzq.zzll().zza(this.zzfom, this.zzdfp.getView());
                this.zzdfp.zzap(this.zzfom);
                zzq.zzll().zzab(this.zzfom);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzud() {
        this.zzfom = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzue() {
        zzbfn zzbfn;
        if (this.zzfom != null && (zzbfn = this.zzdfp) != null) {
            zzbfn.zza("onSdkImpression", new HashMap());
        }
    }
}
