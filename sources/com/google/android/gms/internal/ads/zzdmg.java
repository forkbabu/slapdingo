package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdmg implements zzela<Context> {
    private final zzdmb zzhca;
    private final zzelj<zzdlz> zzhcc;

    private zzdmg(zzdmb zzdmb, zzelj<zzdlz> zzelj) {
        this.zzhca = zzdmb;
        this.zzhcc = zzelj;
    }

    public static zzdmg zzc(zzdmb zzdmb, zzelj<zzdlz> zzelj) {
        return new zzdmg(zzdmb, zzelj);
    }

    public static Context zzb(zzdmb zzdmb, zzdlz zzdlz) {
        return (Context) zzelg.zza(zzdlz.zzaah, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzhca, this.zzhcc.get());
    }
}
