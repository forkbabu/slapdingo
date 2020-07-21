package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdat implements zzdec<zzddz<Bundle>> {
    private final zzdhv zzgso;

    zzdat(zzdhv zzdhv) {
        this.zzgso = zzdhv;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddz<Bundle>> zzaqm() {
        zzdhv zzdhv = this.zzgso;
        return zzdux.zzaf((zzdhv == null || zzdhv.zzarx() == null || this.zzgso.zzarx().isEmpty()) ? null : new zzdaw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(Bundle bundle) {
        bundle.putString("key_schema", this.zzgso.zzarx());
    }
}
