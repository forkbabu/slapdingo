package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcgk implements zzadh {
    private final /* synthetic */ zzcgl zzgbl;

    zzcgk(zzcgl zzcgl) {
        this.zzgbl = zzcgl;
    }

    @Override // com.google.android.gms.internal.ads.zzadh
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzadh
    public final void zzrz() {
        if (this.zzgbl.zzfya != null) {
            this.zzgbl.zzfya.zzfy(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
        }
    }
}
