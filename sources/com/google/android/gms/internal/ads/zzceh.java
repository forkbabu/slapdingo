package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzceh implements zzbtd {
    private final zzcck zzfuu;
    private final zzcco zzfwa;

    public zzceh(zzcck zzcck, zzcco zzcco) {
        this.zzfuu = zzcck;
        this.zzfwa = zzcco;
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final void onAdImpression() {
        if (this.zzfuu.zzaln() != null) {
            zzbfn zzalm = this.zzfuu.zzalm();
            zzbfn zzall = this.zzfuu.zzall();
            if (zzalm == null) {
                zzalm = zzall != null ? zzall : null;
            }
            if (this.zzfwa.zzalc() && zzalm != null) {
                zzalm.zza("onSdkImpression", new ArrayMap());
            }
        }
    }
}
