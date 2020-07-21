package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzql implements Runnable {
    private final /* synthetic */ zzqe zzbmr;
    private final /* synthetic */ int zzbmv;
    private final /* synthetic */ int zzbmw;
    private final /* synthetic */ int zzbmx;
    private final /* synthetic */ float zzbmy;

    zzql(zzqe zzqe, int i, int i2, int i3, float f) {
        this.zzbmr = zzqe;
        this.zzbmv = i;
        this.zzbmw = i2;
        this.zzbmx = i3;
        this.zzbmy = f;
    }

    public final void run() {
        this.zzbmr.zzbmq.zzb(this.zzbmv, this.zzbmw, this.zzbmx, this.zzbmy);
    }
}
