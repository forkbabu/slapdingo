package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbt implements zzela<JSONObject> {
    private final zzcbr zzfvs;

    public zzcbt(zzcbr zzcbr) {
        this.zzfvs = zzcbr;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (JSONObject) zzelg.zza(this.zzfvs.zzaky(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
