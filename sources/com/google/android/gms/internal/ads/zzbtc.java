package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbtc extends zzbwv<zzbtd> {
    private boolean zzfrt = false;

    public zzbtc(Set<zzbyg<zzbtd>> set) {
        super(set);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfrt) {
            zza(zzbtb.zzfrq);
            this.zzfrt = true;
        }
    }
}
