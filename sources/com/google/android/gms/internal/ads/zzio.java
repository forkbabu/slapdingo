package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzio implements Runnable {
    private final /* synthetic */ zzih zzaiz;
    private final /* synthetic */ zzjj zzajg;

    zzio(zzih zzih, zzjj zzjj) {
        this.zzaiz = zzih;
        this.zzajg = zzjj;
    }

    public final void run() {
        this.zzajg.zzgm();
        this.zzaiz.zzaiv.zzd(this.zzajg);
    }
}
