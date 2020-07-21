package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzage implements Runnable {
    private final /* synthetic */ PublisherAdView zzddc;
    private final /* synthetic */ zzww zzddd;
    private final /* synthetic */ zzagf zzdde;

    zzage(zzagf zzagf, PublisherAdView publisherAdView, zzww zzww) {
        this.zzdde = zzagf;
        this.zzddc = publisherAdView;
        this.zzddd = zzww;
    }

    public final void run() {
        if (this.zzddc.zza(this.zzddd)) {
            this.zzdde.zzddf.onPublisherAdViewLoaded(this.zzddc);
        } else {
            zzbba.zzfd("Could not bind.");
        }
    }
}
