package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzddv implements zzddz {
    private final Bundle zzguf;

    zzddv(Bundle bundle) {
        this.zzguf = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzddz
    public final void zzs(Object obj) {
        ((Bundle) obj).putBundle("shared_pref", this.zzguf);
    }
}
