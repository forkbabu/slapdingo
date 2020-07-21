package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpb;
import com.google.android.gms.internal.ads.zzbrv;
import com.google.android.gms.internal.ads.zzty;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdhp<R extends zzbrv<AdT>, AdT extends zzbpb> implements zzdil<R, AdT> {
    private final Executor executor;
    private final zzdil<R, AdT> zzgwc;
    private final zzdil<R, zzdic<AdT>> zzgxi;
    private final zzdne<AdT> zzgxj;
    private R zzgxk;

    public zzdhp(zzdil<R, AdT> zzdil, zzdil<R, zzdic<AdT>> zzdil2, zzdne<AdT> zzdne, Executor executor2) {
        this.zzgwc = zzdil;
        this.zzgxi = zzdil2;
        this.zzgxj = zzdne;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzarw */
    public final synchronized R zzarv() {
        return this.zzgxk;
    }

    @Override // com.google.android.gms.internal.ads.zzdil
    public final synchronized zzdvf<AdT> zza(zzdiq zzdiq, zzdin<R> zzdin) {
        zzdla zzafe;
        zzafe = zzdin.zzc(zzdiq.zzgyh).zzaeg().zzafe();
        return zzduo.zzg(this.zzgxi.zza(zzdiq, zzdin)).zzb(new zzdhs(this, zzdiq, new zzdhw(zzdin, zzdiq, zzafe.zzhay, zzafe.zzhaz, this.executor, zzafe.zzhbc, null), zzdin), this.executor);
    }

    private final zzdvf<AdT> zza(zzdmw<AdT> zzdmw, zzdiq zzdiq, zzdin<R> zzdin) {
        zzbru<R> zzc = zzdin.zzc(zzdiq.zzgyh);
        if (zzdmw.zzhed != null) {
            R zzaeg = zzc.zzaeg();
            if (zzaeg.zzaff() != null) {
                zzdmw.zzhed.zzaii().zzb(zzaeg.zzaff());
            }
            return zzdux.zzaf(zzdmw.zzhed);
        }
        zzc.zza(zzdmw.zzetl);
        zzdvf<AdT> zza = this.zzgwc.zza(zzdiq, new zzdhr(zzc));
        this.zzgxk = this.zzgwc.zzarv();
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdin zzdin, zzdni zzdni) throws Exception {
        if (zzdni == null || zzdni.zzgyb == null || zzdni.zzhet == null) {
            throw new zzcmi(zzdls.zzhbq, "Empty prefetch");
        }
        zzdni.zzgyb.zzhec.zzair().zze((zzty.zzb) ((zzegb) zzty.zzb.zznf().zza(zzty.zzb.zza.zznh().zza(zzty.zzb.C0020zzb.IN_MEMORY).zza(zzty.zzb.zzd.zznj())).zzbfq()));
        return zza(zzdni.zzgyb, ((zzdhw) zzdni.zzhet).zzgxv, zzdin);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdiq zzdiq, zzdhw zzdhw, zzdin zzdin, zzdic zzdic) throws Exception {
        if (zzdic != null) {
            zzdhw zzdhw2 = new zzdhw(zzdhw.zzgxu, zzdhw.zzgxv, zzdhw.zzdpj, zzdhw.zzbum, zzdhw.executor, zzdhw.zzgsb, zzdic.zzgxw);
            if (zzdic.zzgyb != null) {
                this.zzgxk = null;
                this.zzgxj.zzb(zzdhw2);
                return zza(zzdic.zzgyb, zzdiq, zzdin);
            }
            zzdvf<zzdni<AdT>> zzc = this.zzgxj.zzc(zzdhw2);
            if (zzc != null) {
                this.zzgxk = zzdin.zzc(zzdiq.zzgyh).zzaeg();
                return zzdux.zzb(zzc, new zzdhu(this, zzdin), this.executor);
            }
            this.zzgxj.zzb(zzdhw2);
            zzdiq = new zzdiq(zzdiq.zzgyh, zzdic.zzghk);
        }
        zzdvf<AdT> zza = this.zzgwc.zza(zzdiq, zzdin);
        this.zzgxk = this.zzgwc.zzarv();
        return zza;
    }
}
