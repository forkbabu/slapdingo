package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpt implements Parcelable {
    public static final Parcelable.Creator<zzpt> CREATOR = new zzps();
    private int zzahp;
    public final int zzarn;
    public final int zzaro;
    public final int zzarp;
    public final byte[] zzbkk;

    public zzpt(int i, int i2, int i3, byte[] bArr) {
        this.zzarn = i;
        this.zzarp = i2;
        this.zzaro = i3;
        this.zzbkk = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    zzpt(Parcel parcel) {
        this.zzarn = parcel.readInt();
        this.zzarp = parcel.readInt();
        this.zzaro = parcel.readInt();
        this.zzbkk = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzpt zzpt = (zzpt) obj;
            return this.zzarn == zzpt.zzarn && this.zzarp == zzpt.zzarp && this.zzaro == zzpt.zzaro && Arrays.equals(this.zzbkk, zzpt.zzbkk);
        }
    }

    public final String toString() {
        int i = this.zzarn;
        int i2 = this.zzarp;
        int i3 = this.zzaro;
        boolean z = this.zzbkk != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.zzahp == 0) {
            this.zzahp = ((((((this.zzarn + MetaDo.META_OFFSETWINDOWORG) * 31) + this.zzarp) * 31) + this.zzaro) * 31) + Arrays.hashCode(this.zzbkk);
        }
        return this.zzahp;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzarn);
        parcel.writeInt(this.zzarp);
        parcel.writeInt(this.zzaro);
        parcel.writeInt(this.zzbkk != null ? 1 : 0);
        byte[] bArr = this.zzbkk;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
