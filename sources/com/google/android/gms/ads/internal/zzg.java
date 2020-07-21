package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzj();
    public final boolean zzboj;
    public final boolean zzbok;
    private final String zzbol;
    public final boolean zzbom;
    public final float zzbon;
    public final int zzboo;
    public final boolean zzbop;
    public final boolean zzboq;
    public final boolean zzbor;

    public zzg(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(false, z2, null, false, 0.0f, -1, z4, z5, z6);
    }

    zzg(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this.zzboj = z;
        this.zzbok = z2;
        this.zzbol = str;
        this.zzbom = z3;
        this.zzbon = f;
        this.zzboo = i;
        this.zzbop = z4;
        this.zzboq = z5;
        this.zzbor = z6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzboj);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbok);
        SafeParcelWriter.writeString(parcel, 4, this.zzbol, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbom);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzbon);
        SafeParcelWriter.writeInt(parcel, 7, this.zzboo);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbop);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzboq);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbor);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
