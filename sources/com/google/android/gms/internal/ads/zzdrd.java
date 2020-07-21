package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdrd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdrd> CREATOR = new zzdrg();
    private final int versionCode;
    private final String zzhhz;
    private final String zzhia;
    private final int zzhib;
    private final int zzhjp;

    zzdrd(int i, int i2, int i3, String str, String str2) {
        this.versionCode = i;
        this.zzhib = i2;
        this.zzhhz = str;
        this.zzhia = str2;
        this.zzhjp = i3;
    }

    public zzdrd(int i, zzgo zzgo, String str, String str2) {
        this(1, i, zzgo.zzw(), str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhib);
        SafeParcelWriter.writeString(parcel, 3, this.zzhhz, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhia, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzhjp);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
