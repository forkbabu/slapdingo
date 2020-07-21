package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzuw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuw> CREATOR = new zzuv();
    public final String zzcgm;
    public final String zzcgn;

    public zzuw(String str, String str2) {
        this.zzcgm = str;
        this.zzcgn = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcgm, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgn, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
