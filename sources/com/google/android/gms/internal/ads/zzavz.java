package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzavz implements zzawo {
    private final String zzdfo;
    private final Bundle zzdws;

    zzavz(String str, Bundle bundle) {
        this.zzdfo = str;
        this.zzdws = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzawo
    public final void zza(zzbhy zzbhy) {
        zzbhy.logEvent("am", this.zzdfo, this.zzdws);
    }
}
