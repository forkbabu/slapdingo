package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaso extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaso> CREATOR = new zzasn();
    String zzdsv;

    public zzaso(String str) {
        this.zzdsv = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdsv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
