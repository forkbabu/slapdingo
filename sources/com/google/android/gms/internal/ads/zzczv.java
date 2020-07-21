package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczv implements zzdec<zzczw> {
    private final zzdla zzfpv;
    private final zzdvi zzgad;

    public zzczv(zzdvi zzdvi, zzdla zzdla) {
        this.zzgad = zzdvi;
        this.zzfpv = zzdla;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzczw> zzaqm() {
        return this.zzgad.zze(new zzczy(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzczw zzaqp() throws Exception {
        return new zzczw(this.zzfpv.zzhbc);
    }
}
