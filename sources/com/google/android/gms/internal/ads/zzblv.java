package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblv implements zzela<zzbls> {
    private final zzelj<Context> zzere;
    private final zzelj<zzqn> zzflu;

    private zzblv(zzelj<Context> zzelj, zzelj<zzqn> zzelj2) {
        this.zzere = zzelj;
        this.zzflu = zzelj2;
    }

    public static zzblv zza(zzelj<Context> zzelj, zzelj<zzqn> zzelj2) {
        return new zzblv(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbls(this.zzere.get(), this.zzflu.get());
    }
}
