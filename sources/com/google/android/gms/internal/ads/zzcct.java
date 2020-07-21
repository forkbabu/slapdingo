package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcct implements zzela<zzccr> {
    private final zzelj<JSONObject> zzetu;
    private final zzelj<zzdkk> zzfmg;

    public zzcct(zzelj<zzdkk> zzelj, zzelj<JSONObject> zzelj2) {
        this.zzfmg = zzelj;
        this.zzetu = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzccr(this.zzfmg.get(), this.zzetu.get());
    }
}
