package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctc implements zzcqw<zzccd, zzdlm, zzcsd> {
    private final Executor zzflp;
    private final zzcbc zzglu;
    private final Context zzvr;

    public zzctc(Context context, zzcbc zzcbc, Executor executor) {
        this.zzvr = context;
        this.zzglu = zzcbc;
        this.zzflp = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsd> zzcqv) throws zzdlg {
        zzcqv.zzdka.zza(this.zzvr, zzdkw.zzhat.zzfpv.zzhay, zzdkk.zzgzu.toString(), zzazy.zza(zzdkk.zzgzr), zzcqv.zzgki, zzdkw.zzhat.zzfpv.zzdkn, zzdkw.zzhat.zzfpv.zzhba);
    }

    private static boolean zza(zzdkw zzdkw, int i) {
        return zzdkw.zzhat.zzfpv.zzhba.contains(Integer.toString(i));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzccd zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsd> zzcqv) throws zzdlg, zzctw {
        zzcck zzcck;
        zzana zztk = zzcqv.zzdka.zztk();
        zzanf zztl = zzcqv.zzdka.zztl();
        zzang zztq = zzcqv.zzdka.zztq();
        if (zztq != null && zza(zzdkw, 6)) {
            zzcck = zzcck.zzb(zztq);
        } else if (zztk != null && zza(zzdkw, 6)) {
            zzcck = zzcck.zzb(zztk);
        } else if (zztk != null && zza(zzdkw, 2)) {
            zzcck = zzcck.zza(zztk);
        } else if (zztl != null && zza(zzdkw, 6)) {
            zzcck = zzcck.zzb(zztl);
        } else if (zztl == null || !zza(zzdkw, 1)) {
            throw new zzctw(zzdls.zzhbq, "No native ad mappers");
        } else {
            zzcck = zzcck.zza(zztl);
        }
        if (zzdkw.zzhat.zzfpv.zzhba.contains(Integer.toString(zzcck.zzalg()))) {
            zzccp zza = this.zzglu.zza(new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp), new zzccw(zzcck), new zzcel(zztl, zztk, zztq));
            zzcqv.zzgki.zzb(zza.zzaem());
            zza.zzaeh().zza(new zzbli(zzcqv.zzdka), this.zzflp);
            return zza.zzaeo();
        }
        throw new zzctw(zzdls.zzhbq, "No corresponding native ad listener");
    }
}
