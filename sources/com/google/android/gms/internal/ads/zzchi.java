package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzchi implements Runnable {
    private final zzbfn zzeot;

    private zzchi(zzbfn zzbfn) {
        this.zzeot = zzbfn;
    }

    static Runnable zzh(zzbfn zzbfn) {
        return new zzchi(zzbfn);
    }

    public final void run() {
        this.zzeot.destroy();
    }
}
