package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzalc implements Runnable {
    private final zzald zzdgw;
    private final zzaju zzdgx;

    zzalc(zzald zzald, zzaju zzaju) {
        this.zzdgw = zzald;
        this.zzdgx = zzaju;
    }

    public final void run() {
        zzald zzald = this.zzdgw;
        zzaju zzaju = this.zzdgx;
        zzald.zzdgy.zzdgc.zzh(zzaju);
        zzaju.destroy();
    }
}
