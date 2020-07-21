package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzakr implements Runnable {
    private final zzaju zzdgk;

    private zzakr(zzaju zzaju) {
        this.zzdgk = zzaju;
    }

    static Runnable zzb(zzaju zzaju) {
        return new zzakr(zzaju);
    }

    public final void run() {
        this.zzdgk.destroy();
    }
}
