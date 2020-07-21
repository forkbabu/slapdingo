package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdlu implements zzela<Clock> {
    private final zzdlr zzhbw;

    public zzdlu(zzdlr zzdlr) {
        this.zzhbw = zzdlr;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Clock) zzelg.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
