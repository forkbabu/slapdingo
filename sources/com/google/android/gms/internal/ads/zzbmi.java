package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbmi implements zzela<JSONObject> {
    private final zzelj<zzdkk> zzfmg;

    private zzbmi(zzelj<zzdkk> zzelj) {
        this.zzfmg = zzelj;
    }

    public static zzbmi zzc(zzelj<zzdkk> zzelj) {
        return new zzbmi(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzbmj.zzb(this.zzfmg.get());
    }
}
