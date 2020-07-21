package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzatw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatw> CREATOR = new zzatv();
    public final String zzbum;
    public final zzve zzdpj;

    public zzatw(zzve zzve, String str) {
        this.zzdpj = zzve;
        this.zzbum = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdpj, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbum, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
