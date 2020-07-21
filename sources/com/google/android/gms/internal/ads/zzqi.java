package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqi implements Runnable {
    private final /* synthetic */ zzqe zzbmr;
    private final /* synthetic */ int zzbms;
    private final /* synthetic */ long zzbmt;

    zzqi(zzqe zzqe, int i, long j) {
        this.zzbmr = zzqe;
        this.zzbms = i;
        this.zzbmt = j;
    }

    public final void run() {
        this.zzbmr.zzbmq.zzf(this.zzbms, this.zzbmt);
    }
}
