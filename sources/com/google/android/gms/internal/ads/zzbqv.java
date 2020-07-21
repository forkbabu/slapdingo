package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqv implements zzela<zzc> {
    private final zzelj<Context> zzere;
    private final zzbqs zzfqn;
    private final zzelj<zzavr> zzfqo;

    private zzbqv(zzbqs zzbqs, zzelj<Context> zzelj, zzelj<zzavr> zzelj2) {
        this.zzfqn = zzbqs;
        this.zzere = zzelj;
        this.zzfqo = zzelj2;
    }

    public static zzbqv zza(zzbqs zzbqs, zzelj<Context> zzelj, zzelj<zzavr> zzelj2) {
        return new zzbqv(zzbqs, zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzc) zzelg.zza(new zzc(this.zzere.get(), this.zzfqo.get(), null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
