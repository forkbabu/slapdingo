package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbsd implements zzela<zzbrx.zza> {
    private final zzbrx zzfrj;

    private zzbsd(zzbrx zzbrx) {
        this.zzfrj = zzbrx;
    }

    public static zzbsd zzl(zzbrx zzbrx) {
        return new zzbsd(zzbrx);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbrx.zza) zzelg.zza(this.zzfrj.zzaiu(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
