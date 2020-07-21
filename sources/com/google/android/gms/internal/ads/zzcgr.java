package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzc;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcgr {
    private final zzbfv zzbpw;
    private final zzbbd zzdpd;
    private final zzeg zzemz;
    private final Executor zzflp;
    private final zza zzgar;
    /* access modifiers changed from: private */
    public final zzcgw zzgbp = new zzcgw(null);
    private final zzahi zzgbq;
    private zzdvf<zzbfn> zzgbr;
    private final Context zzvr;

    zzcgr(zzchb zzchb) {
        this.zzvr = zzchb.zzvr;
        this.zzflp = zzchb.zzflp;
        this.zzemz = zzchb.zzemz;
        this.zzdpd = zzchb.zzdpd;
        this.zzgar = zzchb.zzgar;
        this.zzbpw = zzchb.zzbpw;
        this.zzgbq = new zzahi();
    }

    public final synchronized void zzamz() {
        zzdvf<zzbfn> zzb = zzdux.zzb(zzbfv.zza(this.zzvr, this.zzdpd, (String) zzwg.zzpw().zzd(zzaav.zzcre), this.zzemz, this.zzgar), new zzcgq(this), this.zzflp);
        this.zzgbr = zzb;
        zzbbj.zza(zzb, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void destroy() {
        if (this.zzgbr != null) {
            zzdux.zza(this.zzgbr, new zzcgs(this), this.zzflp);
            this.zzgbr = null;
        }
    }

    public final synchronized zzdvf<JSONObject> zzc(String str, JSONObject jSONObject) {
        if (this.zzgbr == null) {
            return zzdux.zzaf(null);
        }
        return zzdux.zzb(this.zzgbr, new zzcgt(this, str, jSONObject), this.zzflp);
    }

    public final synchronized void zza(String str, zzahc<Object> zzahc) {
        if (this.zzgbr != null) {
            zzdux.zza(this.zzgbr, new zzcgv(this, str, zzahc), this.zzflp);
        }
    }

    public final synchronized void zzb(String str, zzahc<Object> zzahc) {
        if (this.zzgbr != null) {
            zzdux.zza(this.zzgbr, new zzcgu(this, str, zzahc), this.zzflp);
        }
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzgbr != null) {
            zzdux.zza(this.zzgbr, new zzcgx(this, str, map), this.zzflp);
        }
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzahc<T> zzahc) {
        zza(str, new zzcha(this, weakReference, str, zzahc, null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(String str, JSONObject jSONObject, zzbfn zzbfn) throws Exception {
        return this.zzgbq.zza(zzbfn, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbfn zzm(zzbfn zzbfn) {
        zzbfn.zza("/result", this.zzgbq);
        zzbgz zzaaz = zzbfn.zzaaz();
        zzcgw zzcgw = this.zzgbp;
        zzaaz.zza(null, zzcgw, zzcgw, zzcgw, zzcgw, false, null, new zzc(this.zzvr, null, null), null, null);
        return zzbfn;
    }
}
