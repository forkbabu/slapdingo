package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzccr extends zzcco {
    private final boolean zzdis;
    private final boolean zzdit;
    private final boolean zzdse;
    private final JSONObject zzfxj;
    private final boolean zzfxk;

    public zzccr(zzdkk zzdkk, JSONObject jSONObject) {
        super(zzdkk);
        this.zzfxj = zzazy.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzdit = zzazy.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdis = zzazy.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdse = zzazy.zza(false, jSONObject, "enable_omid");
        if (!(jSONObject == null || jSONObject.optJSONObject("overlay") == null)) {
            z = true;
        }
        this.zzfxk = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcco
    public final JSONObject zzalr() {
        JSONObject jSONObject = this.zzfxj;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzfxi.zzdrn);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcco
    public final boolean zzals() {
        return this.zzfxk;
    }

    @Override // com.google.android.gms.internal.ads.zzcco
    public final boolean zzalt() {
        return this.zzdit;
    }

    @Override // com.google.android.gms.internal.ads.zzcco
    public final boolean zzalc() {
        return this.zzdse;
    }

    @Override // com.google.android.gms.internal.ads.zzcco
    public final boolean zzalu() {
        return this.zzdis;
    }
}
