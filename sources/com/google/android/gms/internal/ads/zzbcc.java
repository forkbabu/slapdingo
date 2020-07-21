package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbcc implements Runnable {
    private final int zzeak;
    private final zzbbz zzeer;

    zzbcc(zzbbz zzbbz, int i) {
        this.zzeer = zzbbz;
        this.zzeak = i;
    }

    public final void run() {
        this.zzeer.zzdi(this.zzeak);
    }
}
