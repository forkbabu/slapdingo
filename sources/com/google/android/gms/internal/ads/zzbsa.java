package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbsa implements zzela<Context> {
    private final zzelj<Context> zzfqq;
    private final zzbrx zzfrj;

    private zzbsa(zzbrx zzbrx, zzelj<Context> zzelj) {
        this.zzfrj = zzbrx;
        this.zzfqq = zzelj;
    }

    public static zzbsa zza(zzbrx zzbrx, zzelj<Context> zzelj) {
        return new zzbsa(zzbrx, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Context) zzelg.zza(this.zzfrj.zzcd(this.zzfqq.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
