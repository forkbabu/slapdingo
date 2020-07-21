package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcbp implements zzahc<Object> {
    private WeakReference<zzcbk> zzfvn;

    private zzcbp(zzcbk zzcbk) {
        this.zzfvn = new WeakReference<>(zzcbk);
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        zzcbk zzcbk = this.zzfvn.get();
        if (zzcbk != null) {
            zzcbk.zzfuv.onAdImpression();
        }
    }
}
