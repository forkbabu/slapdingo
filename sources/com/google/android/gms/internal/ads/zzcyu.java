package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcyu implements zzduh<zzasm, zzcyv> {
    private Executor executor;
    private zzcnf zzgre;

    public zzcyu(Executor executor2, zzcnf zzcnf) {
        this.executor = executor2;
        this.zzgre = zzcnf;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdvf' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduh
    public final /* synthetic */ zzdvf<zzcyv> zzf(zzasm zzasm) throws Exception {
        zzasm zzasm2 = zzasm;
        return zzdux.zzb(this.zzgre.zzg(zzasm2), new zzcyt(zzasm2), this.executor);
    }
}
