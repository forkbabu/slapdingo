package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzctn<AdT> implements zzcqt<AdT> {
    /* access modifiers changed from: protected */
    public abstract zzdvf<AdT> zza(zzdla zzdla, Bundle bundle);

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return !TextUtils.isEmpty(zzdkk.zzgzu.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<AdT> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        String optString = zzdkk.zzgzu.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzdla zzdla = zzdkw.zzhat.zzfpv;
        zzdlc zzgs = new zzdlc().zzc(zzdla).zzgs(optString);
        Bundle zzn = zzn(zzdla.zzhay.zzcgz);
        Bundle zzn2 = zzn(zzn.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzn2.putInt("gw", 1);
        String optString2 = zzdkk.zzgzu.optString("mad_hac", null);
        if (optString2 != null) {
            zzn2.putString("mad_hac", optString2);
        }
        String optString3 = zzdkk.zzgzu.optString("adJson", null);
        if (optString3 != null) {
            zzn2.putString("_ad", optString3);
        }
        zzn2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzdkk.zzgzx.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzdkk.zzgzx.optString(next, null);
            if (next != null) {
                zzn2.putString(next, optString4);
            }
        }
        zzn.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzn2);
        zzdla zzaso = zzgs.zzh(new zzve(zzdla.zzhay.versionCode, zzdla.zzhay.zzcgs, zzn2, zzdla.zzhay.zzcgt, zzdla.zzhay.zzcgu, zzdla.zzhay.zzcgv, zzdla.zzhay.zzadg, zzdla.zzhay.zzbnr, zzdla.zzhay.zzcgw, zzdla.zzhay.zzcgx, zzdla.zzhay.zznb, zzdla.zzhay.zzcgy, zzn, zzdla.zzhay.zzcha, zzdla.zzhay.zzchb, zzdla.zzhay.zzchc, zzdla.zzhay.zzchd, zzdla.zzhay.zzche, zzdla.zzhay.zzchg, zzdla.zzhay.zzadh, zzdla.zzhay.zzadi, zzdla.zzhay.zzchf)).zzaso();
        Bundle bundle = new Bundle();
        zzdkm zzdkm = zzdkw.zzhau.zzhar;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzdkm.zzdii));
        bundle2.putInt("refresh_interval", zzdkm.zzhai);
        bundle2.putString("gws_query_id", zzdkm.zzdrt);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzdkw.zzhat.zzfpv.zzhaz;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzdkk.zzdjb);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzdkk.zzdif));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzdkk.zzdig));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzdkk.zzdrh));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzdkk.zzgzp));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzdkk.zzdrv));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzdkk.zzdrw));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzdkk.zzgzo));
        bundle3.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzdkk.zzdjm);
        bundle3.putString("valid_from_timestamp", zzdkk.zzdjn);
        bundle3.putBoolean("is_closable_area_disabled", zzdkk.zzbor);
        if (zzdkk.zzdru != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzdkk.zzdru.zzdun);
            bundle4.putString("rb_type", zzdkk.zzdru.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zza(zzaso, bundle);
    }

    private static Bundle zzn(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }
}
