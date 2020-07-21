package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcuf implements zzcqw<zzchj, zzaox, zzcsd> {
    private final zzchm zzgmt;
    private final Context zzvr;

    public zzcuf(Context context, zzchm zzchm) {
        this.zzvr = context;
        this.zzgmt = zzchm;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzaox, zzcsd> zzcqv) throws zzdlg {
        try {
            zzcqv.zzdka.zzdq(zzdkk.zzdla);
            if (zzdkw.zzhat.zzfpv.zzhbf.zzhaj == zzdks.zzhan) {
                zzcqv.zzdka.zzb(zzdkk.zzepm, zzdkk.zzgzu.toString(), zzdkw.zzhat.zzfpv.zzhay, ObjectWrapper.wrap(this.zzvr), new zzcuh(this, zzcqv), zzcqv.zzgki);
            } else {
                zzcqv.zzdka.zza(zzdkk.zzepm, zzdkk.zzgzu.toString(), zzdkw.zzhat.zzfpv.zzhay, ObjectWrapper.wrap(this.zzvr), new zzcuh(this, zzcqv), zzcqv.zzgki);
            }
        } catch (RemoteException e) {
            zzaxv.zza("Remote exception loading a rewarded RTB ad", e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzchj zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzaox, zzcsd> zzcqv) throws zzdlg, zzctw {
        zzcsn zzcsn = new zzcsn(zzdkk, zzcqv.zzdka, true);
        zzchl zza = this.zzgmt.zza(new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp), new zzchk(zzcsn));
        zzcsn.zza(zza.zzaek());
        zzcqv.zzgki.zzb(zza.zzagf());
        return zza.zzagc();
    }
}
