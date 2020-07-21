package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbkp implements zzela<zzbbe> {
    private final zzelj<String> zzfkc;

    public zzbkp(zzelj<String> zzelj) {
        this.zzfkc = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbbe) zzelg.zza(new zzbbe(this.zzfkc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
