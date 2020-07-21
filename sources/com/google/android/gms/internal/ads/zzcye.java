package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcye implements zzdrx {
    static final zzdrx zzdvt = new zzcye();

    private zzcye() {
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        return ((JSONObject) obj).optString("nas");
    }
}
