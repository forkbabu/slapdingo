package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzduc implements Runnable {
    private final /* synthetic */ zzdub zzhns;
    private final /* synthetic */ zzdsr zzhnz;

    zzduc(zzdub zzdub, zzdsr zzdsr) {
        this.zzhns = zzdub;
        this.zzhnz = zzdsr;
    }

    public final void run() {
        this.zzhns.zza(this.zzhnz);
    }
}
