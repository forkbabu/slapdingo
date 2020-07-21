package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbt implements zzela<zzdbr> {
    private final zzelj<zzdvi> zzerc;

    private zzdbt(zzelj<zzdvi> zzelj) {
        this.zzerc = zzelj;
    }

    public static zzdbt zzan(zzelj<zzdvi> zzelj) {
        return new zzdbt(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdbr(this.zzerc.get());
    }
}
