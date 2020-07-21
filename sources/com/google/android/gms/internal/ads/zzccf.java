package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzccf implements Runnable {
    private final zzccs zzfwj;

    private zzccf(zzccs zzccs) {
        this.zzfwj = zzccs;
    }

    static Runnable zza(zzccs zzccs) {
        return new zzccf(zzccs);
    }

    public final void run() {
        this.zzfwj.zzakx();
    }
}
