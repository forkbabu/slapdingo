package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcfd implements zzdrx {
    private final JSONObject zzflz;
    private final zzcey zzgaw;

    zzcfd(zzcey zzcey, JSONObject jSONObject) {
        this.zzgaw = zzcey;
        this.zzflz = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        return this.zzgaw.zza(this.zzflz, (List) obj);
    }
}
