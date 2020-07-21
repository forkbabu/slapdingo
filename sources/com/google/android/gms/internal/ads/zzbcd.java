package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbcd implements Runnable {
    private final /* synthetic */ zzbbz zzeeq;
    private final /* synthetic */ String zzees;
    private final /* synthetic */ String zzeet;

    zzbcd(zzbbz zzbbz, String str, String str2) {
        this.zzeeq = zzbbz;
        this.zzees = str;
        this.zzeet = str2;
    }

    public final void run() {
        if (this.zzeeq.zzeeo != null) {
            this.zzeeq.zzeeo.zzm(this.zzees, this.zzeet);
        }
    }
}
