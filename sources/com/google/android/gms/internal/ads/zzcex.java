package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.text.html.HtmlTags;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcex implements Callable {
    private final zzdkk zzfnu;
    private final zzceu zzgag;
    private final zzdkw zzgao;
    private final JSONObject zzgap;

    zzcex(zzceu zzceu, zzdkw zzdkw, zzdkk zzdkk, JSONObject jSONObject) {
        this.zzgag = zzceu;
        this.zzgao = zzdkw;
        this.zzfnu = zzdkk;
        this.zzgap = jSONObject;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzdkw zzdkw = this.zzgao;
        zzdkk zzdkk = this.zzfnu;
        JSONObject jSONObject = this.zzgap;
        zzcck zzcck = new zzcck();
        zzcck.zzdw(jSONObject.optInt("template_id", -1));
        zzcck.zzfz(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzcck.zzga(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzdla zzdla = zzdkw.zzhat.zzfpv;
        if (zzdla.zzhba.contains(Integer.toString(zzcck.zzalg()))) {
            if (zzcck.zzalg() == 3) {
                if (zzcck.getCustomTemplateId() == null) {
                    throw new zzctw(zzdls.zzhbq, "No custom template id for custom template ad response.");
                } else if (!zzdla.zzhbb.contains(zzcck.getCustomTemplateId())) {
                    throw new zzctw(zzdls.zzhbq, "Unexpected custom template id in the response.");
                }
            }
            zzcck.setStarRating(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", null);
            if (zzdkk.zzdub) {
                zzq.zzkw();
                String zzxm = zzaye.zzxm();
                StringBuilder sb = new StringBuilder(String.valueOf(zzxm).length() + 3 + String.valueOf(optString).length());
                sb.append(zzxm);
                sb.append(" : ");
                sb.append(optString);
                optString = sb.toString();
            }
            zzcck.zzn("headline", optString);
            zzcck.zzn(HtmlTags.BODY, jSONObject.optString(HtmlTags.BODY, null));
            zzcck.zzn("call_to_action", jSONObject.optString("call_to_action", null));
            zzcck.zzn("store", jSONObject.optString("store", null));
            zzcck.zzn(FirebaseAnalytics.Param.PRICE, jSONObject.optString(FirebaseAnalytics.Param.PRICE, null));
            zzcck.zzn("advertiser", jSONObject.optString("advertiser", null));
            return zzcck;
        }
        int i = zzdls.zzhbq;
        int zzalg = zzcck.zzalg();
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid template ID: ");
        sb2.append(zzalg);
        throw new zzctw(i, sb2.toString());
    }
}
