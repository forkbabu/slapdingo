package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzabt extends zzabr {
    private final OnCustomRenderedAdLoadedListener zzcjm;

    public zzabt(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcjm = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzabo
    public final void zza(zzabn zzabn) {
        this.zzcjm.onCustomRenderedAdLoaded(new zzabk(zzabn));
    }
}
