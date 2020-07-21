package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzblx implements Runnable {
    private final zzbfn zzeot;
    private final JSONObject zzflz;

    zzblx(zzbfn zzbfn, JSONObject jSONObject) {
        this.zzeot = zzbfn;
        this.zzflz = jSONObject;
    }

    public final void run() {
        this.zzeot.zza("AFMA_updateActiveView", this.zzflz);
    }
}
