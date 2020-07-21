package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczt implements zzela<zzczr> {
    private final zzelj<zzcix> zzeqz;
    private final zzelj<zzdvi> zzgrl;
    private final zzelj<String> zzgrz;

    private zzczt(zzelj<String> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzcix> zzelj3) {
        this.zzgrz = zzelj;
        this.zzgrl = zzelj2;
        this.zzeqz = zzelj3;
    }

    public static zzczt zzq(zzelj<String> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzcix> zzelj3) {
        return new zzczt(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzczr(this.zzgrz.get(), this.zzgrl.get(), this.zzeqz.get());
    }
}
