package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbz implements zzdec<zzdca> {
    private final zzdki zzfkk;
    private final zzdvi zzgad;

    public zzdbz(zzdvi zzdvi, zzdki zzdki) {
        this.zzgad = zzdvi;
        this.zzfkk = zzdki;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdca> zzaqm() {
        return this.zzgad.zze(new zzdcc(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdca zzaqt() throws Exception {
        return new zzdca(this.zzfkk);
    }
}
