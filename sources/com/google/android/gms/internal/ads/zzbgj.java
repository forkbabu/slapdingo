package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbgj implements Runnable {
    private final int zzeak;
    private final int zzeal;
    private final boolean zzemg;
    private final boolean zzemh;
    private final zzbgh zzeos;

    zzbgj(zzbgh zzbgh, int i, int i2, boolean z, boolean z2) {
        this.zzeos = zzbgh;
        this.zzeak = i;
        this.zzeal = i2;
        this.zzemg = z;
        this.zzemh = z2;
    }

    public final void run() {
        this.zzeos.zzb(this.zzeak, this.zzeal, this.zzemg, this.zzemh);
    }
}
