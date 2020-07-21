package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzawx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawx> CREATOR = new zzaxa();
    public final String zzbpk;
    @Deprecated
    public final String zzbum;
    @Deprecated
    public final zzvh zzdww;
    public final zzve zzdwx;

    public zzawx(String str, String str2, zzvh zzvh, zzve zzve) {
        this.zzbum = str;
        this.zzbpk = str2;
        this.zzdww = zzvh;
        this.zzdwx = zzve;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbum, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbpk, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdww, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdwx, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
