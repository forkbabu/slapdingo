package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczk implements zzddz<Bundle> {
    private final String zzacv;
    private final zzvh zzboz;
    private final float zzbru;
    private final boolean zzchk;
    private final int zzdmt;
    private final int zzdmu;
    private final String zzgrq;
    private final String zzgrr;
    private final boolean zzgrs;

    public zzczk(zzvh zzvh, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzvh, "the adSize must not be null");
        this.zzboz = zzvh;
        this.zzacv = str;
        this.zzchk = z;
        this.zzgrq = str2;
        this.zzbru = f;
        this.zzdmt = i;
        this.zzdmu = i2;
        this.zzgrr = str3;
        this.zzgrs = z2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdlf.zza(bundle2, "smart_w", "full", this.zzboz.width == -1);
        zzdlf.zza(bundle2, "smart_h", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.zzboz.height == -2);
        zzdlf.zza(bundle2, "ene", (Boolean) true, this.zzboz.zzchl);
        zzdlf.zza(bundle2, "rafmt", "102", this.zzboz.zzcho);
        zzdlf.zza(bundle2, "rafmt", "103", this.zzboz.zzchp);
        zzdlf.zza(bundle2, "inline_adaptive_slot", (Boolean) true, this.zzgrs);
        zzdlf.zza(bundle2, DublinCoreProperties.FORMAT, this.zzacv);
        zzdlf.zza(bundle2, "fluid", HtmlTags.HEIGHT, this.zzchk);
        String str = this.zzgrq;
        zzdlf.zza(bundle2, "sz", str, !TextUtils.isEmpty(str));
        bundle2.putFloat("u_sd", this.zzbru);
        bundle2.putInt("sw", this.zzdmt);
        bundle2.putInt("sh", this.zzdmu);
        String str2 = this.zzgrr;
        zzdlf.zza(bundle2, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (this.zzboz.zzchj == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(HtmlTags.HEIGHT, this.zzboz.height);
            bundle3.putInt(HtmlTags.WIDTH, this.zzboz.width);
            bundle3.putBoolean("is_fluid_height", this.zzboz.zzchk);
            arrayList.add(bundle3);
        } else {
            zzvh[] zzvhArr = this.zzboz.zzchj;
            for (zzvh zzvh : zzvhArr) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzvh.zzchk);
                bundle4.putInt(HtmlTags.HEIGHT, zzvh.height);
                bundle4.putInt(HtmlTags.WIDTH, zzvh.width);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
