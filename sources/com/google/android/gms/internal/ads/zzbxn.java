package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxn implements zzela<Set<zzbyg<AdMetadataListener>>> {
    private final zzbxa zzftd;

    private zzbxn(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxn zzt(zzbxa zzbxa) {
        return new zzbxn(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzajp(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
