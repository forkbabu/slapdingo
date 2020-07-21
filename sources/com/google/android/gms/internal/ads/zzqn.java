package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzqn {
    private final String zzbpk;
    private final JSONObject zzbpl;
    private final String zzbpm;
    private final String zzbpn;
    private final boolean zzbpo = false;
    private final boolean zzbpp;

    public zzqn(String str, zzbbd zzbbd, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzbpn = zzbbd.zzbpn;
        this.zzbpl = jSONObject;
        this.zzbpm = str;
        this.zzbpk = str2;
        this.zzbpp = z2;
    }

    public final String zzkr() {
        return this.zzbpk;
    }

    public final String zzks() {
        return this.zzbpn;
    }

    public final JSONObject zzkt() {
        return this.zzbpl;
    }

    public final String getUniqueId() {
        return this.zzbpm;
    }

    public final boolean isNative() {
        return this.zzbpp;
    }
}
