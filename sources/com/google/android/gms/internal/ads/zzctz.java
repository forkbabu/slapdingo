package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctz<AdT> implements zzduh<zzdkw, AdT> {
    private final Executor executor;
    private final zzdpd zzfkp;
    private final ScheduledExecutorService zzfmo;
    private final zzdou zzfpw;
    private final zzbso zzftb;
    private final zzbpc<AdT> zzgmr;
    private final zzcts zzgms;

    public zzctz(zzdou zzdou, zzcts zzcts, zzbso zzbso, zzdpd zzdpd, zzbpc<AdT> zzbpc, Executor executor2, ScheduledExecutorService scheduledExecutorService) {
        this.zzfpw = zzdou;
        this.zzgms = zzcts;
        this.zzftb = zzbso;
        this.zzfkp = zzdpd;
        this.zzgmr = zzbpc;
        this.executor = executor2;
        this.zzfmo = scheduledExecutorService;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduh
    public final /* synthetic */ zzdvf zzf(zzdkw zzdkw) throws Exception {
        zzdkw zzdkw2 = zzdkw;
        zzdod zzaus = this.zzfpw.zzu(zzdor.RENDER_CONFIG_INIT).zze(zzdux.immediateFailedFuture(new zzctw(zzdls.zzhbs, "No ad config."))).zzaus();
        this.zzftb.zza(new zzbll(zzdkw2, this.zzfkp), this.executor);
        int i = 0;
        for (zzdkk zzdkk : zzdkw2.zzhau.zzhaq) {
            Iterator<String> it2 = zzdkk.zzgzk.iterator();
            while (true) {
                if (it2.hasNext()) {
                    String next = it2.next();
                    zzcqt<AdT> zze = this.zzgmr.zze(zzdkk.zzgzl, next);
                    if (zze != null && zze.zza(zzdkw2, zzdkk)) {
                        zzdom zza = this.zzfpw.zza(zzdor.RENDER_CONFIG_WATERFALL, zzaus);
                        StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 26);
                        sb.append("render-config-");
                        sb.append(i);
                        sb.append("-");
                        sb.append(next);
                        zzaus = zza.zzgw(sb.toString()).zza(Throwable.class, new zzcty(this, zzdkw2, zzdkk, zze)).zzaus();
                        break;
                    }
                } else {
                    break;
                }
            }
            i++;
        }
        return zzaus;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdkw zzdkw, zzdkk zzdkk, zzcqt zzcqt, Throwable th) throws Exception {
        return this.zzgms.zza(zzdkw.zzhau.zzhar, zzdkk, zzdux.zza(zzcqt.zzb(zzdkw, zzdkk), (long) zzdkk.zzhaa, TimeUnit.MILLISECONDS, this.zzfmo));
    }
}
