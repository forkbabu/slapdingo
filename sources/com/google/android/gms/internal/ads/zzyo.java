package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzyo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyo> CREATOR = new zzyn();
    private final int zzcix;

    public zzyo(int i) {
        this.zzcix = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzcix);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
