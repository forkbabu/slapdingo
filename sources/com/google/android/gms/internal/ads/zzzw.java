package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzw> CREATOR = new zzzz();
    public final String zzbpi;

    public zzzw(SearchAdRequest searchAdRequest) {
        this.zzbpi = searchAdRequest.getQuery();
    }

    zzzw(String str) {
        this.zzbpi = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zzbpi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
