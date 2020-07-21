package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcch implements Runnable {
    private final boolean zzefs;
    private final zzccd zzfvx;

    zzcch(zzccd zzccd, boolean z) {
        this.zzfvx = zzccd;
        this.zzefs = z;
    }

    public final void run() {
        this.zzfvx.zzbj(this.zzefs);
    }
}
