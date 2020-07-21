package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcva implements zzcqu<zzaox, zzcsd> {
    private final zzcwh zzgnj;

    public zzcva(zzcwh zzcwh) {
        this.zzgnj = zzcwh;
    }

    @Override // com.google.android.gms.internal.ads.zzcqu
    public final zzcqv<zzaox, zzcsd> zzf(String str, JSONObject jSONObject) throws zzdlg {
        zzaox zzgo = this.zzgnj.zzgo(str);
        if (zzgo == null) {
            return null;
        }
        return new zzcqv<>(zzgo, new zzcsd(), str);
    }
}
