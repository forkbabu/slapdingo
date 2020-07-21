package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcte implements zzcqw<zzccd, zzaox, zzcsd> {
    private final zzcbc zzglu;
    /* access modifiers changed from: private */
    public zzang zzgmb;
    private final Context zzvr;

    public zzcte(Context context, zzcbc zzcbc) {
        this.zzvr = context;
        this.zzglu = zzcbc;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzaox, zzcsd> zzcqv) throws zzdlg {
        try {
            zzcqv.zzdka.zzdq(zzdkk.zzdla);
            zzcqv.zzdka.zza(zzdkk.zzepm, zzdkk.zzgzu.toString(), zzdkw.zzhat.zzfpv.zzhay, ObjectWrapper.wrap(this.zzvr), new zzctg(this, zzcqv), zzcqv.zzgki);
        } catch (RemoteException e) {
            throw new zzdlg(e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzccd zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzaox, zzcsd> zzcqv) throws zzdlg, zzctw {
        if (zzdkw.zzhat.zzfpv.zzhba.contains(Integer.toString(6))) {
            zzcck zzb = zzcck.zzb(this.zzgmb);
            if (zzdkw.zzhat.zzfpv.zzhba.contains(Integer.toString(zzb.zzalg()))) {
                zzccp zza = this.zzglu.zza(new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp), new zzccw(zzb), new zzcel(null, null, this.zzgmb));
                zzcqv.zzgki.zzb(zza.zzaen());
                return zza.zzaeo();
            }
            throw new zzctw(zzdls.zzhbq, "No corresponding native ad listener");
        }
        throw new zzctw(zzdls.zzhbr, "Unified must be used for RTB.");
    }
}
