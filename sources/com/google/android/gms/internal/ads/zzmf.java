package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzmf extends zzml {
    public static final Parcelable.Creator<zzmf> CREATOR = new zzmh();
    private final String description;
    private final String mimeType;
    private final int zzbda;
    private final byte[] zzbdb;

    public zzmf(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzbda = 3;
        this.zzbdb = bArr;
    }

    zzmf(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzbda = parcel.readInt();
        this.zzbdb = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmf zzmf = (zzmf) obj;
            return this.zzbda == zzmf.zzbda && zzpo.zza(this.mimeType, zzmf.mimeType) && zzpo.zza(this.description, zzmf.description) && Arrays.equals(this.zzbdb, zzmf.zzbdb);
        }
    }

    public final int hashCode() {
        int i = (this.zzbda + MetaDo.META_OFFSETWINDOWORG) * 31;
        String str = this.mimeType;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.zzbdb);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzbda);
        parcel.writeByteArray(this.zzbdb);
    }
}
