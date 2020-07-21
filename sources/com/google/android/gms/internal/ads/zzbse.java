package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbse implements zzela<zzdla> {
    private final zzbrx zzfrj;

    private zzbse(zzbrx zzbrx) {
        this.zzfrj = zzbrx;
    }

    public static zzbse zzm(zzbrx zzbrx) {
        return new zzbse(zzbrx);
    }

    public static zzdla zzn(zzbrx zzbrx) {
        return (zzdla) zzelg.zza(zzbrx.zzaiv(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzn(this.zzfrj);
    }
}
