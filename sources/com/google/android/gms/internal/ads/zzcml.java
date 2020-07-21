package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcml {
    private final zzdvi zzgad;
    private final zzdvi zzggg;
    private final zzcnw zzggh;
    private final zzeku<zzcoy> zzggi;

    public zzcml(zzdvi zzdvi, zzdvi zzdvi2, zzcnw zzcnw, zzeku<zzcoy> zzeku) {
        this.zzggg = zzdvi;
        this.zzgad = zzdvi2;
        this.zzggh = zzcnw;
        this.zzggi = zzeku;
    }

    public final zzdvf<InputStream> zze(zzasm zzasm) {
        zzdvf zzdvf;
        String str = zzasm.packageName;
        zzq.zzkw();
        if (zzaye.zzeq(str)) {
            zzdvf = zzdux.immediateFailedFuture(new zzcop(zzdls.zzhbq));
        } else {
            zzdvf = zzdux.zzb(this.zzggg.zze(new zzcmk(this, zzasm)), ExecutionException.class, zzcmn.zzboi, this.zzgad);
        }
        return zzdux.zzb(zzdvf, zzcop.class, new zzcmm(this, zzasm, Binder.getCallingUid()), this.zzgad);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzasm zzasm, int i, zzcop zzcop) throws Exception {
        return this.zzggi.get().zzb(zzasm, i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzf(zzasm zzasm) throws Exception {
        return this.zzggh.zzi(zzasm).get((long) ((Integer) zzwg.zzpw().zzd(zzaav.zzcug)).intValue(), TimeUnit.SECONDS);
    }
}
