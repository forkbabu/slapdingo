package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzu> CREATOR = new zzzx();
    private final int zzadg;
    private final int zzadh;

    public zzzu(int i, int i2) {
        this.zzadg = i;
        this.zzadh = i2;
    }

    public zzzu(RequestConfiguration requestConfiguration) {
        this.zzadg = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzadh = requestConfiguration.getTagForUnderAgeOfConsent();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzadg);
        SafeParcelWriter.writeInt(parcel, 2, this.zzadh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
