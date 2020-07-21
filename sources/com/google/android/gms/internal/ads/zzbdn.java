package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbdn implements Runnable {
    private final int zzeak;
    private final int zzeal;
    private final zzbdi zzeii;

    zzbdn(zzbdi zzbdi, int i, int i2) {
        this.zzeii = zzbdi;
        this.zzeak = i;
        this.zzeal = i2;
    }

    public final void run() {
        this.zzeii.zzp(this.zzeak, this.zzeal);
    }
}
