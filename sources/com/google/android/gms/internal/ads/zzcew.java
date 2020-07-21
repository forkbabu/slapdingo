package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcew implements Callable {
    private final zzdvf zzfpl;
    private final zzdvf zzfrf;
    private final zzceu zzgag;
    private final zzdvf zzgah;
    private final zzdvf zzgai;
    private final zzdvf zzgaj;
    private final JSONObject zzgak;
    private final zzdvf zzgal;
    private final zzdvf zzgam;
    private final zzdvf zzgan;

    zzcew(zzceu zzceu, zzdvf zzdvf, zzdvf zzdvf2, zzdvf zzdvf3, zzdvf zzdvf4, zzdvf zzdvf5, JSONObject jSONObject, zzdvf zzdvf6, zzdvf zzdvf7, zzdvf zzdvf8) {
        this.zzgag = zzceu;
        this.zzfrf = zzdvf;
        this.zzfpl = zzdvf2;
        this.zzgah = zzdvf3;
        this.zzgai = zzdvf4;
        this.zzgaj = zzdvf5;
        this.zzgak = jSONObject;
        this.zzgal = zzdvf6;
        this.zzgam = zzdvf7;
        this.zzgan = zzdvf8;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzdvf zzdvf = this.zzfrf;
        zzdvf zzdvf2 = this.zzfpl;
        zzdvf zzdvf3 = this.zzgah;
        zzdvf zzdvf4 = this.zzgai;
        zzdvf zzdvf5 = this.zzgaj;
        JSONObject jSONObject = this.zzgak;
        zzdvf zzdvf6 = this.zzgal;
        zzdvf zzdvf7 = this.zzgam;
        zzdvf zzdvf8 = this.zzgan;
        zzcck zzcck = (zzcck) zzdvf.get();
        zzcck.setImages((List) zzdvf2.get());
        zzcck.zza((zzadt) zzdvf3.get());
        zzcck.zzb((zzadt) zzdvf4.get());
        zzcck.zza((zzadl) zzdvf5.get());
        zzcck.zzh(zzcey.zzj(jSONObject));
        zzcck.zza(zzcey.zzk(jSONObject));
        zzbfn zzbfn = (zzbfn) zzdvf6.get();
        if (zzbfn != null) {
            zzcck.zzi(zzbfn);
            zzcck.zzac(zzbfn.getView());
            zzcck.zzb(zzbfn.zzzj());
        }
        zzbfn zzbfn2 = (zzbfn) zzdvf7.get();
        if (zzbfn2 != null) {
            zzcck.zzj(zzbfn2);
        }
        for (zzcfn zzcfn : (List) zzdvf8.get()) {
            int i = zzcfn.type;
            if (i == 1) {
                zzcck.zzn(zzcfn.zzcn, zzcfn.zzgbb);
            } else if (i == 2) {
                zzcck.zza(zzcfn.zzcn, zzcfn.zzgbc);
            }
        }
        return zzcck;
    }
}
