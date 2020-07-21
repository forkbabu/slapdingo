package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfe implements zzdec<zzdfb> {
    private final Executor executor;
    private final zzaxh zzbpz;
    private final ScheduledExecutorService zzfkm;
    private final zzaxd zzguy;
    private final int zzgvi;
    private final Context zzvr;

    public zzdfe(zzaxd zzaxd, int i, Context context, zzaxh zzaxh, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzguy = zzaxd;
        this.zzgvi = i;
        this.zzvr = context;
        this.zzbpz = zzaxh;
        this.zzfkm = scheduledExecutorService;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdfb> zzaqm() {
        return zzduo.zzg(zzdux.zza(new zzdfd(this), this.executor)).zza(zzdfg.zzdvt, this.executor).zza(((Long) zzwg.zzpw().zzd(zzaav.zzcof)).longValue(), TimeUnit.MILLISECONDS, this.zzfkm).zza(Exception.class, new zzdff(this), zzdvh.zzaxf());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfb zzb(Exception exc) {
        this.zzbpz.zza(exc, "AttestationTokenSignal");
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzarg() throws Exception {
        return this.zzguy.zza(this.zzvr, this.zzgvi);
    }
}
