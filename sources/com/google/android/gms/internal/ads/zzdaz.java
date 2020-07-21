package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdaz implements zzela<zzday<zzdef>> {
    private final zzelj<zzdei> zzesp;
    private final zzelj<Clock> zzfmf;

    public zzdaz(zzelj<zzdei> zzelj, zzelj<Clock> zzelj2) {
        this.zzesp = zzelj;
        this.zzfmf = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzday) zzelg.zza(new zzday(this.zzesp.get(), zzacd.zzczg.get().longValue(), this.zzfmf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
