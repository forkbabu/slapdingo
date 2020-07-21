package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcek implements zzela<zzccs> {
    private final zzelj<zzcej> zzfei;
    private final zzcel zzfzy;

    public zzcek(zzcel zzcel, zzelj<zzcej> zzelj) {
        this.zzfzy = zzcel;
        this.zzfei = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzccs) zzelg.zza(this.zzfei.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
