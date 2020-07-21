package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbli implements zzbtg {
    private final zzdlm zzfkl;

    public zzbli(zzdlm zzdlm) {
        this.zzfkl = zzdlm;
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzca(Context context) {
        try {
            this.zzfkl.pause();
        } catch (zzdlg e) {
            zzaxv.zzd("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzcb(Context context) {
        try {
            this.zzfkl.resume();
            if (context != null) {
                this.zzfkl.onContextChanged(context);
            }
        } catch (zzdlg e) {
            zzaxv.zzd("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzcc(Context context) {
        try {
            this.zzfkl.destroy();
        } catch (zzdlg e) {
            zzaxv.zzd("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
