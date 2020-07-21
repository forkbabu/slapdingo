package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdmd implements zzela<zzdlz> {
    private final zzelj<zzdlx> zzfmc;
    private final zzdmb zzhca;
    private final zzelj<String> zzhcb;

    private zzdmd(zzdmb zzdmb, zzelj<zzdlx> zzelj, zzelj<String> zzelj2) {
        this.zzhca = zzdmb;
        this.zzfmc = zzelj;
        this.zzhcb = zzelj2;
    }

    public static zzdmd zza(zzdmb zzdmb, zzelj<zzdlx> zzelj, zzelj<String> zzelj2) {
        return new zzdmd(zzdmb, zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzdlz) zzelg.zza(this.zzfmc.get().zzgu(this.zzhcb.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
