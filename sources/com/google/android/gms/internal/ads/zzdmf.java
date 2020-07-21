package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdmf implements zzela<zzaxs> {
    private final zzdmb zzhca;
    private final zzelj<zzdlz> zzhcc;

    private zzdmf(zzdmb zzdmb, zzelj<zzdlz> zzelj) {
        this.zzhca = zzdmb;
        this.zzhcc = zzelj;
    }

    public static zzdmf zzb(zzdmb zzdmb, zzelj<zzdlz> zzelj) {
        return new zzdmf(zzdmb, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzaxs) zzelg.zza(this.zzhcc.get().zzdxc, "Cannot return null from a non-@Nullable @Provides method");
    }
}
