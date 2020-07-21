package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbil implements zzela<zzcqu<zzdlm, zzcsc>> {
    private final zzbie zzeqy;
    private final zzelj<zzcix> zzeqz;

    public zzbil(zzbie zzbie, zzelj<zzcix> zzelj) {
        this.zzeqy = zzbie;
        this.zzeqz = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzcqu) zzelg.zza(new zzcul(this.zzeqz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
