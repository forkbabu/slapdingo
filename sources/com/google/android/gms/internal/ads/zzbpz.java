package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbpz<T> {
    private final Executor executor;
    private final zzcni zzfpt;
    private final zzcns zzfpu;
    private final zzdla zzfpv;
    private final zzdou zzfpw;
    private final zzbla zzfpx;
    private final zzctz<T> zzfpy;
    /* access modifiers changed from: private */
    public final zzbwo zzfpz;
    private final zzdkw zzfqa;
    private final zzcoo zzfqb;
    private final zzbrq zzfqc;
    private final zzcol zzfqd;

    zzbpz(zzcni zzcni, zzcns zzcns, zzdla zzdla, zzdou zzdou, zzbla zzbla, zzctz<T> zzctz, zzbwo zzbwo, zzdkw zzdkw, zzcoo zzcoo, zzbrq zzbrq, Executor executor2, zzcol zzcol) {
        this.zzfpt = zzcni;
        this.zzfpu = zzcns;
        this.zzfpv = zzdla;
        this.zzfpw = zzdou;
        this.zzfpx = zzbla;
        this.zzfpy = zzctz;
        this.zzfpz = zzbwo;
        this.zzfqa = zzdkw;
        this.zzfqb = zzcoo;
        this.zzfqc = zzbrq;
        this.executor = executor2;
        this.zzfqd = zzcol;
    }

    private final zzdvf<zzdkw> zza(zzdvf<zzasm> zzdvf) {
        if (this.zzfqa != null) {
            return this.zzfpw.zzu(zzdor.SERVER_TRANSACTION).zze(zzdux.zzaf(this.zzfqa)).zzaus();
        }
        zzq.zzlc().zzmu();
        if (this.zzfpv.zzhay.zzchg != null) {
            return this.zzfpw.zzu(zzdor.SERVER_TRANSACTION).zze(this.zzfpu.zzapd()).zzaus();
        }
        if (!zzwg.zzpw().zzd(zzaav.zzcxo).booleanValue()) {
            return this.zzfpw.zza(zzdor.SERVER_TRANSACTION, zzdvf).zza(this.zzfpt).zzaus();
        }
        zzdom zza = this.zzfpw.zza(zzdor.SERVER_TRANSACTION, zzdvf);
        zzcol zzcol = this.zzfqd;
        zzcol.getClass();
        return zza.zza(zzbpy.zza(zzcol)).zzaus();
    }

    public final zzdvf<zzdkw> zza(zzasm zzasm) {
        return zza(zzdux.zzaf(zzasm));
    }

    public final zzdvf<zzdkw> zzaip() {
        return zza(this.zzfqc.zzait());
    }

    public final zzdvf<T> zzb(zzdvf<zzdkw> zzdvf) {
        if (zzwg.zzpw().zzd(zzaav.zzcuf).booleanValue()) {
            return this.zzfpw.zza(zzdor.RENDERER, zzdvf).zza(this.zzfpx).zza(this.zzfpy).zzaus();
        }
        return this.zzfpw.zza(zzdor.RENDERER, zzdvf).zza(this.zzfpx).zza(this.zzfpy).zza((long) zzwg.zzpw().zzd(zzaav.zzcug).intValue(), TimeUnit.SECONDS).zzaus();
    }

    public final zzdvf<T> zzb(zzasm zzasm) {
        return zzb(zza(zzasm));
    }

    public final zzdvf<T> zzaiq() {
        return zzb(zzaip());
    }

    public final zzbwo zzair() {
        return this.zzfpz;
    }

    public final zzdvf<zzasm> zza(zzdms zzdms) {
        zzdod zzaus = this.zzfpw.zza(zzdor.GET_CACHE_KEY, this.zzfqc.zzait()).zza(new zzbqb(this, zzdms)).zzaus();
        zzdux.zza(zzaus, new zzbqa(this), this.executor);
        return zzaus;
    }

    public final zzdvf<Void> zzc(zzasm zzasm) {
        zzdod zzaus = this.zzfpw.zza(zzdor.NOTIFY_CACHE_HIT, this.zzfqb.zzm(zzasm)).zzaus();
        zzdux.zza(zzaus, new zzbqd(this), this.executor);
        return zzaus;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdms zzdms, zzasm zzasm) throws Exception {
        zzasm.zzdst = zzdms;
        return this.zzfqb.zzl(zzasm);
    }
}
