package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcgt implements zzduh {
    private final String zzdfg;
    private final zzcgr zzgbo;
    private final JSONObject zzgbs;

    zzcgt(zzcgr zzcgr, String str, JSONObject jSONObject) {
        this.zzgbo = zzcgr;
        this.zzdfg = str;
        this.zzgbs = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        return this.zzgbo.zza(this.zzdfg, this.zzgbs, (zzbfn) obj);
    }
}
