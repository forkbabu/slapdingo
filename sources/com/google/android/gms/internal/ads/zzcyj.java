package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcyj implements Runnable {
    private final zzcxz zzgqm;
    private final zzcgr[] zzgqv;

    zzcyj(zzcxz zzcxz, zzcgr[] zzcgrArr) {
        this.zzgqm = zzcxz;
        this.zzgqv = zzcgrArr;
    }

    public final void run() {
        this.zzgqm.zza(this.zzgqv);
    }
}
