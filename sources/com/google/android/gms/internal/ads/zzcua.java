package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcua implements zzcqw<zzchj, zzdlm, zzcsd> {
    private final Executor zzflp;
    private final zzchm zzgmt;
    private final Context zzvr;

    public zzcua(Context context, Executor executor, zzchm zzchm) {
        this.zzvr = context;
        this.zzflp = executor;
        this.zzgmt = zzchm;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsd> zzcqv) throws zzdlg {
        try {
            zzdla zzdla = zzdkw.zzhat.zzfpv;
            if (zzdla.zzhbf.zzhaj == zzdks.zzhan) {
                zzcqv.zzdka.zzc(this.zzvr, zzdla.zzhay, zzdkk.zzgzu.toString(), zzcqv.zzgki);
            } else {
                zzcqv.zzdka.zzb(this.zzvr, zzdla.zzhay, zzdkk.zzgzu.toString(), zzcqv.zzgki);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcqv.zzfpp);
            zzaxv.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzchj zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsd> zzcqv) throws zzdlg, zzctw {
        zzchl zza = this.zzgmt.zza(new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp), new zzchk(new zzcud(zzcqv)));
        zza.zzaeh().zza(new zzbli(zzcqv.zzdka), this.zzflp);
        zzcqv.zzgki.zzb(zza.zzage());
        return zza.zzagc();
    }
}
