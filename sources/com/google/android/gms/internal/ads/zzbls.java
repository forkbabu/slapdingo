package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.html.HtmlTags;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbls implements zzalk<zzblw> {
    private final PowerManager zzaai;
    private final zzqn zzflj;
    private final Context zzvr;

    public zzbls(Context context, zzqn zzqn) {
        this.zzvr = context;
        this.zzflj = zzqn;
        this.zzaai = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzj(zzblw zzblw) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (zzblw.zzfly == null) {
            jSONObject = new JSONObject();
        } else {
            zzqt zzqt = zzblw.zzfly;
            if (this.zzflj.zzkt() != null) {
                boolean z2 = zzqt.zzbrm;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject put = jSONObject3.put("afmaVersion", this.zzflj.zzks()).put("activeViewJSON", this.zzflj.zzkt()).put("timestamp", zzblw.timestamp).put("adFormat", this.zzflj.zzkr()).put("hashCode", this.zzflj.getUniqueId()).put("isMraid", false).put("isStopped", false).put("isPaused", zzblw.zzflv).put("isNative", this.zzflj.isNative());
                if (Build.VERSION.SDK_INT >= 20) {
                    z = this.zzaai.isInteractive();
                } else {
                    z = this.zzaai.isScreenOn();
                }
                put.put("isScreenOn", z).put("appMuted", zzq.zzlb().zzqd()).put("appVolume", (double) zzq.zzlb().zzqc()).put("deviceVolume", (double) zzayw.zzbi(this.zzvr.getApplicationContext()));
                Rect rect = new Rect();
                Display defaultDisplay = ((WindowManager) this.zzvr.getSystemService("window")).getDefaultDisplay();
                rect.right = defaultDisplay.getWidth();
                rect.bottom = defaultDisplay.getHeight();
                jSONObject3.put("windowVisibility", zzqt.zzaap).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzqt.zzbrn.top).put(HtmlTags.ALIGN_BOTTOM, zzqt.zzbrn.bottom).put(HtmlTags.ALIGN_LEFT, zzqt.zzbrn.left).put(HtmlTags.ALIGN_RIGHT, zzqt.zzbrn.right)).put("adBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzqt.zzbro.top).put(HtmlTags.ALIGN_BOTTOM, zzqt.zzbro.bottom).put(HtmlTags.ALIGN_LEFT, zzqt.zzbro.left).put(HtmlTags.ALIGN_RIGHT, zzqt.zzbro.right)).put("globalVisibleBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzqt.zzbrp.top).put(HtmlTags.ALIGN_BOTTOM, zzqt.zzbrp.bottom).put(HtmlTags.ALIGN_LEFT, zzqt.zzbrp.left).put(HtmlTags.ALIGN_RIGHT, zzqt.zzbrp.right)).put("globalVisibleBoxVisible", zzqt.zzbrq).put("localVisibleBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzqt.zzbrr.top).put(HtmlTags.ALIGN_BOTTOM, zzqt.zzbrr.bottom).put(HtmlTags.ALIGN_LEFT, zzqt.zzbrr.left).put(HtmlTags.ALIGN_RIGHT, zzqt.zzbrr.right)).put("localVisibleBoxVisible", zzqt.zzbrs).put("hitBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzqt.zzbrt.top).put(HtmlTags.ALIGN_BOTTOM, zzqt.zzbrt.bottom).put(HtmlTags.ALIGN_LEFT, zzqt.zzbrt.left).put(HtmlTags.ALIGN_RIGHT, zzqt.zzbrt.right)).put("screenDensity", (double) this.zzvr.getResources().getDisplayMetrics().density);
                jSONObject3.put("isVisible", zzblw.zzbrd);
                if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcpl)).booleanValue()) {
                    JSONArray jSONArray2 = new JSONArray();
                    if (zzqt.zzbrv != null) {
                        for (Rect rect2 : zzqt.zzbrv) {
                            jSONArray2.put(new JSONObject().put(HtmlTags.ALIGN_TOP, rect2.top).put(HtmlTags.ALIGN_BOTTOM, rect2.bottom).put(HtmlTags.ALIGN_LEFT, rect2.left).put(HtmlTags.ALIGN_RIGHT, rect2.right));
                        }
                    }
                    jSONObject3.put("scrollableContainerBoxes", jSONArray2);
                }
                if (!TextUtils.isEmpty(zzblw.zzflx)) {
                    jSONObject3.put("doneReasonCode", HtmlTags.U);
                }
                jSONObject = jSONObject3;
            } else {
                throw new JSONException("Active view Info cannot be null.");
            }
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
