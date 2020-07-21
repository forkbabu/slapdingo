package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcol implements zzcom {
    private final zzdvi zzgad;
    private final Map<String, zzelj<zzcom>> zzghx;
    /* access modifiers changed from: private */
    public final zzbuv zzghy;

    public zzcol(Map<String, zzelj<zzcom>> map, zzdvi zzdvi, zzbuv zzbuv) {
        this.zzghx = map;
        this.zzgad = zzdvi;
        this.zzghy = zzbuv;
    }

    @Override // com.google.android.gms.internal.ads.zzcom
    public final zzdvf<zzdkw> zzh(zzasm zzasm) {
        this.zzghy.zzd(zzasm);
        zzdvf<zzdkw> immediateFailedFuture = zzdux.immediateFailedFuture(new zzcmi(zzdls.zzhbs));
        for (String str : ((String) zzwg.zzpw().zzd(zzaav.zzcxp)).split(",")) {
            zzelj<zzcom> zzelj = this.zzghx.get(str.trim());
            if (zzelj != null) {
                immediateFailedFuture = zzdux.zzb(immediateFailedFuture, zzcmi.class, new zzcok(zzelj, zzasm), this.zzgad);
            }
        }
        zzdux.zza(immediateFailedFuture, new zzcon(this), zzbbf.zzedm);
        return immediateFailedFuture;
    }
}
