package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcrn implements zzboy {
    private final zzdlm zzgkt;

    private zzcrn(zzdlm zzdlm) {
        this.zzgkt = zzdlm;
    }

    static zzboy zza(zzdlm zzdlm) {
        return new zzcrn(zzdlm);
    }

    @Override // com.google.android.gms.internal.ads.zzboy
    public final zzyi getVideoController() {
        return this.zzgkt.getVideoController();
    }
}
