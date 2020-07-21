package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbs implements zzela<zzcco> {
    private final zzelj<zzccr> zzetv;
    private final zzcbr zzfvs;

    public zzcbs(zzcbr zzcbr, zzelj<zzccr> zzelj) {
        this.zzfvs = zzcbr;
        this.zzetv = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzcco) zzelg.zza(this.zzetv.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
