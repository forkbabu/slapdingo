package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbmg implements Runnable {
    private final JSONObject zzflz;
    private final zzbmh zzfmm;

    zzbmg(zzbmh zzbmh, JSONObject jSONObject) {
        this.zzfmm = zzbmh;
        this.zzflz = jSONObject;
    }

    public final void run() {
        this.zzfmm.zzi(this.zzflz);
    }
}
