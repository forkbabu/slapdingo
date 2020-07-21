package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzik implements Runnable {
    private final /* synthetic */ zzih zzaiz;
    private final /* synthetic */ zzjj zzaja;

    zzik(zzih zzih, zzjj zzjj) {
        this.zzaiz = zzih;
        this.zzaja = zzjj;
    }

    public final void run() {
        this.zzaiz.zzaiv.zzc(this.zzaja);
    }
}
