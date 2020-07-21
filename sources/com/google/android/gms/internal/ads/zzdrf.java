package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdrf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdrf> CREATOR = new zzdri();
    public final int status;
    private final int versionCode;
    public final byte[] zzhjq;

    zzdrf(int i, byte[] bArr, int i2) {
        byte[] bArr2;
        this.versionCode = i;
        if (bArr == null) {
            bArr2 = null;
        } else {
            bArr2 = Arrays.copyOf(bArr, bArr.length);
        }
        this.zzhjq = bArr2;
        this.status = i2;
    }

    public zzdrf(byte[] bArr, int i) {
        this(1, null, 1);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhjq, false);
        SafeParcelWriter.writeInt(parcel, 3, this.status);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
