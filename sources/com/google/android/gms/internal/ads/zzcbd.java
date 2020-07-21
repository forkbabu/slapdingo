package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbd implements zzela<zzccv> {
    private final zzcay zzfup;

    private zzcbd(zzcay zzcay) {
        this.zzfup = zzcay;
    }

    public static zzcbd zzd(zzcay zzcay) {
        return new zzcbd(zzcay);
    }

    public static zzccv zze(zzcay zzcay) {
        return (zzccv) zzelg.zza(zzcay.zzakn(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zze(this.zzfup);
    }
}
