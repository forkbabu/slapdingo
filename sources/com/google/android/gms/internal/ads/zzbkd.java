package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbkd implements zzela<zza> {
    private final zzbkb zzfjq;

    public zzbkd(zzbkb zzbkb) {
        this.zzfjq = zzbkb;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zza) zzelg.zza(this.zzfjq.zzagi(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
