package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczc implements zzddz<Bundle> {
    private final zzdla zzfpv;

    public zzczc(zzdla zzdla) {
        Preconditions.checkNotNull(zzdla, "the targeting must not be null");
        this.zzfpv = zzdla;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzve zzve = this.zzfpv.zzhay;
        bundle2.putString("slotname", this.zzfpv.zzhaz);
        boolean z = true;
        int i = zzczb.zzgch[this.zzfpv.zzhbf.zzhaj - 1];
        if (i == 1) {
            bundle2.putBoolean("is_new_rewarded", true);
        } else if (i == 2) {
            bundle2.putBoolean("is_rewarded_interstitial", true);
        }
        zzdlf.zza(bundle2, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzve.zzcgs)), zzve.zzcgs != -1);
        zzdlf.zza(bundle2, "extras", zzve.extras);
        zzdlf.zza(bundle2, "cust_gender", Integer.valueOf(zzve.zzcgt), zzve.zzcgt != -1);
        zzdlf.zza(bundle2, "kw", zzve.zzcgu);
        zzdlf.zza(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzve.zzadg), zzve.zzadg != -1);
        if (zzve.zzcgv) {
            bundle2.putBoolean("test_request", zzve.zzcgv);
        }
        zzdlf.zza(bundle2, "d_imp_hdr", (Integer) 1, zzve.versionCode >= 2 && zzve.zzbnr);
        zzdlf.zza(bundle2, "ppid", zzve.zzcgw, zzve.versionCode >= 2 && !TextUtils.isEmpty(zzve.zzcgw));
        if (zzve.zznb != null) {
            Location location = zzve.zznb;
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", valueOf.floatValue());
            bundle3.putLong("lat", valueOf3.longValue());
            bundle3.putLong("long", valueOf4.longValue());
            bundle3.putLong("time", valueOf2.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzdlf.zza(bundle2, "url", zzve.zzcgy);
        zzdlf.zza(bundle2, "neighboring_content_urls", zzve.zzchf);
        zzdlf.zza(bundle2, "custom_targeting", zzve.zzcha);
        zzdlf.zza(bundle2, "category_exclusions", zzve.zzchb);
        zzdlf.zza(bundle2, "request_agent", zzve.zzchc);
        zzdlf.zza(bundle2, "request_pkg", zzve.zzchd);
        zzdlf.zza(bundle2, "is_designed_for_families", Boolean.valueOf(zzve.zzche), zzve.versionCode >= 7);
        if (zzve.versionCode >= 8) {
            Integer valueOf5 = Integer.valueOf(zzve.zzadh);
            if (zzve.zzadh == -1) {
                z = false;
            }
            zzdlf.zza(bundle2, "tag_for_under_age_of_consent", valueOf5, z);
            zzdlf.zza(bundle2, "max_ad_content_rating", zzve.zzadi);
        }
    }
}
