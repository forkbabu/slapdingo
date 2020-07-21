package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrp implements zzela<zzbus> {
    private final zzelj<zzbus> zzfqt;

    private zzbrp(zzelj<zzbus> zzelj) {
        this.zzfqt = zzelj;
    }

    public static zzbrp zzf(zzelj<zzbus> zzelj) {
        return new zzbrp(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbus) zzelg.zza(this.zzfqt.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
