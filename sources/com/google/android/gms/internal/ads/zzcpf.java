package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcpf implements zzdob {
    static final zzdob zzggm = new zzcpf();

    private zzcpf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzaxv.zzeh("Ad request signals:");
        zzaxv.zzeh(jSONObject.toString(2));
        return jSONObject;
    }
}
