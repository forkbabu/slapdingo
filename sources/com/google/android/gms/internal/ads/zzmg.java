package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzmg extends zzml {
    public static final Parcelable.Creator<zzmg> CREATOR = new zzmj();
    public final String description;
    public final String text;
    private final String zzahn;

    public zzmg(String str, String str2, String str3) {
        super("COMM");
        this.zzahn = str;
        this.description = str2;
        this.text = str3;
    }

    zzmg(Parcel parcel) {
        super("COMM");
        this.zzahn = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmg zzmg = (zzmg) obj;
            return zzpo.zza(this.description, zzmg.description) && zzpo.zza(this.zzahn, zzmg.zzahn) && zzpo.zza(this.text, zzmg.text);
        }
    }

    public final int hashCode() {
        String str = this.zzahn;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + MetaDo.META_OFFSETWINDOWORG) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagr);
        parcel.writeString(this.zzahn);
        parcel.writeString(this.text);
    }
}
