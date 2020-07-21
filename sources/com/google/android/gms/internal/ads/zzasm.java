package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzasm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasm> CREATOR = new zzasl();
    public final ApplicationInfo applicationInfo;
    public final String packageName;
    public final zzbbd zzdpd;
    public final PackageInfo zzdpk;
    public final List<String> zzdpu;
    public final String zzdqe;
    public final Bundle zzdsq;
    public final boolean zzdsr;
    public final String zzdss;
    public zzdms zzdst;
    public String zzdsu;

    public zzasm(Bundle bundle, zzbbd zzbbd, ApplicationInfo applicationInfo2, String str, List<String> list, PackageInfo packageInfo, String str2, boolean z, String str3, zzdms zzdms, String str4) {
        this.zzdsq = bundle;
        this.zzdpd = zzbbd;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdpu = list;
        this.zzdpk = packageInfo;
        this.zzdqe = str2;
        this.zzdsr = z;
        this.zzdss = str3;
        this.zzdst = zzdms;
        this.zzdsu = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdsq, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdpd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdpu, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdpk, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdqe, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdsr);
        SafeParcelWriter.writeString(parcel, 9, this.zzdss, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdst, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzdsu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
