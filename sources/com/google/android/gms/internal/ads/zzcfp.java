package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcfp {
    private final Executor zzflp;
    private final zzdla zzfpv;
    private final zzchw zzfyz;

    public zzcfp(zzdla zzdla, Executor executor, zzchw zzchw) {
        this.zzfpv = zzdla;
        this.zzflp = executor;
        this.zzfyz = zzchw;
    }

    public final zzdvf<zzbfn> zzn(JSONObject jSONObject) {
        return zzdux.zzb(zzdux.zzb(zzdux.zzaf(null), new zzcfq(this), this.zzflp), new zzcfo(this, jSONObject), this.zzflp);
    }

    public final zzdvf<zzbfn> zzo(String str, String str2) {
        return zzdux.zzb(zzdux.zzaf(null), new zzcfr(this, str, str2), this.zzflp);
    }

    private final void zzk(zzbfn zzbfn) {
        zzbfn.zza("/video", zzagm.zzddw);
        zzbfn.zza("/videoMeta", zzagm.zzddx);
        zzbfn.zza("/precache", new zzbex());
        zzbfn.zza("/delayPageLoaded", zzagm.zzdea);
        zzbfn.zza("/instrument", zzagm.zzddy);
        zzbfn.zza("/log", zzagm.zzddr);
        zzbfn.zza("/videoClicked", zzagm.zzdds);
        zzbfn.zzaaz().zzbb(true);
        zzbfn.zza("/click", zzagm.zzddn);
        if (this.zzfpv.zzdra != null) {
            zzbfn.zzaaz().zzbc(true);
            zzbfn.zza("/open", new zzahg(null, null));
            return;
        }
        zzbfn.zzaaz().zzbc(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzr(Object obj) throws Exception {
        zzbfn zza = this.zzfyz.zza(zzvh.zzph(), false);
        zzbbo zzl = zzbbo.zzl(zza);
        zzk(zza);
        zza.zzaaz().zza(new zzcft(zzl));
        zza.loadUrl((String) zzwg.zzpw().zzd(zzaav.zzcrg));
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(String str, String str2, Object obj) throws Exception {
        zzbfn zza = this.zzfyz.zza(zzvh.zzph(), false);
        zzbbo zzl = zzbbo.zzl(zza);
        zzk(zza);
        if (this.zzfpv.zzdra != null) {
            zza.zza(zzbhg.zzacr());
        } else {
            zza.zza(zzbhg.zzacq());
        }
        zza.zzaaz().zza(new zzcfs(this, zza, zzl));
        zza.zzb(str, str2, null);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfn zzbfn, zzbbo zzbbo, boolean z) {
        if (z) {
            if (!(this.zzfpv.zzhax == null || zzbfn.zzzj() == null)) {
                zzbfn.zzzj().zzb(this.zzfpv.zzhax);
            }
            zzbbo.zzyn();
            return;
        }
        zzbbo.setException(new zzctw(zzdls.zzhbq, "Instream video Web View failed to load."));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(JSONObject jSONObject, zzbfn zzbfn) throws Exception {
        zzbbo zzl = zzbbo.zzl(zzbfn);
        if (this.zzfpv.zzdra != null) {
            zzbfn.zza(zzbhg.zzacr());
        } else {
            zzbfn.zza(zzbhg.zzacq());
        }
        zzbfn.zzaaz().zza(new zzcfv(this, zzbfn, zzl));
        zzbfn.zza("google.afma.nativeAds.renderVideo", jSONObject);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbfn zzbfn, zzbbo zzbbo, boolean z) {
        if (!(this.zzfpv.zzhax == null || zzbfn.zzzj() == null)) {
            zzbfn.zzzj().zzb(this.zzfpv.zzhax);
        }
        zzbbo.zzyn();
    }
}
