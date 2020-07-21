package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbmd implements zzela<zzalw> {
    private final zzelj<zzalr> zzfml;

    private zzbmd(zzelj<zzalr> zzelj) {
        this.zzfml = zzelj;
    }

    public static zzbmd zzb(zzelj<zzalr> zzelj) {
        return new zzbmd(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzalw) zzelg.zza(this.zzfml.get().zztg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
