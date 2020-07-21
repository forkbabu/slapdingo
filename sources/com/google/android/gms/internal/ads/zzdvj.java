package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvj implements Runnable {
    private final /* synthetic */ Runnable zzhot;
    private final /* synthetic */ zzdvk zzhou;

    zzdvj(zzdvk zzdvk, Runnable runnable) {
        this.zzhou = zzdvk;
        this.zzhot = runnable;
    }

    public final void run() {
        this.zzhou.zzhov = false;
        this.zzhot.run();
    }

    public final String toString() {
        return this.zzhot.toString();
    }
}
