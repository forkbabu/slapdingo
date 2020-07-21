package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbx implements zzela<zzdbv> {
    private final zzelj<zzdvi> zzerc;

    private zzdbx(zzelj<zzdvi> zzelj) {
        this.zzerc = zzelj;
    }

    public static zzdbx zzao(zzelj<zzdvi> zzelj) {
        return new zzdbx(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdbv(this.zzerc.get());
    }
}
