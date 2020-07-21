package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzadj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzadj> CREATOR = new zzadi();
    public final int versionCode;
    public final int zzbng;
    public final int zzbnh;
    public final boolean zzbni;
    public final int zzbnj;
    public final boolean zzbnl;
    public final boolean zzdcf;
    public final zzaaa zzdcg;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzadj(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaaa(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjs(), nativeAdOptions.getMediaAspectRatio());
    }

    public zzadj(int i, boolean z, int i2, boolean z2, int i3, zzaaa zzaaa, boolean z3, int i4) {
        this.versionCode = i;
        this.zzdcf = z;
        this.zzbng = i2;
        this.zzbni = z2;
        this.zzbnj = i3;
        this.zzdcg = zzaaa;
        this.zzbnl = z3;
        this.zzbnh = i4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdcf);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbng);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbni);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbnj);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdcg, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbnl);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbnh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
