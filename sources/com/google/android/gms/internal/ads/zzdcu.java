package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcu implements zzdec<zzdcr> {
    private final Bundle zzfrg;
    private final zzdvi zzgad;

    public zzdcu(zzdvi zzdvi, Bundle bundle) {
        this.zzgad = zzdvi;
        this.zzfrg = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdcr> zzaqm() {
        return this.zzgad.zze(new zzdct(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdcr zzaqw() throws Exception {
        return new zzdcr(this.zzfrg);
    }
}
