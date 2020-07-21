package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzvj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvj> CREATOR = new zzvm();
    public final int type;
    public final int zzacz;
    public final String zzada;
    public final long zzadb;

    public zzvj(int i, int i2, String str, long j) {
        this.type = i;
        this.zzacz = i2;
        this.zzada = str;
        this.zzadb = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.type);
        SafeParcelWriter.writeInt(parcel, 2, this.zzacz);
        SafeParcelWriter.writeString(parcel, 3, this.zzada, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzadb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static zzvj zza(JSONObject jSONObject) throws JSONException {
        return new zzvj(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), jSONObject.getLong("value"));
    }
}
