package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdca implements zzddz<Bundle> {
    private final zzdki zzfkk;

    public zzdca(zzdki zzdki) {
        this.zzfkk = zzdki;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdki zzdki = this.zzfkk;
        if (zzdki != null) {
            bundle2.putBoolean("render_in_browser", zzdki.zzase());
            bundle2.putBoolean("disable_ml", this.zzfkk.zzasf());
        }
    }
}
