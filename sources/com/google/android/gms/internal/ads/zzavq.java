package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzavq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzavq> CREATOR = new zzavp();
    public final String zzdvu;
    public final String zzdvv;
    public final boolean zzdvw;
    public final boolean zzdvx;
    public final List<String> zzdvy;
    public final boolean zzdvz;
    public final boolean zzdwa;
    public final List<String> zzdwb;

    public zzavq(String str, String str2, boolean z, boolean z2, List<String> list, boolean z3, boolean z4, List<String> list2) {
        this.zzdvu = str;
        this.zzdvv = str2;
        this.zzdvw = z;
        this.zzdvx = z2;
        this.zzdvy = list;
        this.zzdvz = z3;
        this.zzdwa = z4;
        this.zzdwb = list2 == null ? new ArrayList<>() : list2;
    }

    public static zzavq zzg(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzavq(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzazy.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzazy.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdvu, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdvv, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdvw);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdvx);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdvy, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzdvz);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdwa);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzdwb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
