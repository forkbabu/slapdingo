package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbcf implements Runnable {
    private final /* synthetic */ zzbbz zzeeq;
    private final /* synthetic */ int zzeeu;
    private final /* synthetic */ int zzeev;

    zzbcf(zzbbz zzbbz, int i, int i2) {
        this.zzeeq = zzbbz;
        this.zzeeu = i;
        this.zzeev = i2;
    }

    public final void run() {
        if (this.zzeeq.zzeeo != null) {
            this.zzeeq.zzeeo.zzk(this.zzeeu, this.zzeev);
        }
    }
}
