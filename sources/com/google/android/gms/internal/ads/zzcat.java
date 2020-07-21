package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcat implements zzela<zzcaq> {
    private final zzelj<zzbtc> zzfug;
    private final zzelj<zzdkk> zzfuh;

    private zzcat(zzelj<zzbtc> zzelj, zzelj<zzdkk> zzelj2) {
        this.zzfug = zzelj;
        this.zzfuh = zzelj2;
    }

    public static zzcat zzw(zzelj<zzbtc> zzelj, zzelj<zzdkk> zzelj2) {
        return new zzcat(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcaq(this.zzfug.get(), this.zzfuh.get());
    }
}
