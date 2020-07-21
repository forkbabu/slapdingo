package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzve extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzve> CREATOR = new zzvg();
    public final Bundle extras;
    public final int versionCode;
    public final int zzadg;
    public final int zzadh;
    public final String zzadi;
    public final boolean zzbnr;
    @Deprecated
    public final long zzcgs;
    @Deprecated
    public final int zzcgt;
    public final List<String> zzcgu;
    public final boolean zzcgv;
    public final String zzcgw;
    public final zzzw zzcgx;
    public final String zzcgy;
    public final Bundle zzcgz;
    public final Bundle zzcha;
    public final List<String> zzchb;
    public final String zzchc;
    public final String zzchd;
    @Deprecated
    public final boolean zzche;
    public final List<String> zzchf;
    public final zzuw zzchg;
    public final Location zznb;

    public zzve(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzzw zzzw, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3, zzuw zzuw, int i4, String str5, List<String> list3) {
        this.versionCode = i;
        this.zzcgs = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcgt = i2;
        this.zzcgu = list;
        this.zzcgv = z;
        this.zzadg = i3;
        this.zzbnr = z2;
        this.zzcgw = str;
        this.zzcgx = zzzw;
        this.zznb = location;
        this.zzcgy = str2;
        this.zzcgz = bundle2 == null ? new Bundle() : bundle2;
        this.zzcha = bundle3;
        this.zzchb = list2;
        this.zzchc = str3;
        this.zzchd = str4;
        this.zzche = z3;
        this.zzchg = zzuw;
        this.zzadh = i4;
        this.zzadi = str5;
        this.zzchf = list3 == null ? new ArrayList<>() : list3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcgs);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcgt);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcgu, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzcgv);
        SafeParcelWriter.writeInt(parcel, 7, this.zzadg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbnr);
        SafeParcelWriter.writeString(parcel, 9, this.zzcgw, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzcgx, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zznb, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzcgy, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzcgz, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzcha, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzchb, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzchc, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzchd, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzche);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzchg, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzadh);
        SafeParcelWriter.writeString(parcel, 21, this.zzadi, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzchf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzve)) {
            return false;
        }
        zzve zzve = (zzve) obj;
        if (this.versionCode != zzve.versionCode || this.zzcgs != zzve.zzcgs || !Objects.equal(this.extras, zzve.extras) || this.zzcgt != zzve.zzcgt || !Objects.equal(this.zzcgu, zzve.zzcgu) || this.zzcgv != zzve.zzcgv || this.zzadg != zzve.zzadg || this.zzbnr != zzve.zzbnr || !Objects.equal(this.zzcgw, zzve.zzcgw) || !Objects.equal(this.zzcgx, zzve.zzcgx) || !Objects.equal(this.zznb, zzve.zznb) || !Objects.equal(this.zzcgy, zzve.zzcgy) || !Objects.equal(this.zzcgz, zzve.zzcgz) || !Objects.equal(this.zzcha, zzve.zzcha) || !Objects.equal(this.zzchb, zzve.zzchb) || !Objects.equal(this.zzchc, zzve.zzchc) || !Objects.equal(this.zzchd, zzve.zzchd) || this.zzche != zzve.zzche || this.zzadh != zzve.zzadh || !Objects.equal(this.zzadi, zzve.zzadi) || !Objects.equal(this.zzchf, zzve.zzchf)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcgs), this.extras, Integer.valueOf(this.zzcgt), this.zzcgu, Boolean.valueOf(this.zzcgv), Integer.valueOf(this.zzadg), Boolean.valueOf(this.zzbnr), this.zzcgw, this.zzcgx, this.zznb, this.zzcgy, this.zzcgz, this.zzcha, this.zzchb, this.zzchc, this.zzchd, Boolean.valueOf(this.zzche), Integer.valueOf(this.zzadh), this.zzadi, this.zzchf);
    }
}
