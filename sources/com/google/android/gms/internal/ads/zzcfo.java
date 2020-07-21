package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcfo implements zzduh {
    private final JSONObject zzflz;
    private final zzcfp zzgbd;

    zzcfo(zzcfp zzcfp, JSONObject jSONObject) {
        this.zzgbd = zzcfp;
        this.zzflz = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        return this.zzgbd.zza(this.zzflz, (zzbfn) obj);
    }
}
