package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrp implements zzcqw<zzbnc, zzaox, zzcsd> {
    /* access modifiers changed from: private */
    public View view;
    private final zzbny zzgkn;
    private final Context zzvr;

    public zzcrp(Context context, zzbny zzbny) {
        this.zzvr = context;
        this.zzgkn = zzbny;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzaox, zzcsd> zzcqv) throws zzdlg {
        try {
            zzcqv.zzdka.zzdq(zzdkk.zzdla);
            zzcqv.zzdka.zza(zzdkk.zzepm, zzdkk.zzgzu.toString(), zzdkw.zzhat.zzfpv.zzhay, ObjectWrapper.wrap(this.zzvr), new zzcrq(this, zzcqv), zzcqv.zzgki, zzdkw.zzhat.zzfpv.zzboz);
        } catch (RemoteException e) {
            throw new zzdlg(e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzbnc zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzaox, zzcsd> zzcqv) throws zzdlg, zzctw {
        zzbnf zza = this.zzgkn.zza(new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp), new zzbnj(this.view, null, new zzcro(zzcqv), zzdkk.zzgzt.get(0)));
        zza.zzafo().zzv(this.view);
        zzcqv.zzgki.zzb(zza.zzaen());
        return zza.zzafn();
    }

    static final /* synthetic */ zzyi zza(zzcqv zzcqv) throws zzdlg {
        try {
            return zzcqv.zzdka.getVideoController();
        } catch (RemoteException e) {
            throw new zzdlg(e);
        }
    }
}
