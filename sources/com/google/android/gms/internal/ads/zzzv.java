package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzv extends zzyb {
    private final OnPaidEventListener zzcko;

    public zzzv(OnPaidEventListener onPaidEventListener) {
        this.zzcko = onPaidEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final void zza(zzvj zzvj) {
        if (this.zzcko != null) {
            this.zzcko.onPaidEvent(AdValue.zza(zzvj.zzacz, zzvj.zzada, zzvj.zzadb));
        }
    }
}
