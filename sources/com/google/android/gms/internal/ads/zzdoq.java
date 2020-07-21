package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdoq implements Runnable {
    private final zzdom zzhfw;
    private final zzdod zzhfx;

    zzdoq(zzdom zzdom, zzdod zzdod) {
        this.zzhfw = zzdom;
        this.zzhfx = zzdod;
    }

    public final void run() {
        zzdom zzdom = this.zzhfw;
        zzdom.zzhfp.zzhfn.zzb(this.zzhfx);
    }
}
