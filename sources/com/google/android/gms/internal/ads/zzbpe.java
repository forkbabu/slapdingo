package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbpe<AdT> implements zzela<zzbpf<AdT>> {
    private final zzelj<Map<String, zzcqt<AdT>>> zzfpe;

    private zzbpe(zzelj<Map<String, zzcqt<AdT>>> zzelj) {
        this.zzfpe = zzelj;
    }

    public static <AdT> zzbpe<AdT> zzd(zzelj<Map<String, zzcqt<AdT>>> zzelj) {
        return new zzbpe<>(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbpf(this.zzfpe.get());
    }
}
