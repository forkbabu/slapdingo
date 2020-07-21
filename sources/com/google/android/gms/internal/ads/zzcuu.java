package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcuu implements zzcqw<zzchj, zzdlm, zzcsc> {
    /* access modifiers changed from: private */
    public final Executor zzflp;
    private final zzchm zzgmt;
    private final Context zzvr;

    public zzcuu(Context context, Executor executor, zzchm zzchm) {
        this.zzvr = context;
        this.zzflp = executor;
        this.zzgmt = zzchm;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsc> zzcqv) throws zzdlg {
        if (!zzcqv.zzdka.isInitialized()) {
            zzcqv.zzgki.zza(new zzcuw(this, zzdkw, zzdkk, zzcqv));
            zzcqv.zzdka.zza(this.zzvr, zzdkw.zzhat.zzfpv.zzhay, null, zzcqv.zzgki, zzdkk.zzgzu.toString());
            return;
        }
        zzc(zzdkw, zzdkk, zzcqv);
    }

    /* access modifiers changed from: private */
    public static void zzc(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsc> zzcqv) {
        try {
            zzcqv.zzdka.zza(zzdkw.zzhat.zzfpv.zzhay, zzdkk.zzgzu.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcqv.zzfpp);
            zzaxv.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzchj zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsc> zzcqv) throws zzdlg, zzctw {
        zzchl zza = this.zzgmt.zza(new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp), new zzchk(new zzcux(zzcqv)));
        zza.zzaeh().zza(new zzbli(zzcqv.zzdka), this.zzflp);
        zzbtl zzaei = zza.zzaei();
        zzbsk zzaej = zza.zzaej();
        zzcqv.zzgki.zza(new zzcuy(this, zza.zzafx(), zzaej, zzaei, zza.zzagd()));
        return zza.zzagc();
    }
}
