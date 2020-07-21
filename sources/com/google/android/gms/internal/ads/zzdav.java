package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdav implements zzela<zzdat> {
    private final zzelj<zzdhv> zzfuh;

    private zzdav(zzelj<zzdhv> zzelj) {
        this.zzfuh = zzelj;
    }

    public static zzdav zzam(zzelj<zzdhv> zzelj) {
        return new zzdav(zzelj);
    }

    public static zzdat zzb(zzdhv zzdhv) {
        return new zzdat(zzdhv);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzfuh.get());
    }
}
