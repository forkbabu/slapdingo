package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbma implements zzela<zzqn> {
    private final zzelj<JSONObject> zzetx;
    private final zzelj<zzdkk> zzfmg;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<String> zzfmi;

    private zzbma(zzelj<zzdkk> zzelj, zzelj<zzbbd> zzelj2, zzelj<JSONObject> zzelj3, zzelj<String> zzelj4) {
        this.zzfmg = zzelj;
        this.zzfmh = zzelj2;
        this.zzetx = zzelj3;
        this.zzfmi = zzelj4;
    }

    public static zzbma zza(zzelj<zzdkk> zzelj, zzelj<zzbbd> zzelj2, zzelj<JSONObject> zzelj3, zzelj<String> zzelj4) {
        return new zzbma(zzelj, zzelj2, zzelj3, zzelj4);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        this.zzfmg.get();
        zzbbd zzbbd = this.zzfmh.get();
        JSONObject jSONObject = this.zzetx.get();
        String str = this.zzfmi.get();
        boolean equals = "native".equals(str);
        zzq.zzkw();
        return (zzqn) zzelg.zza(new zzqn(zzaye.zzxj(), zzbbd, str, jSONObject, false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
