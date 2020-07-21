package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcdc implements zzela<zzcck> {
    private final zzccw zzfxu;

    private zzcdc(zzccw zzccw) {
        this.zzfxu = zzccw;
    }

    public static zzcdc zza(zzccw zzccw) {
        return new zzcdc(zzccw);
    }

    public static zzcck zzb(zzccw zzccw) {
        return (zzcck) zzelg.zza(zzccw.zzamc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzfxu);
    }
}
