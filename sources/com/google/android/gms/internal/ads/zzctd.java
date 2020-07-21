package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctd implements zzela<zzcsx> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzceu> zzfbx;
    private final zzelj<zzcbc> zzgkp;
    private final zzelj<zzdll<zzcgr>> zzgma;

    public zzctd(zzelj<zzcbc> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzceu> zzelj3, zzelj<zzdll<zzcgr>> zzelj4) {
        this.zzgkp = zzelj;
        this.zzerc = zzelj2;
        this.zzfbx = zzelj3;
        this.zzgma = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcsx(this.zzgkp.get(), this.zzerc.get(), this.zzfbx.get(), this.zzgma.get());
    }
}
