package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfk implements zzdec<zzdfh> {
    private zzdvi zzgad;
    zzta zzgvm;
    Context zzvr;

    public zzdfk(zzta zzta, zzdvi zzdvi, Context context) {
        this.zzgvm = zzta;
        this.zzgad = zzdvi;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdfh> zzaqm() {
        return this.zzgad.zze(new zzdfj(this));
    }
}
