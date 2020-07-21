package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqj implements Runnable {
    private final /* synthetic */ zzhq zzaje;
    private final /* synthetic */ zzqe zzbmr;

    zzqj(zzqe zzqe, zzhq zzhq) {
        this.zzbmr = zzqe;
        this.zzaje = zzhq;
    }

    public final void run() {
        this.zzbmr.zzbmq.zzk(this.zzaje);
    }
}
