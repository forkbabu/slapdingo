package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzmq implements Runnable {
    private final /* synthetic */ zzmp zzbdd;
    private final /* synthetic */ zzmv zzbee;

    zzmq(zzmp zzmp, zzmv zzmv) {
        this.zzbdd = zzmp;
        this.zzbee = zzmv;
    }

    public final void run() {
        this.zzbee.release();
        int size = this.zzbdd.zzbdp.size();
        for (int i = 0; i < size; i++) {
            ((zznj) this.zzbdd.zzbdp.valueAt(i)).disable();
        }
    }
}
