package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrv;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdif<R extends zzbrv<? extends zzbpb>> {
    private final Executor executor;
    private final zzdin<R> zzgxu;
    private final zzdml zzgxz;
    private final zzdio zzgyc;
    /* access modifiers changed from: private */
    public zzdij zzgyd;

    public zzdif(zzdml zzdml, zzdio zzdio, zzdin<R> zzdin, Executor executor2) {
        this.zzgxz = zzdml;
        this.zzgyc = zzdio;
        this.zzgxu = zzdin;
        this.executor = executor2;
    }

    public final zzdvf<zzdij> zzasa() {
        zzdvf zzdvf;
        zzdij zzdij = this.zzgyd;
        if (zzdij != null) {
            return zzdux.zzaf(zzdij);
        }
        if (!zzacp.zzdat.get().booleanValue()) {
            zzdij zzdij2 = new zzdij(null, zzasb(), null);
            this.zzgyd = zzdij2;
            zzdvf = zzdux.zzaf(zzdij2);
        } else {
            zzdvf = zzduo.zzg(this.zzgxu.zzc(this.zzgyc).zza(new zzdhv(this.zzgxz.zzasy().zzhdn)).zzaeg().zzaex().zza(this.zzgxz.zzasy())).zza(new zzdik(this), this.executor).zza(zzcop.class, new zzdih(this), this.executor);
        }
        return zzdux.zzb(zzdvf, zzdii.zzdvt, this.executor);
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzdmv zzasb() {
        zzdla zzafe = this.zzgxu.zzc(this.zzgyc).zzaeg().zzafe();
        return this.zzgxz.zza(zzafe.zzhay, zzafe.zzhaz, zzafe.zzhbc);
    }
}
