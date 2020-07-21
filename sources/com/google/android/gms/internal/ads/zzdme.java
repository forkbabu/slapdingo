package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdme implements zzela<zzaxx> {
    private final zzdmb zzhca;
    private final zzelj<zzdlz> zzhcc;

    private zzdme(zzdmb zzdmb, zzelj<zzdlz> zzelj) {
        this.zzhca = zzdmb;
        this.zzhcc = zzelj;
    }

    public static zzdme zza(zzdmb zzdmb, zzelj<zzdlz> zzelj) {
        return new zzdme(zzdmb, zzelj);
    }

    public static zzaxx zza(zzdmb zzdmb, zzdlz zzdlz) {
        return (zzaxx) zzelg.zza(zzdlz.zzdyn, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzhca, this.zzhcc.get());
    }
}
