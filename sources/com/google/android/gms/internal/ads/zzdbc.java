package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbc implements zzela<zzdki> {
    private final zzelj<Clock> zzfmf;

    public zzdbc(zzelj<Clock> zzelj) {
        this.zzfmf = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzdki) zzelg.zza(new zzdki(this.zzfmf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
