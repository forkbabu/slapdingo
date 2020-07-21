package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcki implements zzela<zzckh> {
    private final zzelj<zztm> zzgdq;
    private final zzelj<Map<zzdor, zzckj>> zzgdy;

    private zzcki(zzelj<zztm> zzelj, zzelj<Map<zzdor, zzckj>> zzelj2) {
        this.zzgdq = zzelj;
        this.zzgdy = zzelj2;
    }

    public static zzcki zzah(zzelj<zztm> zzelj, zzelj<Map<zzdor, zzckj>> zzelj2) {
        return new zzcki(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzckh(this.zzgdq.get(), this.zzgdy.get());
    }
}
