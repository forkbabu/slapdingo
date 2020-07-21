package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzakk implements Runnable {
    private final zzakh zzdfx;
    private final zzaky zzdgf;
    private final zzaju zzdgg;

    zzakk(zzakh zzakh, zzaky zzaky, zzaju zzaju) {
        this.zzdfx = zzakh;
        this.zzdgf = zzaky;
        this.zzdgg = zzaju;
    }

    public final void run() {
        this.zzdfx.zza(this.zzdgf, this.zzdgg);
    }
}
