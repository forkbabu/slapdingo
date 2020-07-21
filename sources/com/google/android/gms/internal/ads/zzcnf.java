package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcnf {
    private final ScheduledExecutorService zzfkm;
    private final zzdvi zzgad;
    private final zzeku<zzcoy> zzggi;
    private final zzcoa zzggu;

    public zzcnf(ScheduledExecutorService scheduledExecutorService, zzdvi zzdvi, zzcoa zzcoa, zzeku<zzcoy> zzeku) {
        this.zzfkm = scheduledExecutorService;
        this.zzgad = zzdvi;
        this.zzggu = zzcoa;
        this.zzggi = zzeku;
    }

    public final zzdvf<InputStream> zzg(zzasm zzasm) {
        zzdvf<InputStream> zzdvf;
        String str = zzasm.packageName;
        zzq.zzkw();
        if (zzaye.zzeq(str)) {
            zzdvf = zzdux.immediateFailedFuture(new zzcop(zzdls.zzhbq));
        } else {
            zzdvf = this.zzggu.zzj(zzasm);
        }
        int callingUid = Binder.getCallingUid();
        return zzduo.zzg(zzdvf).zza((long) ((Integer) zzwg.zzpw().zzd(zzaav.zzcug)).intValue(), TimeUnit.SECONDS, this.zzfkm).zza(Throwable.class, new zzcne(this, zzasm, callingUid), this.zzgad);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzasm zzasm, int i, Throwable th) throws Exception {
        return this.zzggi.get().zzd(zzasm, i);
    }
}
