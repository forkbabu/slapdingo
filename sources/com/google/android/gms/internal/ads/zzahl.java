package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzahl implements zzahk {
    private final /* synthetic */ zzbbn zzdej;

    zzahl(zzahi zzahi, zzbbn zzbbn) {
        this.zzdej = zzbbn;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzc(JSONObject jSONObject) {
        this.zzdej.set(jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void onFailure(String str) {
        this.zzdej.setException(new zzalg(str));
    }
}
