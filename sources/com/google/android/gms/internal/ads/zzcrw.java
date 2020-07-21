package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrw implements zzcqt<zzbnc> {
    private final ScheduledExecutorService zzfkm;
    /* access modifiers changed from: private */
    public final zzbso zzftb;
    private final zzdvi zzgad;
    private final zzbny zzgla;
    private final zzcrc zzglb;

    public zzcrw(zzbny zzbny, zzcrc zzcrc, zzbso zzbso, ScheduledExecutorService scheduledExecutorService, zzdvi zzdvi) {
        this.zzgla = zzbny;
        this.zzglb = zzcrc;
        this.zzftb = zzbso;
        this.zzfkm = scheduledExecutorService;
        this.zzgad = zzdvi;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return zzdkw.zzhat.zzfpv.zzasj() != null && this.zzglb.zza(zzdkw, zzdkk);
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<zzbnc> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        return this.zzgad.zze(new zzcrz(this, zzdkw, zzdkk));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbnc zzc(zzdkw zzdkw, zzdkk zzdkk) throws Exception {
        return this.zzgla.zza(new zzbpr(zzdkw, zzdkk, null), new zzbom(zzdkw.zzhat.zzfpv.zzasj(), new zzcry(this, zzdkw, zzdkk))).zzaft();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdkw zzdkw, zzdkk zzdkk) {
        zzdux.zza(zzdux.zza(this.zzglb.zzb(zzdkw, zzdkk), (long) zzdkk.zzhaa, TimeUnit.SECONDS, this.zzfkm), new zzcsb(this), this.zzgad);
    }
}
