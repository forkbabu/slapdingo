package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdds implements zzdec<zzddz<Bundle>> {
    private final boolean zzgue;

    zzdds(zzdir zzdir) {
        if (zzdir != null) {
            this.zzgue = true;
        } else {
            this.zzgue = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddz<Bundle>> zzaqm() {
        return zzdux.zzaf(this.zzgue ? zzddr.zzgud : null);
    }
}
