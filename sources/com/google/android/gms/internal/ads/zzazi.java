package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzazi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzazi> CREATOR = new zzazk();
    public final int errorCode;
    public final String zzacl;

    public static zzazi zzc(Throwable th) {
        String str;
        zzuy zze = zzcmi.zze(th);
        if (zzdsi.zzar(th.getMessage())) {
            str = zze.zzcgo;
        } else {
            str = th.getMessage();
        }
        return new zzazi(str, zze.errorCode);
    }

    zzazi(String str, int i) {
        this.zzacl = str == null ? "" : str;
        this.errorCode = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzacl, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
