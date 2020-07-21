package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsv implements zzcqu<zzdlm, zzcsd> {
    private final zzcix zzgfm;

    public zzcsv(zzcix zzcix) {
        this.zzgfm = zzcix;
    }

    @Override // com.google.android.gms.internal.ads.zzcqu
    public final zzcqv<zzdlm, zzcsd> zzf(String str, JSONObject jSONObject) throws zzdlg {
        zzdlm zzd = this.zzgfm.zzd(str, jSONObject);
        if (zzd == null) {
            return null;
        }
        return new zzcqv<>(zzd, new zzcsd(), str);
    }
}
