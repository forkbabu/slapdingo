package com.google.android.gms.internal.ads;

import com.itextpdf.text.html.HtmlTags;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzaqd {
    private final zzbfn zzdfp;
    private final String zzdmx;

    public zzaqd(zzbfn zzbfn) {
        this(zzbfn, "");
    }

    public zzaqd(zzbfn zzbfn, String str) {
        this.zzdfp = zzbfn;
        this.zzdmx = str;
    }

    public final void zzdw(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.zzdmx);
            if (this.zzdfp != null) {
                this.zzdfp.zzb("onError", put);
            }
        } catch (JSONException e) {
            zzaxv.zzc("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzdx(String str) {
        try {
            this.zzdfp.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzaxv.zzc("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzdfp.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put(HtmlTags.WIDTH, i3).put(HtmlTags.HEIGHT, i4));
        } catch (JSONException e) {
            zzaxv.zzc("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzdfp.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put(HtmlTags.WIDTH, i3).put(HtmlTags.HEIGHT, i4));
        } catch (JSONException e) {
            zzaxv.zzc("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzdy(String str) {
        try {
            this.zzdfp.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzaxv.zzc("Error occurred while dispatching state change.", e);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzdfp.zzb("onScreenInfoChanged", new JSONObject().put(HtmlTags.WIDTH, i).put(HtmlTags.HEIGHT, i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzaxv.zzc("Error occurred while obtaining screen information.", e);
        }
    }
}
