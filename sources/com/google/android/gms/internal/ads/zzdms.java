package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdms extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdms> CREATOR = new zzdmt();
    private final zzdmr[] zzhdf;
    private final int[] zzhdg;
    private final int[] zzhdh;
    private final int zzhdi;
    public final zzdmr zzhdj;
    public final int zzhdk;
    public final int zzhdl;
    public final int zzhdm;
    public final String zzhdn;
    private final int zzhdo;
    public final int zzhdp;
    private final int zzhdq;
    private final int zzhdr;
    @Nullable
    public final Context zzvr;

    private zzdms(@Nullable Context context, zzdmr zzdmr, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzhdf = zzdmr.values();
        this.zzhdg = zzdmu.zzato();
        this.zzhdh = zzdmu.zzatp();
        this.zzvr = context;
        this.zzhdi = zzdmr.ordinal();
        this.zzhdj = zzdmr;
        this.zzhdk = i;
        this.zzhdl = i2;
        this.zzhdm = i3;
        this.zzhdn = str;
        if ("oldest".equals(str2)) {
            i4 = zzdmu.zzhds;
        } else if ("lru".equals(str2) || !"lfu".equals(str2)) {
            i4 = zzdmu.zzhdt;
        } else {
            i4 = zzdmu.zzhdu;
        }
        this.zzhdp = i4;
        this.zzhdo = i4 - 1;
        "onAdClosed".equals(str3);
        int i5 = zzdmu.zzhdw;
        this.zzhdr = i5;
        this.zzhdq = i5 - 1;
    }

    public zzdms(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        this.zzhdf = zzdmr.values();
        this.zzhdg = zzdmu.zzato();
        int[] zzatp = zzdmu.zzatp();
        this.zzhdh = zzatp;
        this.zzvr = null;
        this.zzhdi = i;
        this.zzhdj = this.zzhdf[i];
        this.zzhdk = i2;
        this.zzhdl = i3;
        this.zzhdm = i4;
        this.zzhdn = str;
        this.zzhdo = i5;
        this.zzhdp = this.zzhdg[i5];
        this.zzhdq = i6;
        this.zzhdr = zzatp[i6];
    }

    public static zzdms zza(zzdmr zzdmr, Context context) {
        if (zzdmr == zzdmr.Rewarded) {
            return new zzdms(context, zzdmr, ((Integer) zzwg.zzpw().zzd(zzaav.zzcvw)).intValue(), ((Integer) zzwg.zzpw().zzd(zzaav.zzcwc)).intValue(), ((Integer) zzwg.zzpw().zzd(zzaav.zzcwe)).intValue(), (String) zzwg.zzpw().zzd(zzaav.zzcwg), (String) zzwg.zzpw().zzd(zzaav.zzcvy), (String) zzwg.zzpw().zzd(zzaav.zzcwa));
        } else if (zzdmr == zzdmr.Interstitial) {
            return new zzdms(context, zzdmr, ((Integer) zzwg.zzpw().zzd(zzaav.zzcvx)).intValue(), ((Integer) zzwg.zzpw().zzd(zzaav.zzcwd)).intValue(), ((Integer) zzwg.zzpw().zzd(zzaav.zzcwf)).intValue(), (String) zzwg.zzpw().zzd(zzaav.zzcwh), (String) zzwg.zzpw().zzd(zzaav.zzcvz), (String) zzwg.zzpw().zzd(zzaav.zzcwb));
        } else if (zzdmr != zzdmr.AppOpen) {
            return null;
        } else {
            return new zzdms(context, zzdmr, ((Integer) zzwg.zzpw().zzd(zzaav.zzcwk)).intValue(), ((Integer) zzwg.zzpw().zzd(zzaav.zzcwm)).intValue(), ((Integer) zzwg.zzpw().zzd(zzaav.zzcwn)).intValue(), (String) zzwg.zzpw().zzd(zzaav.zzcwi), (String) zzwg.zzpw().zzd(zzaav.zzcwj), (String) zzwg.zzpw().zzd(zzaav.zzcwl));
        }
    }

    public static boolean zzatn() {
        return ((Boolean) zzwg.zzpw().zzd(zzaav.zzcvv)).booleanValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzhdi);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhdk);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhdl);
        SafeParcelWriter.writeInt(parcel, 4, this.zzhdm);
        SafeParcelWriter.writeString(parcel, 5, this.zzhdn, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzhdo);
        SafeParcelWriter.writeInt(parcel, 7, this.zzhdq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
