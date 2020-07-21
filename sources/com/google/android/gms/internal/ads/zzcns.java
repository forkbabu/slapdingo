package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcns {
    private final Executor executor;
    private final zzdla zzfpv;
    private final zzbbd zzghe;
    private final Context zzvr;

    public zzcns(Context context, zzbbd zzbbd, zzdla zzdla, Executor executor2) {
        this.zzvr = context;
        this.zzghe = zzbbd;
        this.zzfpv = zzdla;
        this.executor = executor2;
    }

    public final zzdvf<zzdkw> zzapd() {
        zzalj zza = zzq.zzlj().zzb(this.zzvr, this.zzghe).zza("google.afma.response.normalize", zzalm.zzdhf, zzalm.zzdhf);
        return zzdux.zzb(zzdux.zzb(zzdux.zzb(zzdux.zzaf(""), new zzcnv(this, this.zzfpv.zzhay.zzchg), this.executor), new zzcnu(zza), this.executor), new zzcnx(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzo(JSONObject jSONObject) throws Exception {
        return zzdux.zzaf(new zzdkw(new zzdkr(this.zzfpv), zzdku.zza(new StringReader(jSONObject.toString()))));
    }
}
