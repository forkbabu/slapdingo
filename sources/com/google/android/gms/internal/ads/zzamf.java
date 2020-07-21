package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzamf implements zzahk {
    private final zzbbn<O> zzdhu;
    private final /* synthetic */ zzamd zzdhx;

    public zzamf(zzamd zzamd, zzbbn<O> zzbbn) {
        this.zzdhx = zzamd;
        this.zzdhu = zzbbn;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdhu.set(this.zzdhx.zzdhl.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdhu.setException(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.zzdhu.setException(new zzalg());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzdhu.setException(new zzalg(str));
        }
    }
}
