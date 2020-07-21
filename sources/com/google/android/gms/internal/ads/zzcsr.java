package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsr implements zzcqw<zzbzj, zzaox, zzcsd> {
    private final zzcae zzgkx;
    private final Context zzvr;

    public zzcsr(Context context, zzcae zzcae) {
        this.zzvr = context;
        this.zzgkx = zzcae;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzaox, zzcsd> zzcqv) throws zzdlg {
        try {
            zzcqv.zzdka.zzdq(zzdkk.zzdla);
            zzcqv.zzdka.zza(zzdkk.zzepm, zzdkk.zzgzu.toString(), zzdkw.zzhat.zzfpv.zzhay, ObjectWrapper.wrap(this.zzvr), new zzcst(this, zzcqv), zzcqv.zzgki);
        } catch (RemoteException e) {
            throw new zzdlg(e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzbzj zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzaox, zzcsd> zzcqv) throws zzdlg, zzctw {
        zzcsn zzcsn = new zzcsn(zzdkk, zzcqv.zzdka, false);
        zzbzl zza = this.zzgkx.zza(new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp), new zzbzk(zzcsn));
        zzcsn.zza(zza.zzaek());
        zzcqv.zzgki.zzb(zza.zzaen());
        return zza.zzafw();
    }
}
