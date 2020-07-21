package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbwl implements zzela<zzbwj> {
    private final zzelj<Set<zzbyg<AppEventListener>>> zzfnx;

    private zzbwl(zzelj<Set<zzbyg<AppEventListener>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbwl zzr(zzelj<Set<zzbyg<AppEventListener>>> zzelj) {
        return new zzbwl(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbwj(this.zzfnx.get());
    }
}
