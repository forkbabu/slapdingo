package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbkn implements zzela<zzdpx> {
    private final zzelj<Context> zzere;

    public zzbkn(zzelj<Context> zzelj) {
        this.zzere = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzdpx) zzelg.zza(new zzdpx(this.zzere.get(), zzq.zzlk().zzya()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
