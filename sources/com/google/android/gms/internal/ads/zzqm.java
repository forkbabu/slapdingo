package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqm implements Runnable {
    private final /* synthetic */ zzjj zzajg;
    private final /* synthetic */ zzqe zzbmr;

    zzqm(zzqe zzqe, zzjj zzjj) {
        this.zzbmr = zzqe;
        this.zzajg = zzjj;
    }

    public final void run() {
        this.zzajg.zzgm();
        this.zzbmr.zzbmq.zzf(this.zzajg);
    }
}
