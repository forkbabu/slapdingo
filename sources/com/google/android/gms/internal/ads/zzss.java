package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzss implements zzrj {
    private final /* synthetic */ zzsq zzbuu;

    zzss(zzsq zzsq) {
        this.zzbuu = zzsq;
    }

    @Override // com.google.android.gms.internal.ads.zzrj
    public final void zzp(boolean z) {
        if (z) {
            this.zzbuu.connect();
        } else {
            this.zzbuu.disconnect();
        }
    }
}
