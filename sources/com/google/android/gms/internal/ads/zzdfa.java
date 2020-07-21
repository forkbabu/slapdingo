package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfa implements zzdec<zzdex> {
    private final String packageName;
    private final zzdvi zzgad;
    private final zzasp zzgvf;
    private final Context zzvr;

    public zzdfa(zzasp zzasp, Context context, String str, zzdvi zzdvi) {
        this.zzgvf = zzasp;
        this.zzvr = context;
        this.packageName = str;
        this.zzgad = zzdvi;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdex> zzaqm() {
        return this.zzgad.zze(new zzdez(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdex zzarf() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzasp zzasp = this.zzgvf;
        if (zzasp != null) {
            zzasp.zza(this.zzvr, this.packageName, jSONObject);
        }
        return new zzdex(jSONObject);
    }
}
