package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqz implements zzcqt<zzbmw> {
    private final Executor zzflp;
    private final zzdla zzfpv;
    private final zzchw zzfyz;
    private final zzbmq zzgkl;
    private final Context zzvr;

    public zzcqz(zzbmq zzbmq, Context context, Executor executor, zzchw zzchw, zzdla zzdla) {
        this.zzvr = context;
        this.zzgkl = zzbmq;
        this.zzflp = executor;
        this.zzfyz = zzchw;
        this.zzfpv = zzdla;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return (zzdkk.zzgzr == null || zzdkk.zzgzr.zzdoh == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<zzbmw> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        return zzdux.zzb(zzdux.zzaf(null), new zzcqy(this, zzdkw, zzdkk), this.zzflp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdkw zzdkw, zzdkk zzdkk, Object obj) throws Exception {
        zzvh zzb = zzdld.zzb(this.zzvr, zzdkk.zzgzt);
        zzbfn zzc = this.zzfyz.zzc(zzb);
        zzbmk zza = this.zzgkl.zza(new zzbpr(zzdkw, zzdkk, null), new zzbmn(zzc.getView(), zzc, zzdld.zze(zzb), zzdkk.zzfmv, zzdkk.zzfmw, zzdkk.zzfmx));
        zza.zzafj().zzb(zzc, false);
        zza.zzaek().zza(new zzcrb(zzc), zzbbf.zzedm);
        zza.zzafj();
        return zzdux.zzb(zzchy.zza(zzc, zzdkk.zzgzr.zzdof, zzdkk.zzgzr.zzdoh), new zzcra(zza), zzbbf.zzedm);
    }
}
