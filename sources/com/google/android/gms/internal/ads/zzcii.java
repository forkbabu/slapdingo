package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcii implements zzaqc {
    private final /* synthetic */ zzchy zzgcr;

    zzcii(zzchy zzchy) {
        this.zzgcr = zzchy;
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final void zza(int i, int i2, int i3, int i4) {
        this.zzgcr.zzfpq.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final void zzuh() {
        this.zzgcr.zzfpq.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final void zzui() {
        this.zzgcr.zzgco.zzahv();
    }
}
