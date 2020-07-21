package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzij implements Runnable {
    private final /* synthetic */ String zzaiw;
    private final /* synthetic */ long zzaix;
    private final /* synthetic */ long zzaiy;
    private final /* synthetic */ zzih zzaiz;

    zzij(zzih zzih, String str, long j, long j2) {
        this.zzaiz = zzih;
        this.zzaiw = str;
        this.zzaix = j;
        this.zzaiy = j2;
    }

    public final void run() {
        this.zzaiz.zzaiv.zzb(this.zzaiw, this.zzaix, this.zzaiy);
    }
}
