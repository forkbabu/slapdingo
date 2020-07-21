package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.ads.zzty;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcau implements zzbsl, zzbxz {
    private final View view;
    private final zzavy zzbqt;
    private final zzavv zzfow;
    private final zzty.zza.C0018zza zzfuc;
    private String zzfui;
    private final Context zzvr;

    public zzcau(zzavv zzavv, Context context, zzavy zzavy, View view2, zzty.zza.C0018zza zza) {
        this.zzfow = zzavv;
        this.zzvr = context;
        this.zzbqt = zzavy;
        this.view = view2;
        this.zzfuc = zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdOpened() {
        View view2 = this.view;
        if (!(view2 == null || this.zzfui == null)) {
            this.zzbqt.zzh(view2.getContext(), this.zzfui);
        }
        this.zzfow.zzam(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdClosed() {
        this.zzfow.zzam(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final void zzajx() {
        String zzae = this.zzbqt.zzae(this.zzvr);
        this.zzfui = zzae;
        String valueOf = String.valueOf(zzae);
        String str = this.zzfuc == zzty.zza.C0018zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zzfui = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    @ParametersAreNonnullByDefault
    public final void zzb(zzatg zzatg, String str, String str2) {
        if (this.zzbqt.zzac(this.zzvr)) {
            try {
                this.zzbqt.zza(this.zzvr, this.zzbqt.zzah(this.zzvr), this.zzfow.getAdUnitId(), zzatg.getType(), zzatg.getAmount());
            } catch (RemoteException e) {
                zzaxv.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
