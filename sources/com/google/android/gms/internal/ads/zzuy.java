package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzuy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuy> CREATOR = new zzux();
    public final int errorCode;
    public final String zzcgo;
    public final String zzcgp;

    public zzuy(int i, String str, String str2) {
        this.errorCode = i;
        this.zzcgo = str;
        this.zzcgp = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.errorCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgo, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcgp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
