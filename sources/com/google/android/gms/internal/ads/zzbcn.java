package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbcn implements Runnable {
    private final zzbcm zzeey;

    private zzbcn(zzbcm zzbcm) {
        this.zzeey = zzbcm;
    }

    static Runnable zza(zzbcm zzbcm) {
        return new zzbcn(zzbcm);
    }

    public final void run() {
        this.zzeey.stop();
    }
}
