package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdai implements zzdec<zzdaf> {
    private final Executor executor;
    private final ScheduledExecutorService zzfkm;
    private final Context zzvr;

    public zzdai(Context context, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzvr = context;
        this.zzfkm = scheduledExecutorService;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdaf> zzaqm() {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcvu)).booleanValue()) {
            return zzdux.zzaf(null);
        }
        zzbbn zzbbn = new zzbbn();
        try {
            new zzdah(zzbbn).zzbm(false);
        } catch (Throwable unused) {
            zzaxv.zzfb("ArCoreApk is not ready.");
            zzbbn.set(false);
        }
        return zzdux.zzb(zzdux.zzb(zzdux.zza(zzbbn, 200, TimeUnit.MILLISECONDS, this.zzfkm), new zzdak(this), this.executor), Throwable.class, zzdaj.zzboi, this.executor);
    }
}
