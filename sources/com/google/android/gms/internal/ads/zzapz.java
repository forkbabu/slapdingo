package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzapz {
    private final boolean zzdmn;
    private final boolean zzdmo;
    private final boolean zzdmp;
    private final boolean zzdmq;
    private final boolean zzdmr;

    private zzapz(zzaqb zzaqb) {
        this.zzdmn = zzaqb.zzdmn;
        this.zzdmo = zzaqb.zzdmo;
        this.zzdmp = zzaqb.zzdmp;
        this.zzdmq = zzaqb.zzdmq;
        this.zzdmr = zzaqb.zzdmr;
    }

    public final JSONObject zzug() {
        try {
            return new JSONObject().put("sms", this.zzdmn).put("tel", this.zzdmo).put("calendar", this.zzdmp).put("storePicture", this.zzdmq).put("inlineVideo", this.zzdmr);
        } catch (JSONException e) {
            zzaxv.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
