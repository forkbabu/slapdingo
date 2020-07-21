package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfp implements zzdec<zzdfq> {
    private String packageName;
    private zzdvi zzgad;
    private zzawz zzgvp;

    public zzdfp(zzawz zzawz, zzdvi zzdvi, String str) {
        this.zzgvp = zzawz;
        this.zzgad = zzdvi;
        this.packageName = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdfq> zzaqm() {
        new zzbbn();
        zzdvf<String> zzaf = zzdux.zzaf(null);
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuu)).booleanValue()) {
            zzaf = this.zzgvp.zzef(this.packageName);
        }
        zzdvf<String> zzeg = this.zzgvp.zzeg(this.packageName);
        return zzdux.zzb(zzaf, zzeg).zza(new zzdfs(zzaf, zzeg), zzbbf.zzedh);
    }
}
