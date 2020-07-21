package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcta implements Callable {
    private final zzdvf zzfpl;
    private final zzdvf zzfrf;
    private final zzdkw zzglm;
    private final zzcsx zzglt;
    private final zzdkk zzgly;
    private final JSONObject zzglz;

    zzcta(zzcsx zzcsx, zzdvf zzdvf, zzdvf zzdvf2, zzdkw zzdkw, zzdkk zzdkk, JSONObject jSONObject) {
        this.zzglt = zzcsx;
        this.zzfrf = zzdvf;
        this.zzfpl = zzdvf2;
        this.zzglm = zzdkw;
        this.zzgly = zzdkk;
        this.zzglz = jSONObject;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzglt.zza(this.zzfrf, this.zzfpl, this.zzglm, this.zzgly, this.zzglz);
    }
}
