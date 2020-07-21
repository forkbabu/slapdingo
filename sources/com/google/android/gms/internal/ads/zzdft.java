package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdft implements zzdec<zzdfu> {
    List<String> zzdpu;
    private zzdvi zzgad;
    zzaah zzgvs;

    public zzdft(zzaah zzaah, zzdvi zzdvi, List<String> list) {
        this.zzgvs = zzaah;
        this.zzgad = zzdvi;
        this.zzdpu = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdfu> zzaqm() {
        return this.zzgad.zze(new zzdfw(this));
    }
}
