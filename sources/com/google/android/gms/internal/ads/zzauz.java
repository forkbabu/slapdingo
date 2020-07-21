package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzauz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzauz> CREATOR = new zzavc();
    public final String zzdur;
    public final String zzdus;

    public zzauz(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    public zzauz(String str, String str2) {
        this.zzdur = str;
        this.zzdus = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdur, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdus, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
