package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsx implements zzcsu<zzccd> {
    private final zzdvi zzgad;
    private final zzcbc zzglu;
    private final zzceu zzglv;
    private final zzdll<zzcgr> zzglw;

    public zzcsx(zzcbc zzcbc, zzdvi zzdvi, zzceu zzceu, zzdll<zzcgr> zzdll) {
        this.zzglu = zzcbc;
        this.zzgad = zzdvi;
        this.zzglv = zzceu;
        this.zzglw = zzdll;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return (zzdkk.zzgzr == null || zzdkk.zzgzr.zzfus == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<List<zzdvf<zzccd>>> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        return zzdux.zzb(zzdux.zzb(this.zzglw.zzass(), new zzcsw(this, zzdkk), this.zzgad), new zzcsz(this, zzdkw, zzdkk), this.zzgad);
    }

    private final zzdvf<zzccd> zzb(zzdkw zzdkw, zzdkk zzdkk, JSONObject jSONObject) {
        zzdvf<zzcgr> zzass = this.zzglw.zzass();
        zzdvf<zzcck> zza = this.zzglv.zza(zzdkw, zzdkk, jSONObject);
        return zzdux.zzb(zzass, zza).zza(new zzcta(this, zza, zzass, zzdkw, zzdkk, jSONObject), this.zzgad);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzccd zza(zzdvf zzdvf, zzdvf zzdvf2, zzdkw zzdkw, zzdkk zzdkk, JSONObject jSONObject) throws Exception {
        zzcck zzcck = (zzcck) zzdvf.get();
        zzcgr zzcgr = (zzcgr) zzdvf2.get();
        zzccm zza = this.zzglu.zza(new zzbpr(zzdkw, zzdkk, null), new zzccw(zzcck), new zzcbr(jSONObject, zzcgr));
        zza.zzaep().zzamy();
        zza.zzaeq().zzb(zzcgr);
        zza.zzaer().zzl(zzcck.zzall());
        return zza.zzaeo();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzcgr zzcgr, JSONObject jSONObject) throws Exception {
        this.zzglw.zzd(zzdux.zzaf(zzcgr));
        if (jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            return zzdux.zzaf(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzalg("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdkw zzdkw, zzdkk zzdkk, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzdux.immediateFailedFuture(new zzcmi(zzdls.zzhbs));
        }
        if (zzdkw.zzhat.zzfpv.zzgqe <= 1) {
            return zzdux.zzb(zzb(zzdkw, zzdkk, jSONArray.getJSONObject(0)), zzctb.zzdvt, this.zzgad);
        }
        int length = jSONArray.length();
        this.zzglw.zzeb(Math.min(length, zzdkw.zzhat.zzfpv.zzgqe));
        ArrayList arrayList = new ArrayList(zzdkw.zzhat.zzfpv.zzgqe);
        for (int i = 0; i < zzdkw.zzhat.zzfpv.zzgqe; i++) {
            if (i < length) {
                arrayList.add(zzb(zzdkw, zzdkk, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzdux.immediateFailedFuture(new zzcmi(zzdls.zzhbs)));
            }
        }
        return zzdux.zzaf(arrayList);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdkk zzdkk, zzcgr zzcgr) throws Exception {
        JSONObject zza = zzazy.zza("isNonagon", (Object) true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzdkk.zzgzr.zzfus);
        jSONObject.put("sdk_params", zza);
        return zzdux.zzb(zzcgr.zzc("google.afma.nativeAds.preProcessJson", jSONObject), new zzcsy(this, zzcgr), this.zzgad);
    }
}
