package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzahq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzahq> CREATOR = new zzaht();
    public final byte[] data;
    public final int statusCode;
    public final boolean zzan;
    public final long zzao;
    public final String zzcgo;
    public final String[] zzdel;
    public final String[] zzdem;
    public final boolean zzden;

    zzahq(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.zzden = z;
        this.zzcgo = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzdel = strArr;
        this.zzdem = strArr2;
        this.zzan = z2;
        this.zzao = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzden);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgo, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzdel, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzdem, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzan);
        SafeParcelWriter.writeLong(parcel, 8, this.zzao);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
