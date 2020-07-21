package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzaxf {
    private long zzdwz = -1;
    private long zzdxa = -1;
    private final /* synthetic */ zzaxg zzdxb;

    public zzaxf(zzaxg zzaxg) {
        this.zzdxb = zzaxg;
    }

    public final long zzvr() {
        return this.zzdxa;
    }

    public final void zzvs() {
        this.zzdxa = this.zzdxb.zzbqd.elapsedRealtime();
    }

    public final void zzvt() {
        this.zzdwz = this.zzdxb.zzbqd.elapsedRealtime();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzdwz);
        bundle.putLong("tclose", this.zzdxa);
        return bundle;
    }
}
