package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzq;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzclv implements AppEventListener, zzbsl, zzbsq, zzbtd, zzbtg, zzbua, zzbva, zzdpa, zzuu {
    private long startTime;
    private final List<Object> zzecz;
    private final zzclj zzgfe;

    public zzclv(zzclj zzclj, zzbif zzbif) {
        this.zzgfe = zzclj;
        this.zzecz = Collections.singletonList(zzbif);
    }

    @Override // com.google.android.gms.internal.ads.zzbva
    public final void zzb(zzdkw zzdkw) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzca(Context context) {
        zza(zzbtg.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzcb(Context context) {
        zza(zzbtg.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzcc(Context context) {
        zza(zzbtg.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zza(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void onAdLoaded() {
        long elapsedRealtime = zzq.zzld().elapsedRealtime() - this.startTime;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        zzaxv.zzeh(sb.toString());
        zza(zzbua.class, "onAdLoaded", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsq
    public final void onAdFailedToLoad(int i) {
        zza(zzbsq.class, "onAdFailedToLoad", Integer.valueOf(i));
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdOpened() {
        zza(zzbsl.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdClosed() {
        zza(zzbsl.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdLeftApplication() {
        zza(zzbsl.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzuu
    public final void onAdClicked() {
        zza(zzuu.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final void onAdImpression() {
        zza(zzbtd.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoStarted() {
        zza(zzbsl.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    @ParametersAreNonnullByDefault
    public final void zzb(zzatg zzatg, String str, String str2) {
        zza(zzbsl.class, "onRewarded", zzatg, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoCompleted() {
        zza(zzbsl.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zza(zzdor zzdor, String str) {
        zza(zzdos.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zzb(zzdor zzdor, String str) {
        zza(zzdos.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zza(zzdor zzdor, String str, Throwable th) {
        zza(zzdos.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zzc(zzdor zzdor, String str) {
        zza(zzdos.class, "onTaskSucceeded", str);
    }

    private final void zza(Class<?> cls, String str, Object... objArr) {
        zzclj zzclj = this.zzgfe;
        List<Object> list = this.zzecz;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzclj.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    @Override // com.google.android.gms.internal.ads.zzbva
    public final void zzd(zzasm zzasm) {
        this.startTime = zzq.zzld().elapsedRealtime();
        zza(zzbva.class, "onAdRequest", new Object[0]);
    }
}
