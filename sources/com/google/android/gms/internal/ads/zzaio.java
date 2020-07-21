package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaio extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaio> CREATOR = new zzair();
    public final int versionCode;
    public final int zzbnh;
    public final int zzdex;
    public final String zzdey;

    public zzaio(zzaja zzaja) {
        this(2, 1, zzaja.zzsu(), zzaja.getMediaAspectRatio());
    }

    public zzaio(int i, int i2, String str, int i3) {
        this.versionCode = i;
        this.zzdex = i2;
        this.zzdey = str;
        this.zzbnh = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdex);
        SafeParcelWriter.writeString(parcel, 2, this.zzdey, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbnh);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
