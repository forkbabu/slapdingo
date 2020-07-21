package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzaxr;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzl extends zzaxr {
    final /* synthetic */ zzc zzdoc;

    private zzl(zzc zzc) {
        this.zzdoc = zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzut() {
        Bitmap zza = zzq.zzlp().zza(Integer.valueOf(this.zzdoc.zzdnb.zzdol.zzboo));
        if (zza != null) {
            zzaye.zzdzw.post(new zzk(this, zzq.zzky().zza(this.zzdoc.zzaar, zza, this.zzdoc.zzdnb.zzdol.zzbom, this.zzdoc.zzdnb.zzdol.zzbon)));
        }
    }
}
