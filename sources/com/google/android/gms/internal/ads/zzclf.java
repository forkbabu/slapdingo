package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzclf implements Runnable {
    private final String zzdfg;
    private final zzclc zzgev;

    zzclf(zzclc zzclc, String str) {
        this.zzgev = zzclc;
        this.zzdfg = str;
    }

    public final void run() {
        this.zzgev.zzgh(this.zzdfg);
    }
}
