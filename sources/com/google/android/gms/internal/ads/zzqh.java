package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqh implements Runnable {
    private final /* synthetic */ zzjj zzaja;
    private final /* synthetic */ zzqe zzbmr;

    zzqh(zzqe zzqe, zzjj zzjj) {
        this.zzbmr = zzqe;
        this.zzaja = zzjj;
    }

    public final void run() {
        this.zzbmr.zzbmq.zze(this.zzaja);
    }
}
