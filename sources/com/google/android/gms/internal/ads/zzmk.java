package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzmk extends zzml {
    public static final Parcelable.Creator<zzmk> CREATOR = new zzmn();
    private final String description;
    private final String value;

    public zzmk(String str, String str2, String str3) {
        super(str);
        this.description = null;
        this.value = str3;
    }

    zzmk(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmk zzmk = (zzmk) obj;
            return this.zzagr.equals(zzmk.zzagr) && zzpo.zza(this.description, zzmk.description) && zzpo.zza(this.value, zzmk.value);
        }
    }

    public final int hashCode() {
        int hashCode = (this.zzagr.hashCode() + MetaDo.META_OFFSETWINDOWORG) * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagr);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}
