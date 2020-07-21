package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdqs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdqs> CREATOR = new zzdqr();
    private final int versionCode;
    private final byte[] zzhja;

    zzdqs(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzhja = bArr;
    }

    public zzdqs(byte[] bArr) {
        this(1, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhja, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
