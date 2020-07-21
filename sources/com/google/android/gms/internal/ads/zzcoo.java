package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcoo {
    private final zzdvi zzgad;
    private final zzeku<zzcoy> zzggi;
    private final zzcof zzgia;

    public zzcoo(zzdvi zzdvi, zzcof zzcof, zzeku<zzcoy> zzeku) {
        this.zzgad = zzdvi;
        this.zzgia = zzcof;
        this.zzggi = zzeku;
    }

    private final <RetT> zzdvf<RetT> zza(zzasm zzasm, zzcoz<InputStream> zzcoz, zzcoz<InputStream> zzcoz2, zzduh<InputStream, RetT> zzduh) {
        zzdvf zzdvf;
        String str = zzasm.packageName;
        zzq.zzkw();
        if (zzaye.zzeq(str)) {
            zzdvf = zzdux.immediateFailedFuture(new zzcop(zzdls.zzhbq));
        } else {
            zzdvf = zzdux.zzb(zzcoz.zzq(zzasm), ExecutionException.class, zzcor.zzboi, this.zzgad);
        }
        return zzduo.zzg(zzdvf).zzb(zzduh, this.zzgad).zza(zzcop.class, new zzcoq(this, zzcoz2, zzasm, zzduh), this.zzgad);
    }

    public final zzdvf<zzasm> zzl(zzasm zzasm) {
        zzcot zzcot = new zzcot(zzasm);
        zzcof zzcof = this.zzgia;
        zzcof.getClass();
        return zza(zzasm, zzcos.zza(zzcof), new zzcov(this), zzcot);
    }

    public final zzdvf<Void> zzm(zzasm zzasm) {
        if (zzfg.zzar(zzasm.zzdsu)) {
            return zzdux.immediateFailedFuture(new zzcmi(zzdls.zzhbr, "Pool key missing from removeUrl call."));
        }
        return zza(zzasm, new zzcox(this), new zzcow(this), zzcou.zzboi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzn(zzasm zzasm) {
        return this.zzggi.get().zzgm(zzasm.zzdsu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzo(zzasm zzasm) {
        return this.zzgia.zzgl(zzasm.zzdsu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzp(zzasm zzasm) {
        return this.zzggi.get().zzc(zzasm, Binder.getCallingUid());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzcoz zzcoz, zzasm zzasm, zzduh zzduh, zzcop zzcop) throws Exception {
        return zzdux.zzb(zzcoz.zzq(zzasm), zzduh, this.zzgad);
    }
}
