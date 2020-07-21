package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcsy implements zzduh {
    private final zzcsx zzglt;
    private final zzcgr zzglx;

    zzcsy(zzcsx zzcsx, zzcgr zzcgr) {
        this.zzglt = zzcsx;
        this.zzglx = zzcgr;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        return this.zzglt.zza(this.zzglx, (JSONObject) obj);
    }
}
