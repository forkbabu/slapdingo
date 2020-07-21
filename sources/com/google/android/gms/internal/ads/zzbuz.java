package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbuz extends AdMetadataListener implements AppEventListener, zzbsl, zzbsz, zzbtd, zzbuf, zzbup, zzuu {
    private final zzbvy zzfsd = new zzbvy(this);
    /* access modifiers changed from: private */
    @Nullable
    public zzcxb zzfse;
    /* access modifiers changed from: private */
    @Nullable
    public zzcwy zzfsf;
    /* access modifiers changed from: private */
    @Nullable
    public zzcxa zzfsg;
    /* access modifiers changed from: private */
    @Nullable
    public zzcww zzfsh;
    /* access modifiers changed from: private */
    @Nullable
    public zzdhi zzfsi;
    /* access modifiers changed from: private */
    @Nullable
    public zzdiu zzfsj;

    public final zzbvy zzaij() {
        return this.zzfsd;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdOpened() {
        zza(this.zzfse, zzbvc.zzfsk);
        zza(this.zzfsj, zzbvb.zzfsk);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdClosed() {
        zza(this.zzfse, zzbvo.zzfsk);
        zza(this.zzfsj, zzbvq.zzfsk);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdLeftApplication() {
        zza(this.zzfse, zzbvp.zzfsk);
        zza(this.zzfsj, zzbvs.zzfsk);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoStarted() {
        zza(this.zzfse, zzbvr.zzfsk);
        zza(this.zzfsj, zzbvu.zzfsk);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void zzb(zzatg zzatg, String str, String str2) {
        zza(this.zzfse, new zzbvt(zzatg, str, str2));
        zza(this.zzfsj, new zzbvw(zzatg, str, str2));
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoCompleted() {
        zza(this.zzfse, zzbve.zzfsk);
        zza(this.zzfsj, zzbvd.zzfsk);
    }

    @Override // com.google.android.gms.internal.ads.zzuu
    public final void onAdClicked() {
        zza(this.zzfse, zzbvg.zzfsk);
        zza(this.zzfsf, zzbvf.zzfsk);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zza(this.zzfsg, new zzbvi(str, str2));
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzb(zzvj zzvj) {
        zza(this.zzfsh, new zzbvh(zzvj));
        zza(this.zzfsj, new zzbvk(zzvj));
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final void onAdImpression() {
        zza(this.zzfse, zzbvj.zzfsk);
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void zzajb() {
        zza(this.zzfsi, zzbvm.zzfsk);
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zza(this.zzfsj, zzbvl.zzfsk);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzuy zzuy) {
        zza(this.zzfsj, new zzbvn(zzuy));
    }

    private static <T> void zza(T t, zzbvx<T> zzbvx) {
        if (t != null) {
            zzbvx.zzq(t);
        }
    }
}
