package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzakc implements Runnable {
    private final /* synthetic */ zzajw zzdft;
    private final /* synthetic */ String zzdfv;

    zzakc(zzajw zzajw, String str) {
        this.zzdft = zzajw;
        this.zzdfv = str;
    }

    public final void run() {
        this.zzdft.zzdfp.loadUrl(this.zzdfv);
    }
}
