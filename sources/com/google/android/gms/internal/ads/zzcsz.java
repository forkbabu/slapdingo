package com.google.android.gms.internal.ads;

import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcsz implements zzduh {
    private final zzdkk zzfnu;
    private final zzdkw zzgao;
    private final zzcsx zzglt;

    zzcsz(zzcsx zzcsx, zzdkw zzdkw, zzdkk zzdkk) {
        this.zzglt = zzcsx;
        this.zzgao = zzdkw;
        this.zzfnu = zzdkk;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        return this.zzglt.zza(this.zzgao, this.zzfnu, (JSONArray) obj);
    }
}
