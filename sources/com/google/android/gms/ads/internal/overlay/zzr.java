package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzaxv;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzr extends zzc {
    public zzr(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzc, com.google.android.gms.internal.ads.zzaqi
    public final void onCreate(Bundle bundle) {
        zzaxv.zzeh("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzdnk = 3;
        this.zzaar.finish();
    }
}
