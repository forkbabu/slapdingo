package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcr implements zzddz<Bundle> {
    private final Bundle zzfrg;

    public zzdcr(Bundle bundle) {
        this.zzfrg = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundle3 = this.zzfrg;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
    }
}
