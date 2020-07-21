package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdkk {
    public final String zzagr;
    public final boolean zzbor;
    public final List<String> zzdif;
    public final List<String> zzdig;
    public final String zzdil;
    public final boolean zzdis;
    public final boolean zzdit;
    public final boolean zzdiu;
    public final String zzdjb;
    public final String zzdjm;
    public final String zzdjn;
    public final String zzdla;
    public final List<String> zzdrh;
    public final String zzdrk;
    public final String zzdrn;
    public final zzaub zzdru;
    public final List<String> zzdrv;
    public final List<String> zzdrw;
    public final boolean zzdse;
    public final boolean zzdsh;
    public final boolean zzdsi;
    public final boolean zzdub;
    public final boolean zzene;
    public final String zzepm;
    public final int zzfmv;
    public final boolean zzfmw;
    public final boolean zzfmx;
    public final String zzfrm;
    public final List<String> zzgzk;
    public final int zzgzl;
    public final int zzgzm;
    public final List<String> zzgzn;
    public final List<String> zzgzo;
    public final List<String> zzgzp;
    public final List<zzdkj> zzgzq;
    public final zzdko zzgzr;
    public final List<String> zzgzs;
    public final List<zzdkj> zzgzt;
    public final JSONObject zzgzu;
    public final zzavq zzgzv;
    public final JSONObject zzgzw;
    public final JSONObject zzgzx;
    public final boolean zzgzy;
    public final int zzgzz;
    public final int zzhaa;
    public final JSONObject zzhab;
    public final int zzhac;
    public final boolean zzhad;
    public final zzaqn zzhae;
    public final zzvj zzhaf;
    public final String zzhag;
    public final String zzhah;

    zzdkk(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String str;
        JSONObject jSONObject;
        char c;
        List<zzdkj> list;
        List<String> emptyList = Collections.emptyList();
        List<String> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        List<String> emptyList4 = Collections.emptyList();
        List<String> emptyList5 = Collections.emptyList();
        Collections.emptyList();
        List<String> emptyList6 = Collections.emptyList();
        List<String> emptyList7 = Collections.emptyList();
        List<String> emptyList8 = Collections.emptyList();
        List<String> emptyList9 = Collections.emptyList();
        List<zzdkj> emptyList10 = Collections.emptyList();
        List<String> emptyList11 = Collections.emptyList();
        List<zzdkj> emptyList12 = Collections.emptyList();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        jsonReader.beginObject();
        String str2 = "";
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        String str13 = str12;
        JSONObject jSONObject6 = jSONObject3;
        JSONObject jSONObject7 = jSONObject4;
        JSONObject jSONObject8 = jSONObject5;
        zzaub zzaub = null;
        zzdko zzdko = null;
        zzavq zzavq = null;
        zzaqn zzaqn = null;
        zzvj zzvj = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i3 = -1;
        int i4 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        int i5 = 0;
        boolean z11 = false;
        int i6 = -1;
        boolean z12 = false;
        boolean z13 = true;
        List<zzdkj> list2 = emptyList12;
        JSONObject jSONObject9 = jSONObject2;
        List<zzdkj> list3 = emptyList10;
        List<String> list4 = emptyList11;
        List<String> list5 = emptyList8;
        List<String> list6 = emptyList9;
        List<String> list7 = emptyList6;
        List<String> list8 = emptyList7;
        List<String> list9 = emptyList4;
        List<String> list10 = emptyList5;
        List<String> list11 = emptyList2;
        List<String> list12 = emptyList3;
        List<String> list13 = emptyList;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName == null) {
                str = "";
            } else {
                str = nextName;
            }
            switch (str.hashCode()) {
                case -1980587809:
                    jSONObject = jSONObject9;
                    if (str.equals("debug_signals")) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case -1965512151:
                    jSONObject = jSONObject9;
                    if (str.equals("omid_settings")) {
                        c = '\'';
                        break;
                    }
                    c = 65535;
                    break;
                case -1812055556:
                    jSONObject = jSONObject9;
                    if (str.equals("play_prewarm_options")) {
                        c = '0';
                        break;
                    }
                    c = 65535;
                    break;
                case -1620470467:
                    jSONObject = jSONObject9;
                    if (str.equals("backend_query_id")) {
                        c = '.';
                        break;
                    }
                    c = 65535;
                    break;
                case -1440104884:
                    jSONObject = jSONObject9;
                    if (str.equals("is_custom_close_blocked")) {
                        c = '!';
                        break;
                    }
                    c = 65535;
                    break;
                case -1439500848:
                    jSONObject = jSONObject9;
                    if (str.equals("orientation")) {
                        c = '#';
                        break;
                    }
                    c = 65535;
                    break;
                case -1428969291:
                    jSONObject = jSONObject9;
                    if (str.equals("enable_omid")) {
                        c = '%';
                        break;
                    }
                    c = 65535;
                    break;
                case -1403779768:
                    jSONObject = jSONObject9;
                    if (str.equals("showable_impression_type")) {
                        c = '*';
                        break;
                    }
                    c = 65535;
                    break;
                case -1360811658:
                    jSONObject = jSONObject9;
                    if (str.equals("ad_sizes")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -1306015996:
                    jSONObject = jSONObject9;
                    if (str.equals("adapters")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case -1303332046:
                    jSONObject = jSONObject9;
                    if (str.equals("test_mode_enabled")) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                case -1289032093:
                    jSONObject = jSONObject9;
                    if (str.equals("extras")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case -1240082064:
                    jSONObject = jSONObject9;
                    if (str.equals("ad_event_value")) {
                        c = PdfWriter.VERSION_1_2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1234181075:
                    jSONObject = jSONObject9;
                    if (str.equals("allow_pub_rendered_attribution")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case -1181000426:
                    jSONObject = jSONObject9;
                    if (str.equals("is_augmented_reality_ad")) {
                        c = '+';
                        break;
                    }
                    c = 65535;
                    break;
                case -1152230954:
                    jSONObject = jSONObject9;
                    if (str.equals("ad_type")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1146534047:
                    jSONObject = jSONObject9;
                    if (str.equals("is_scroll_aware")) {
                        c = ')';
                        break;
                    }
                    c = 65535;
                    break;
                case -1115838944:
                    jSONObject = jSONObject9;
                    if (str.equals("fill_urls")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1081936678:
                    jSONObject = jSONObject9;
                    if (str.equals("allocation_id")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case -1078050970:
                    jSONObject = jSONObject9;
                    if (str.equals("video_complete_urls")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1051269058:
                    jSONObject = jSONObject9;
                    if (str.equals("active_view")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case -982608540:
                    jSONObject = jSONObject9;
                    if (str.equals("valid_from_timestamp")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -776859333:
                    jSONObject = jSONObject9;
                    if (str.equals("click_urls")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -544216775:
                    jSONObject = jSONObject9;
                    if (str.equals("safe_browsing")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case -437057161:
                    jSONObject = jSONObject9;
                    if (str.equals("imp_urls")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -404326515:
                    jSONObject = jSONObject9;
                    if (str.equals("render_timeout_ms")) {
                        c = Typography.dollar;
                        break;
                    }
                    c = 65535;
                    break;
                case -397704715:
                    jSONObject = jSONObject9;
                    if (str.equals("ad_close_time_ms")) {
                        c = ',';
                        break;
                    }
                    c = 65535;
                    break;
                case -369773488:
                    jSONObject = jSONObject9;
                    if (str.equals("is_close_button_enabled")) {
                        c = '1';
                        break;
                    }
                    c = 65535;
                    break;
                case -213424028:
                    jSONObject = jSONObject9;
                    if (str.equals("watermark")) {
                        c = '-';
                        break;
                    }
                    c = 65535;
                    break;
                case -29338502:
                    jSONObject = jSONObject9;
                    if (str.equals("allow_custom_click_gesture")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 3107:
                    jSONObject = jSONObject9;
                    if (str.equals("ad")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    jSONObject = jSONObject9;
                    if (str.equals("id")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 3076010:
                    jSONObject = jSONObject9;
                    if (str.equals("data")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 63195984:
                    jSONObject = jSONObject9;
                    if (str.equals("render_test_label")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case 107433883:
                    jSONObject = jSONObject9;
                    if (str.equals("qdata")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 230323073:
                    jSONObject = jSONObject9;
                    if (str.equals("ad_load_urls")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 418392395:
                    jSONObject = jSONObject9;
                    if (str.equals("is_closable_area_disabled")) {
                        c = Typography.quote;
                        break;
                    }
                    c = 65535;
                    break;
                case 597473788:
                    jSONObject = jSONObject9;
                    if (str.equals("debug_dialog_string")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 673261304:
                    jSONObject = jSONObject9;
                    if (str.equals("reward_granted_urls")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 754887508:
                    jSONObject = jSONObject9;
                    if (str.equals("container_sizes")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 791122864:
                    jSONObject = jSONObject9;
                    if (str.equals("impression_type")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 942228154:
                    jSONObject = jSONObject9;
                    if (str.equals("native_ad_policy_validator_overlay_url")) {
                        c = PdfWriter.VERSION_1_4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1010584092:
                    jSONObject = jSONObject9;
                    if (str.equals(FirebaseAnalytics.Param.TRANSACTION_ID)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1100650276:
                    jSONObject = jSONObject9;
                    if (str.equals("rewards")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 1321720943:
                    jSONObject = jSONObject9;
                    if (str.equals("allow_pub_owned_ad_view")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1637553475:
                    jSONObject = jSONObject9;
                    if (str.equals("bid_response")) {
                        c = Typography.amp;
                        break;
                    }
                    c = 65535;
                    break;
                case 1638957285:
                    jSONObject = jSONObject9;
                    if (str.equals("video_start_urls")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1688341040:
                    jSONObject = jSONObject9;
                    if (str.equals("video_reward_urls")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1799285870:
                    jSONObject = jSONObject9;
                    if (str.equals("use_third_party_container_height")) {
                        c = '/';
                        break;
                    }
                    c = 65535;
                    break;
                case 1839650832:
                    jSONObject = jSONObject9;
                    if (str.equals("renderers")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1875425491:
                    jSONObject = jSONObject9;
                    if (str.equals("is_analytics_logging_enabled")) {
                        c = '(';
                        break;
                    }
                    c = 65535;
                    break;
                case 2068142375:
                    jSONObject = jSONObject9;
                    if (str.equals("rule_line_external_id")) {
                        c = PdfWriter.VERSION_1_3;
                        break;
                    }
                    c = 65535;
                    break;
                case 2072888499:
                    jSONObject = jSONObject9;
                    if (str.equals("manual_tracking_urls")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    jSONObject = jSONObject9;
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    list = list2;
                    list13 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case 1:
                    list = list2;
                    String nextString = jsonReader.nextString();
                    if ("banner".equals(nextString)) {
                        i = 1;
                    } else if ("interstitial".equals(nextString)) {
                        i = 2;
                    } else if ("native_express".equals(nextString)) {
                        i = 3;
                    } else if ("native".equals(nextString)) {
                        i = 4;
                    } else {
                        i = "rewarded".equals(nextString) ? 5 : 0;
                    }
                    list2 = list;
                    break;
                case 2:
                    list = list2;
                    list11 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case 3:
                    list = list2;
                    list12 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case 4:
                    list = list2;
                    list9 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case 5:
                    list = list2;
                    int nextInt = jsonReader.nextInt();
                    i2 = (nextInt == 0 || nextInt == 1) ? nextInt : 0;
                    list2 = list;
                    break;
                case 6:
                    list = list2;
                    list10 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case 7:
                    list = list2;
                    zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case '\b':
                    list = list2;
                    list7 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case '\t':
                    list = list2;
                    list8 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case '\n':
                    list = list2;
                    str2 = jsonReader.nextString();
                    list2 = list;
                    break;
                case 11:
                    list = list2;
                    str3 = jsonReader.nextString();
                    list2 = list;
                    break;
                case '\f':
                    list = list2;
                    zzaub = zzaub.zza(zzazy.zzd(jsonReader));
                    list2 = list;
                    break;
                case '\r':
                    list = list2;
                    list5 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case 14:
                    list = list2;
                    list6 = zzazy.zza(jsonReader);
                    list2 = list;
                    break;
                case 15:
                    list = list2;
                    list3 = zzdkj.zze(jsonReader);
                    list2 = list;
                    break;
                case 16:
                    list = list2;
                    zzdko = new zzdko(jsonReader);
                    list2 = list;
                    break;
                case 17:
                    list2 = zzdkj.zze(jsonReader);
                    break;
                case 18:
                    list4 = zzazy.zza(jsonReader);
                    break;
                case 19:
                    str4 = jsonReader.nextString();
                    break;
                case 20:
                    jSONObject9 = zzazy.zzc(jsonReader);
                    continue;
                case 21:
                    str5 = jsonReader.nextString();
                    break;
                case 22:
                    str6 = jsonReader.nextString();
                    break;
                case 23:
                    str7 = zzazy.zzc(jsonReader).toString();
                    break;
                case 24:
                    zzavq = zzavq.zzg(zzazy.zzc(jsonReader));
                    break;
                case 25:
                    str8 = jsonReader.nextString();
                    break;
                case 26:
                    jSONObject6 = zzazy.zzc(jsonReader);
                    break;
                case 27:
                    jSONObject7 = zzazy.zzc(jsonReader);
                    break;
                case 28:
                    z = jsonReader.nextBoolean();
                    break;
                case 29:
                    z2 = jsonReader.nextBoolean();
                    break;
                case 30:
                    z3 = jsonReader.nextBoolean();
                    break;
                case 31:
                    z4 = jsonReader.nextBoolean();
                    break;
                case ' ':
                    z5 = jsonReader.nextBoolean();
                    break;
                case '!':
                    z6 = jsonReader.nextBoolean();
                    break;
                case '\"':
                    z7 = jsonReader.nextBoolean();
                    break;
                case '#':
                    list = list2;
                    String nextString2 = jsonReader.nextString();
                    if ("landscape".equalsIgnoreCase(nextString2)) {
                        zzq.zzky();
                        i3 = 6;
                    } else if ("portrait".equalsIgnoreCase(nextString2)) {
                        zzq.zzky();
                        i3 = 7;
                    } else {
                        i3 = -1;
                    }
                    list2 = list;
                    break;
                case '$':
                    i4 = jsonReader.nextInt();
                    break;
                case '%':
                    z8 = jsonReader.nextBoolean();
                    break;
                case '&':
                    str9 = jsonReader.nextString();
                    break;
                case '\'':
                    jSONObject8 = zzazy.zzc(jsonReader);
                    break;
                case '(':
                    z9 = jsonReader.nextBoolean();
                    break;
                case ')':
                    z10 = jsonReader.nextBoolean();
                    break;
                case '*':
                    i5 = jsonReader.nextInt();
                    break;
                case '+':
                    z11 = jsonReader.nextBoolean();
                    break;
                case ',':
                    i6 = jsonReader.nextInt();
                    break;
                case '-':
                    str10 = jsonReader.nextString();
                    break;
                case '.':
                    str11 = jsonReader.nextString();
                    break;
                case '/':
                    z12 = jsonReader.nextBoolean();
                    break;
                case '0':
                    JSONObject zzc = zzazy.zzc(jsonReader);
                    if (zzc == null) {
                        list = list2;
                        zzaqn = null;
                    } else {
                        list = list2;
                        zzaqn = new zzaqn(zzc.optBoolean("enable_prewarming", false), zzc.optString("prefetch_url", ""));
                    }
                    list2 = list;
                    break;
                case '1':
                    z13 = jsonReader.nextBoolean();
                    break;
                case '2':
                    zzvj = zzvj.zza(zzazy.zzc(jsonReader));
                    break;
                case '3':
                    str12 = jsonReader.nextString();
                    break;
                case '4':
                    str13 = jsonReader.nextString();
                    break;
                default:
                    list = list2;
                    jsonReader.skipValue();
                    list2 = list;
                    break;
            }
            jSONObject9 = jSONObject;
        }
        jsonReader.endObject();
        this.zzgzk = list13;
        this.zzgzl = i;
        this.zzdif = list11;
        this.zzdig = list12;
        this.zzgzn = list9;
        this.zzgzm = i2;
        this.zzdrv = list10;
        this.zzdrw = list7;
        this.zzgzo = list8;
        this.zzdjm = str2;
        this.zzdjn = str3;
        this.zzdru = zzaub;
        this.zzgzp = list5;
        this.zzdrh = list6;
        this.zzgzq = list3;
        this.zzgzr = zzdko;
        this.zzgzs = list4;
        this.zzgzt = list2;
        this.zzdjb = str4;
        this.zzgzu = jSONObject9;
        this.zzagr = str5;
        this.zzdil = str6;
        this.zzdrn = str7;
        this.zzgzv = zzavq;
        this.zzdrk = str8;
        this.zzgzw = jSONObject6;
        this.zzgzx = jSONObject7;
        this.zzdis = z;
        this.zzdit = z2;
        this.zzdiu = z3;
        this.zzdub = z4;
        this.zzgzy = z5;
        this.zzfmx = z6;
        this.zzbor = z7;
        this.zzgzz = i3;
        this.zzhaa = i4;
        this.zzdse = z8;
        this.zzepm = str9;
        this.zzhab = jSONObject8;
        this.zzdsh = z9;
        this.zzdsi = z10;
        this.zzhac = i5;
        this.zzene = z11;
        this.zzdla = str10;
        this.zzfmv = i6;
        this.zzfrm = str11;
        this.zzhad = z12;
        this.zzhae = zzaqn;
        this.zzfmw = z13;
        this.zzhaf = zzvj;
        this.zzhag = str12;
        this.zzhah = str13;
    }
}
