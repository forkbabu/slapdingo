package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbub implements zzela<zzbtz> {
    private final zzelj<Set<zzbyg<AdMetadataListener>>> zzfnx;

    private zzbub(zzelj<Set<zzbyg<AdMetadataListener>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbub zzm(zzelj<Set<zzbyg<AdMetadataListener>>> zzelj) {
        return new zzbub(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbtz(this.zzfnx.get());
    }
}
