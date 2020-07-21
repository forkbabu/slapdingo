package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbge implements Runnable {
    private final /* synthetic */ zzbgc zzeoh;

    zzbge(zzbgc zzbgc) {
        this.zzeoh = zzbgc;
    }

    public final void run() {
        this.zzeoh.zzemv.destroy();
    }
}
