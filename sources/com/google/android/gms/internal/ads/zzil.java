package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzil implements Runnable {
    private final /* synthetic */ zzih zzaiz;
    private final /* synthetic */ int zzajb;
    private final /* synthetic */ long zzajc;
    private final /* synthetic */ long zzajd;

    zzil(zzih zzih, int i, long j, long j2) {
        this.zzaiz = zzih;
        this.zzajb = i;
        this.zzajc = j;
        this.zzajd = j2;
    }

    public final void run() {
        this.zzaiz.zzaiv.zzb(this.zzajb, this.zzajc, this.zzajd);
    }
}
