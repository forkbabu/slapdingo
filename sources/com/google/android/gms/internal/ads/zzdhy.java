package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpb;
import com.google.android.gms.internal.ads.zzbrv;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdhy<R extends zzbrv<AdT>, AdT extends zzbpb> implements zzdil<R, zzdic<AdT>> {
    private final Executor executor;
    private final zzdml zzgxz;
    private zzduu<Void> zzgya = new zzdhz(this);

    public zzdhy(zzdml zzdml, Executor executor2) {
        this.zzgxz = zzdml;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzdil
    public final /* bridge */ /* synthetic */ Object zzarv() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdil
    public final zzdvf<zzdic<AdT>> zza(zzdiq zzdiq, zzdin<R> zzdin) {
        return zzduo.zzg(new zzdif(this.zzgxz, zzdiq.zzgyh, zzdin, this.executor).zzasa()).zzb(new zzdhx(this, zzdiq, zzdin), this.executor).zza(Exception.class, new zzdia(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzdiq zzdiq, zzdin zzdin, zzdij zzdij) throws Exception {
        zzdmv zzdmv = zzdij.zzgxw;
        zzasm zzasm = zzdij.zzghk;
        zzdmw<?> zza = zzdmv != null ? this.zzgxz.zza(zzdmv) : null;
        if (zzdmv == null) {
            return zzdux.zzaf(null);
        }
        if (!(zza == null || zzasm == null)) {
            zzdux.zza(((zzbrv) zzdin.zzc(zzdiq.zzgyh).zzaeg()).zzaex().zzc(zzasm), this.zzgya, this.executor);
        }
        return zzdux.zzaf(new zzdic(zzdmv, zzasm, zza));
    }
}
