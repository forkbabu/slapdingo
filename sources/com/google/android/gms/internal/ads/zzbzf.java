package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzf implements zzela<zzbyz> {
    private final zzelj<Set<zzbyg<VideoController.VideoLifecycleCallbacks>>> zzfnx;

    private zzbzf(zzelj<Set<zzbyg<VideoController.VideoLifecycleCallbacks>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbzf zzv(zzelj<Set<zzbyg<VideoController.VideoLifecycleCallbacks>>> zzelj) {
        return new zzbzf(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbyz(this.zzfnx.get());
    }
}
