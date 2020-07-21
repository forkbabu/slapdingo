package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbu implements zzela<zzcgr> {
    private final zzcbr zzfvs;

    public zzcbu(zzcbr zzcbr) {
        this.zzfvs = zzcbr;
    }

    public static zzcgr zza(zzcbr zzcbr) {
        return (zzcgr) zzelg.zza(zzcbr.zzakz(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfvs);
    }
}
