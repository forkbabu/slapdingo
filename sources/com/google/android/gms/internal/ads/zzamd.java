package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzamd<I, O> implements zzduh<I, O> {
    /* access modifiers changed from: private */
    public final zzall<O> zzdhl;
    private final zzalk<I> zzdhm;
    private final String zzdhn;
    private final zzdvf<zzalf> zzdhs;

    zzamd(zzdvf<zzalf> zzdvf, String str, zzalk<I> zzalk, zzall<O> zzall) {
        this.zzdhs = zzdvf;
        this.zzdhn = str;
        this.zzdhm = zzalk;
        this.zzdhl = zzall;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf<O> zzf(I i) throws Exception {
        return zzdux.zzb(this.zzdhs, new zzamc(this, i), zzbbf.zzedm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(Object obj, zzalf zzalf) throws Exception {
        zzbbn zzbbn = new zzbbn();
        zzq.zzkw();
        String zzxj = zzaye.zzxj();
        zzagm.zzddz.zza(zzxj, new zzamf(this, zzbbn));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzxj);
        jSONObject.put("args", this.zzdhm.zzj(obj));
        zzalf.zza(this.zzdhn, jSONObject);
        return zzbbn;
    }
}
