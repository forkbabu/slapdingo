package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcld implements zzela<zzclb> {
    private final zzelj<Clock> zzfmf;
    private final zzelj<zzckv> zzget;
    private final zzelj<Set<zzcla>> zzgeu;

    private zzcld(zzelj<zzckv> zzelj, zzelj<Set<zzcla>> zzelj2, zzelj<Clock> zzelj3) {
        this.zzget = zzelj;
        this.zzgeu = zzelj2;
        this.zzfmf = zzelj3;
    }

    public static zzcld zzn(zzelj<zzckv> zzelj, zzelj<Set<zzcla>> zzelj2, zzelj<Clock> zzelj3) {
        return new zzcld(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzclb(this.zzget.get(), this.zzgeu.get(), this.zzfmf.get());
    }
}
