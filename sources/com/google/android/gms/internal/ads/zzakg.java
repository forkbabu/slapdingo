package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzakg implements Runnable {
    private final zzakh zzdfx;
    private final zzeg zzdfy;
    private final zzaky zzdfz;

    zzakg(zzakh zzakh, zzeg zzeg, zzaky zzaky) {
        this.zzdfx = zzakh;
        this.zzdfy = zzeg;
        this.zzdfz = zzaky;
    }

    public final void run() {
        this.zzdfx.zza(this.zzdfy, this.zzdfz);
    }
}
