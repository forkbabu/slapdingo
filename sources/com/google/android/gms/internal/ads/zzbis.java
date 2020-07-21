package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbis implements zzela<zzdll<zzcgr>> {
    private final zzelj<zzchb> zzerb;
    private final zzelj<zzdvi> zzerc;

    public zzbis(zzelj<zzchb> zzelj, zzelj<zzdvi> zzelj2) {
        this.zzerb = zzelj;
        this.zzerc = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzdll) zzelg.zza(new zzdll(this.zzerb.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
