package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbkm implements zzela<zzazq> {
    private final zzelj<Context> zzere;

    public zzbkm(zzelj<Context> zzelj) {
        this.zzere = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzazq) zzelg.zza(new zzazq(this.zzere.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
