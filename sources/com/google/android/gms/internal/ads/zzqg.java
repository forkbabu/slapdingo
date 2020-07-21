package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqg implements Runnable {
    private final /* synthetic */ String zzaiw;
    private final /* synthetic */ long zzaix;
    private final /* synthetic */ long zzaiy;
    private final /* synthetic */ zzqe zzbmr;

    zzqg(zzqe zzqe, String str, long j, long j2) {
        this.zzbmr = zzqe;
        this.zzaiw = str;
        this.zzaix = j;
        this.zzaiy = j2;
    }

    public final void run() {
        this.zzbmr.zzbmq.zzd(this.zzaiw, this.zzaix, this.zzaiy);
    }
}
