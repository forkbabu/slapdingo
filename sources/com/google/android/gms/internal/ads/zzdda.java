package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdda implements zzdec<zzddz<Bundle>> {
    private final String zzfrh;
    private final Context zzvr;

    zzdda(Context context, String str) {
        this.zzvr = context;
        this.zzfrh = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddz<Bundle>> zzaqm() {
        zzdcz zzdcz;
        if (this.zzfrh == null) {
            zzdcz = null;
        } else {
            zzdcz = new zzdcz(this);
        }
        return zzdux.zzaf(zzdcz);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.zzvr.getPackageName());
    }
}
