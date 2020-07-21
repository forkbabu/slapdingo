package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcoy extends zzasc {
    private final Executor zzflp;
    private final zzasz zzgif;
    private final zzata zzgig;
    private final zzblb zzgih;
    private final HashMap<String, zzcpn> zzgii;
    private final Context zzvr;

    public zzcoy(Context context, Executor executor, zzasz zzasz, zzblb zzblb, zzata zzata, HashMap<String, zzcpn> hashMap) {
        zzaav.initialize(context);
        this.zzvr = context;
        this.zzflp = executor;
        this.zzgif = zzasz;
        this.zzgig = zzata;
        this.zzgih = zzblb;
        this.zzgii = hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final zzarv zza(zzart zzart) throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zza(zzart zzart, zzase zzase) throws RemoteException {
    }

    public final zzdvf<InputStream> zzb(zzasm zzasm, int i) {
        zzalr zza = zzq.zzlj().zza(this.zzvr, zzbbd.zzym());
        zzdeu zza2 = this.zzgih.zza(zzasm, i);
        zzalj zza3 = zza.zza("google.afma.response.normalize", zzcpm.zzgiq, zzalm.zzdhg);
        zzcpr zzcpr = new zzcpr(this.zzvr, zzasm.zzdpd.zzbpn, this.zzgif, zzasm.zzdqe, zzasm.applicationInfo);
        zzdou zzafd = zza2.zzafd();
        zzcpn zzcpn = null;
        if (!zzacp.zzdat.get().booleanValue()) {
            if (zzasm.zzdsu != null && !zzasm.zzdsu.isEmpty()) {
                zzaxv.zzeh("Request contained a PoolKey but split request is disabled.");
            }
        } else if (zzasm.zzdsu != null && !zzasm.zzdsu.isEmpty() && (zzcpn = this.zzgii.remove(zzasm.zzdsu)) == null) {
            zzaxv.zzeh("Request contained a PoolKey but no matching parameters were found.");
        }
        if (zzcpn == null) {
            zzdvf<JSONObject> zza4 = zza(zzasm, zzafd, zza2);
            zzdvf<zzass> zza5 = zza(zza4, zzafd, zza);
            zzdod zzaus = zzafd.zza(zzdor.HTTP, zza5, zza4).zzb(new zzcpb(zza4, zza5)).zzb(zzcpr).zzaus();
            return zzafd.zza(zzdor.PRE_PROCESS, zza4, zza5, zzaus).zzb(new zzcpa(zzaus, zza4, zza5)).zza(zza3).zzaus();
        }
        zzdod zzaus2 = zzafd.zza(zzdor.HTTP, zzdux.zzaf(new zzcpq(zzcpn.zzgio, zzcpn.zzgip))).zzb(zzcpr).zzaus();
        zzdvf<?> zzaf = zzdux.zzaf(zzcpn);
        return zzafd.zza(zzdor.PRE_PROCESS, zzaus2, zzaf).zzb(new zzcpd(zzaus2, zzaf)).zza(zza3).zzaus();
    }

    private static zzdvf<JSONObject> zza(zzasm zzasm, zzdou zzdou, zzdeu zzdeu) {
        zzcpc zzcpc = new zzcpc(zzdeu);
        return zzdou.zza(zzdor.GMS_SIGNALS, zzdux.zzaf(zzasm.zzdsq)).zza(zzcpc).zzb(zzcpf.zzggm).zzaus();
    }

    private static zzdvf<zzass> zza(zzdvf<JSONObject> zzdvf, zzdou zzdou, zzalr zzalr) {
        return zzdou.zza(zzdor.BUILD_URL, zzdvf).zza(zzalr.zza("AFMA_getAdDictionary", zzalm.zzdhf, zzcpe.zzdhh)).zzaus();
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zza(zzasm zzasm, zzasg zzasg) {
        zzdvf<InputStream> zzb = zzb(zzasm, Binder.getCallingUid());
        zza(zzb, zzasg);
        zzb.addListener(new zzcph(this), this.zzflp);
    }

    public final zzdvf<InputStream> zzc(zzasm zzasm, int i) {
        if (!zzacp.zzdat.get().booleanValue()) {
            return zzdux.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        if (zzasm.zzdst == null) {
            return zzdux.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzasm.zzdst.zzhdk == 0 || zzasm.zzdst.zzhdl == 0) {
            return zzdux.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzalr zza = zzq.zzlj().zza(this.zzvr, zzbbd.zzym());
        zzdeu zza2 = this.zzgih.zza(zzasm, i);
        zzdou zzafd = zza2.zzafd();
        zzdvf<JSONObject> zza3 = zza(zzasm, zzafd, zza2);
        zzdvf<zzass> zza4 = zza(zza3, zzafd, zza);
        return zzafd.zza(zzdor.GET_URL_AND_CACHE_KEY, zza3, zza4).zzb(new zzcpg(this, zza4, zza3)).zzaus();
    }

    public final zzdvf<InputStream> zzgm(String str) {
        if (!zzacp.zzdat.get().booleanValue()) {
            return zzdux.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcpl zzcpl = new zzcpl(this);
        if (this.zzgii.remove(str) != null) {
            return zzdux.zzaf(zzcpl);
        }
        String valueOf = String.valueOf(str);
        return zzdux.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzc(zzasm zzasm, zzasg zzasg) {
        zza(zzc(zzasm, Binder.getCallingUid()), zzasg);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zza(String str, zzasg zzasg) {
        zza(zzgm(str), zzasg);
    }

    public final zzdvf<InputStream> zzd(zzasm zzasm, int i) {
        zzalr zza = zzq.zzlj().zza(this.zzvr, zzbbd.zzym());
        if (!zzacv.zzdbk.get().booleanValue()) {
            return zzdux.immediateFailedFuture(new Exception("Signal collection disabled."));
        }
        zzdeu zza2 = this.zzgih.zza(zzasm, i);
        zzdeb<JSONObject> zzafc = zza2.zzafc();
        return zza2.zzafd().zza(zzdor.GET_SIGNALS, zzdux.zzaf(zzasm.zzdsq)).zza(new zzcpj(zzafc)).zzw(zzdor.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzalm.zzdhf, zzalm.zzdhg)).zzaus();
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzb(zzasm zzasm, zzasg zzasg) {
        zza(zzd(zzasm, Binder.getCallingUid()), zzasg);
    }

    private final void zza(zzdvf<InputStream> zzdvf, zzasg zzasg) {
        zzdux.zza(zzdux.zzb(zzdvf, new zzcpi(this), zzbbf.zzedh), new zzcpk(this, zzasg), zzbbf.zzedm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zza(zzdvf zzdvf, zzdvf zzdvf2) throws Exception {
        String zzve = ((zzass) zzdvf.get()).zzve();
        this.zzgii.put(zzve, new zzcpn((zzass) zzdvf.get(), (JSONObject) zzdvf2.get()));
        return new ByteArrayInputStream(zzve.getBytes(zzdrv.UTF_8));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzapf() {
        zzbbj.zza(this.zzgig.zzvg(), "persistFlags");
    }
}
