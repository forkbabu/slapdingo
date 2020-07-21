package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdqt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdqt> CREATOR = new zzdqw();
    private final String packageName;
    private final int versionCode;
    private final String zzhjb;

    zzdqt(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzhjb = str2;
    }

    public zzdqt(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhjb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
