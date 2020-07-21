package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzin implements Runnable {
    private final /* synthetic */ zzih zzaiz;
    private final /* synthetic */ int zzajf;

    zzin(zzih zzih, int i) {
        this.zzaiz = zzih;
        this.zzajf = i;
    }

    public final void run() {
        this.zzaiz.zzaiv.zzx(this.zzajf);
    }
}
