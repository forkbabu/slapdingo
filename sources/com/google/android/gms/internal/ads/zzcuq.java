package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcuq implements zzcam {
    private final zzbbd zzbov;
    private final zzdkk zzfol;
    private final zzdla zzfpv;
    private final zzchw zzfyz;
    private final zzdvf<zzchl> zzglp;
    private final zzbfn zzgmz;
    private final Context zzvr;

    private zzcuq(Context context, zzchw zzchw, zzdla zzdla, zzbbd zzbbd, zzdkk zzdkk, zzdvf<zzchl> zzdvf, zzbfn zzbfn) {
        this.zzvr = context;
        this.zzfyz = zzchw;
        this.zzfpv = zzdla;
        this.zzbov = zzbbd;
        this.zzfol = zzdkk;
        this.zzglp = zzdvf;
        this.zzgmz = zzbfn;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza(boolean z, Context context) {
        zzbfn zzbfn;
        zzbfn zzbfn2;
        zzchl zzchl = (zzchl) zzdux.zzb(this.zzglp);
        try {
            zzdkk zzdkk = this.zzfol;
            if (!this.zzgmz.zzabo()) {
                zzbfn2 = this.zzgmz;
            } else {
                if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcnu)).booleanValue()) {
                    zzbfn2 = this.zzgmz;
                } else {
                    zzbfn zzc = this.zzfyz.zzc(this.zzfpv.zzboz);
                    zzahn.zza(zzc, zzchl.zzagd());
                    zzcim zzcim = new zzcim();
                    zzcim.zzc(this.zzvr, zzc.getView());
                    zzchl.zzafj().zzb(zzc, true);
                    zzc.zzaaz().zza(new zzcut(zzcim, zzc));
                    zzbgz zzaaz = zzc.zzaaz();
                    zzc.getClass();
                    zzaaz.zza(zzcus.zzq(zzc));
                    zzc.zzb(zzdkk.zzgzr.zzdof, zzdkk.zzgzr.zzdoh, null);
                    zzbfn = zzc;
                    zzbfn.zzax(true);
                    zzq.zzkw();
                    zzg zzg = new zzg(false, zzaye.zzbd(this.zzvr), false, 0.0f, -1, z, this.zzfol.zzfmx, this.zzfol.zzbor);
                    zzq.zzkv();
                    zzn.zza(context, new AdOverlayInfoParcel((zzuu) null, zzchl.zzafy(), (zzt) null, zzbfn, this.zzfol.zzgzz, this.zzbov, this.zzfol.zzdrk, zzg, this.zzfol.zzgzr.zzdof, this.zzfol.zzgzr.zzdoh), true);
                }
            }
            zzbfn = zzbfn2;
            zzbfn.zzax(true);
            zzq.zzkw();
            zzg zzg2 = new zzg(false, zzaye.zzbd(this.zzvr), false, 0.0f, -1, z, this.zzfol.zzfmx, this.zzfol.zzbor);
            zzq.zzkv();
            zzn.zza(context, new AdOverlayInfoParcel((zzuu) null, zzchl.zzafy(), (zzt) null, zzbfn, this.zzfol.zzgzz, this.zzbov, this.zzfol.zzdrk, zzg2, this.zzfol.zzgzr.zzdof, this.zzfol.zzgzr.zzdoh), true);
        } catch (zzbfz e) {
            zzbba.zzc("", e);
        }
    }
}
