package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagi;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzuu;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzm();
    public final int orientation;
    public final String url;
    public final zzbbd zzboy;
    public final zzuu zzcgl;
    public final zzagi zzddi;
    public final zzagk zzddj;
    public final zzbfn zzdfp;
    public final zzd zzdod;
    public final zzo zzdoe;
    public final String zzdof;
    public final boolean zzdog;
    public final String zzdoh;
    public final zzt zzdoi;
    public final int zzdoj;
    public final String zzdok;
    public final zzg zzdol;

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public AdOverlayInfoParcel(zzuu zzuu, zzo zzo, zzt zzt, zzbfn zzbfn, int i, zzbbd zzbbd, String str, zzg zzg, String str2, String str3) {
        this.zzdod = null;
        this.zzcgl = null;
        this.zzdoe = zzo;
        this.zzdfp = zzbfn;
        this.zzddi = null;
        this.zzddj = null;
        this.zzdof = str2;
        this.zzdog = false;
        this.zzdoh = str3;
        this.zzdoi = null;
        this.orientation = i;
        this.zzdoj = 1;
        this.url = null;
        this.zzboy = zzbbd;
        this.zzdok = str;
        this.zzdol = zzg;
    }

    public AdOverlayInfoParcel(zzuu zzuu, zzo zzo, zzt zzt, zzbfn zzbfn, boolean z, int i, zzbbd zzbbd) {
        this.zzdod = null;
        this.zzcgl = zzuu;
        this.zzdoe = zzo;
        this.zzdfp = zzbfn;
        this.zzddi = null;
        this.zzddj = null;
        this.zzdof = null;
        this.zzdog = z;
        this.zzdoh = null;
        this.zzdoi = zzt;
        this.orientation = i;
        this.zzdoj = 2;
        this.url = null;
        this.zzboy = zzbbd;
        this.zzdok = null;
        this.zzdol = null;
    }

    public AdOverlayInfoParcel(zzuu zzuu, zzo zzo, zzagi zzagi, zzagk zzagk, zzt zzt, zzbfn zzbfn, boolean z, int i, String str, zzbbd zzbbd) {
        this.zzdod = null;
        this.zzcgl = zzuu;
        this.zzdoe = zzo;
        this.zzdfp = zzbfn;
        this.zzddi = zzagi;
        this.zzddj = zzagk;
        this.zzdof = null;
        this.zzdog = z;
        this.zzdoh = null;
        this.zzdoi = zzt;
        this.orientation = i;
        this.zzdoj = 3;
        this.url = str;
        this.zzboy = zzbbd;
        this.zzdok = null;
        this.zzdol = null;
    }

    public AdOverlayInfoParcel(zzuu zzuu, zzo zzo, zzagi zzagi, zzagk zzagk, zzt zzt, zzbfn zzbfn, boolean z, int i, String str, String str2, zzbbd zzbbd) {
        this.zzdod = null;
        this.zzcgl = zzuu;
        this.zzdoe = zzo;
        this.zzdfp = zzbfn;
        this.zzddi = zzagi;
        this.zzddj = zzagk;
        this.zzdof = str2;
        this.zzdog = z;
        this.zzdoh = str;
        this.zzdoi = zzt;
        this.orientation = i;
        this.zzdoj = 3;
        this.url = null;
        this.zzboy = zzbbd;
        this.zzdok = null;
        this.zzdol = null;
    }

    public AdOverlayInfoParcel(zzd zzd, zzuu zzuu, zzo zzo, zzt zzt, zzbbd zzbbd) {
        this.zzdod = zzd;
        this.zzcgl = zzuu;
        this.zzdoe = zzo;
        this.zzdfp = null;
        this.zzddi = null;
        this.zzddj = null;
        this.zzdof = null;
        this.zzdog = false;
        this.zzdoh = null;
        this.zzdoi = zzt;
        this.orientation = -1;
        this.zzdoj = 4;
        this.url = null;
        this.zzboy = zzbbd;
        this.zzdok = null;
        this.zzdol = null;
    }

    AdOverlayInfoParcel(zzd zzd, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzbbd zzbbd, String str4, zzg zzg, IBinder iBinder6) {
        this.zzdod = zzd;
        this.zzcgl = (zzuu) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdoe = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzdfp = (zzbfn) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzddi = (zzagi) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zzddj = (zzagk) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzdof = str;
        this.zzdog = z;
        this.zzdoh = str2;
        this.zzdoi = (zzt) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzdoj = i2;
        this.url = str3;
        this.zzboy = zzbbd;
        this.zzdok = str4;
        this.zzdol = zzg;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdod, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzcgl).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzdoe).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzdfp).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzddj).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdof, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdog);
        SafeParcelWriter.writeString(parcel, 9, this.zzdoh, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzdoi).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdoj);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzboy, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzdok, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzdol, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzddi).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
