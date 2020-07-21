package com.google.android.gms.internal.ads;

import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbsg extends zzyg {
    private final String zzfrl;
    private final String zzfrm;

    public zzbsg(zzdkk zzdkk, String str) {
        String str2;
        String str3 = null;
        if (zzdkk == null) {
            str2 = null;
        } else {
            str2 = zzdkk.zzfrm;
        }
        this.zzfrm = str2;
        str3 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzc(zzdkk) : str3;
        this.zzfrl = str3 != null ? str3 : str;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final String getMediationAdapterClassName() {
        return this.zzfrl;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final String getResponseId() {
        return this.zzfrm;
    }

    private static String zzc(zzdkk zzdkk) {
        try {
            return zzdkk.zzgzu.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }
}
