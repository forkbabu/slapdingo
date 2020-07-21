package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczp implements zzddz<Bundle> {
    private final Bundle zzgrx;

    private zzczp(Bundle bundle) {
        this.zzgrx = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (!this.zzgrx.isEmpty()) {
            bundle2.putBundle("installed_adapter_data", this.zzgrx);
        }
    }
}
