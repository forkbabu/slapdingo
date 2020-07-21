package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbn implements zzdec<zzdbo> {
    private final zzdvi zzgad;
    private final Context zzvr;

    public zzdbn(Context context, zzdvi zzdvi) {
        this.zzvr = context;
        this.zzgad = zzdvi;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdbo> zzaqm() {
        return this.zzgad.zze(new zzdbq(this));
    }
}
