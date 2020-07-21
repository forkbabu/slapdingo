package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxu implements zzela<Set<zzbyg<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbxa zzftd;

    private zzbxu(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxu zzaa(zzbxa zzbxa) {
        return new zzbxu(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
