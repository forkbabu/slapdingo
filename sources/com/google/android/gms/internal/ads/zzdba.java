package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdba implements zzela<zzday<zzdap>> {
    private final zzelj<Clock> zzfmf;
    private final zzelj<zzdas> zzgsv;

    public zzdba(zzelj<zzdas> zzelj, zzelj<Clock> zzelj2) {
        this.zzgsv = zzelj;
        this.zzfmf = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzday) zzelg.zza(new zzday(this.zzgsv.get(), 10000, this.zzfmf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
