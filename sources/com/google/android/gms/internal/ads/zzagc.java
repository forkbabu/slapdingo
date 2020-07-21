package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzagc extends zzaex {
    private final NativeContentAd.OnContentAdLoadedListener zzdda;

    public zzagc(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzdda = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zza(zzael zzael) {
        this.zzdda.onContentAdLoaded(new zzaem(zzael));
    }
}
