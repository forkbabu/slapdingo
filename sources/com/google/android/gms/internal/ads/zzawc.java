package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzawc implements Runnable {
    private final String zzdia;
    private final zzavy zzdwu;
    private final zzawo zzdwv;

    zzawc(zzavy zzavy, zzawo zzawo, String str) {
        this.zzdwu = zzavy;
        this.zzdwv = zzawo;
        this.zzdia = str;
    }

    public final void run() {
        this.zzdwu.zza(this.zzdwv, this.zzdia);
    }
}
