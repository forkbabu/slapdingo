package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcrj implements Runnable {
    private final zzbfn zzfzp;
    private final zzcrc zzgkq;

    zzcrj(zzcrc zzcrc, zzbfn zzbfn) {
        this.zzgkq = zzcrc;
        this.zzfzp = zzbfn;
    }

    public final void run() {
        this.zzgkq.zzo(this.zzfzp);
    }
}
