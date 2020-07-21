package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zza();
    public final Intent intent;
    public final String mimeType;
    public final String packageName;
    public final String url;
    private final String zzdns;
    public final String zzdnt;
    public final String zzdnu;
    private final String zzdnv;

    public zzd(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    public zzd(Intent intent2) {
        this(null, null, null, null, null, null, null, intent2);
    }

    public zzd(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent2) {
        this.zzdns = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzdnt = str5;
        this.zzdnu = str6;
        this.zzdnv = str7;
        this.intent = intent2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdns, false);
        SafeParcelWriter.writeString(parcel, 3, this.url, false);
        SafeParcelWriter.writeString(parcel, 4, this.mimeType, false);
        SafeParcelWriter.writeString(parcel, 5, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzdnt, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdnu, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdnv, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.intent, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
