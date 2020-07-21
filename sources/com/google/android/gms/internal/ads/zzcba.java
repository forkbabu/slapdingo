package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcba implements zzela<zzcay> {
    private final zzcay zzfup;

    private zzcba(zzcay zzcay) {
        this.zzfup = zzcay;
    }

    public static zzcba zzc(zzcay zzcay) {
        return new zzcba(zzcay);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        zzcay zzcay = this.zzfup;
        if (zzcay != null) {
            return (zzcay) zzelg.zza(zzcay, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
