package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzajj implements Runnable {
    private final zzajg zzdff;
    private final String zzdfg;

    zzajj(zzajg zzajg, String str) {
        this.zzdff = zzajg;
        this.zzdfg = str;
    }

    public final void run() {
        this.zzdff.zzde(this.zzdfg);
    }
}
