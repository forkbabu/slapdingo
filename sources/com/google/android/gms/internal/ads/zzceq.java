package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzceq implements zzela<zzbyg<VideoController.VideoLifecycleCallbacks>> {
    private final zzelj<zzchf> zzfmj;
    private final zzelj<Executor> zzfnr;
    private final zzcel zzfzy;

    public zzceq(zzcel zzcel, zzelj<zzchf> zzelj, zzelj<Executor> zzelj2) {
        this.zzfzy = zzcel;
        this.zzfmj = zzelj;
        this.zzfnr = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmj.get(), this.zzfnr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
