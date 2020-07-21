package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaho extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaho> CREATOR = new zzahr();
    private final String url;
    private final String[] zzdel;
    private final String[] zzdem;

    zzaho(String str, String[] strArr, String[] strArr2) {
        this.url = str;
        this.zzdel = strArr;
        this.zzdem = strArr2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzdel, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzdem, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static zzaho zzh(zzaa<?> zzaa) throws zzl {
        Map<String, String> headers = zzaa.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new zzaho(zzaa.getUrl(), strArr, strArr2);
    }
}
