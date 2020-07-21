package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzim implements Runnable {
    private final /* synthetic */ zzih zzaiz;
    private final /* synthetic */ zzhq zzaje;

    zzim(zzih zzih, zzhq zzhq) {
        this.zzaiz = zzih;
        this.zzaje = zzhq;
    }

    public final void run() {
        this.zzaiz.zzaiv.zzc(this.zzaje);
    }
}
