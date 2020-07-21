package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzaji implements Runnable {
    private final zzajg zzdff;
    private final String zzdfg;

    zzaji(zzajg zzajg, String str) {
        this.zzdff = zzajg;
        this.zzdfg = str;
    }

    public final void run() {
        this.zzdff.zzdd(this.zzdfg);
    }
}
