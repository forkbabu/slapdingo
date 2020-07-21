package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbso extends zzbwv<zzbsq> implements zzbsq {
    public zzbso(Set<zzbyg<zzbsq>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbsq
    public final void onAdFailedToLoad(int i) {
        zza(new zzbsn(i));
    }
}
