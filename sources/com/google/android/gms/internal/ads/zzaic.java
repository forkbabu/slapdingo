package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaic extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaic> CREATOR = new zzaif();
    public final String description;
    public final String zzder;
    public final boolean zzdes;
    public final int zzdet;

    public zzaic(String str, boolean z, int i, String str2) {
        this.zzder = str;
        this.zzdes = z;
        this.zzdet = i;
        this.description = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzder, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdes);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdet);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
