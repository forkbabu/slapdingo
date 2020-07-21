package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqn implements zzela<zzbqk> {
    private final zzelj<Clock> zzfmf;
    private final zzelj<zzaxg> zzfqk;

    private zzbqn(zzelj<Clock> zzelj, zzelj<zzaxg> zzelj2) {
        this.zzfmf = zzelj;
        this.zzfqk = zzelj2;
    }

    public static zzbqn zze(zzelj<Clock> zzelj, zzelj<zzaxg> zzelj2) {
        return new zzbqn(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbqk(this.zzfmf.get(), this.zzfqk.get());
    }
}
