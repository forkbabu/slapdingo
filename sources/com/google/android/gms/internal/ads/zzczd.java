package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczd implements zzela<zzcze> {
    private final zzelj<zzdla> zzfnz;

    private zzczd(zzelj<zzdla> zzelj) {
        this.zzfnz = zzelj;
    }

    public static zzczd zzak(zzelj<zzdla> zzelj) {
        return new zzczd(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcze(this.zzfnz.get());
    }
}
