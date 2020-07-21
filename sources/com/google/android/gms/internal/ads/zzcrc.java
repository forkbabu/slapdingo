package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrc implements zzcqt<zzbnc> {
    private final Executor zzflp;
    private final zzdla zzfpv;
    private final zzchw zzfyz;
    private final zzbny zzgkn;
    private final zzdrx<zzdkk, zzayv> zzgko;
    private final Context zzvr;

    public zzcrc(zzbny zzbny, Context context, Executor executor, zzchw zzchw, zzdla zzdla, zzdrx<zzdkk, zzayv> zzdrx) {
        this.zzvr = context;
        this.zzgkn = zzbny;
        this.zzflp = executor;
        this.zzfyz = zzchw;
        this.zzfpv = zzdla;
        this.zzgko = zzdrx;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return (zzdkk.zzgzr == null || zzdkk.zzgzr.zzdoh == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<zzbnc> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        return zzdux.zzb(zzdux.zzaf(null), new zzcrf(this, zzdkw, zzdkk), this.zzflp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzbfn zzbfn) {
        zzbfn.zzaat();
        zzbgh zzzj = zzbfn.zzzj();
        if (this.zzfpv.zzhax != null && zzzj != null) {
            zzzj.zzb(this.zzfpv.zzhax);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzb(zzdkw zzdkw, zzdkk zzdkk, Object obj) throws Exception {
        zzvh zzb = zzdld.zzb(this.zzvr, zzdkk.zzgzt);
        zzbfn zzc = this.zzfyz.zzc(zzb);
        zzc.zzba(zzdkk.zzdsh);
        zzbny zzbny = this.zzgkn;
        zzbpr zzbpr = new zzbpr(zzdkw, zzdkk, null);
        zzcin zzcin = new zzcin(this.zzvr, zzc.getView(), this.zzgko.apply(zzdkk));
        zzc.getClass();
        zzbnf zza = zzbny.zza(zzbpr, new zzbnj(zzcin, zzc, zzcre.zzp(zzc), zzdld.zze(zzb)));
        zza.zzafj().zzb(zzc, false);
        zza.zzaek().zza(new zzcrh(zzc), zzbbf.zzedm);
        zza.zzafj();
        zzdvf<?> zza2 = zzchy.zza(zzc, zzdkk.zzgzr.zzdof, zzdkk.zzgzr.zzdoh);
        if (zzdkk.zzdub) {
            zzc.getClass();
            zza2.addListener(zzcrg.zzh(zzc), this.zzflp);
        }
        zza2.addListener(new zzcrj(this, zzc), this.zzflp);
        return zzdux.zzb(zza2, new zzcri(zza), zzbbf.zzedm);
    }
}
