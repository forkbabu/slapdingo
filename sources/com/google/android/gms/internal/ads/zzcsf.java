package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsf implements zzcqt<zzbzj> {
    private final zzbbd zzbov;
    private final Executor zzflp;
    private final zzdla zzfpv;
    private final zzchw zzfyz;
    private final zzcae zzgkx;
    private final Context zzvr;

    public zzcsf(Context context, zzbbd zzbbd, zzdla zzdla, Executor executor, zzcae zzcae, zzchw zzchw) {
        this.zzvr = context;
        this.zzfpv = zzdla;
        this.zzgkx = zzcae;
        this.zzflp = executor;
        this.zzbov = zzbbd;
        this.zzfyz = zzchw;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return (zzdkk.zzgzr == null || zzdkk.zzgzr.zzdoh == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<zzbzj> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        zzcim zzcim = new zzcim();
        zzdvf<zzbzj> zzb = zzdux.zzb(zzdux.zzaf(null), new zzcse(this, zzdkk, zzcim, zzdkw), this.zzflp);
        zzcim.getClass();
        zzb.addListener(zzcsh.zza(zzcim), this.zzflp);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdkk zzdkk, zzcim zzcim, zzdkw zzdkw, Object obj) throws Exception {
        zzdvf<?> zzdvf;
        zzbfn zza = this.zzfyz.zza(this.zzfpv.zzboz, zzdkk.zzene);
        zza.zzba(zzdkk.zzdsh);
        zzcim.zzc(this.zzvr, zza.getView());
        zzbbn zzbbn = new zzbbn();
        zzbzl zza2 = this.zzgkx.zza(new zzbpr(zzdkw, zzdkk, null), new zzbzk(new zzcsl(this.zzvr, this.zzbov, zzbbn, zzdkk, zza), zza));
        zzbbn.set(zza2);
        zza2.zzaek().zza(new zzcsg(zza), zzbbf.zzedm);
        zza2.zzafj().zzb(zza, true);
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcvu)).booleanValue() || !zzdkk.zzene) {
            zza2.zzafj();
            zzdvf = zzchy.zza(zza, zzdkk.zzgzr.zzdof, zzdkk.zzgzr.zzdoh);
        } else {
            zzdvf = zzdux.zzaf(null);
        }
        return zzdux.zzb(zzdvf, new zzcsj(this, zza, zzdkk, zza2), this.zzflp);
    }
}
