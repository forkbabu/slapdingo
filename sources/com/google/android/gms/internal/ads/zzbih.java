package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbih implements zzela<Context> {
    private final zzbie zzeqy;

    public zzbih(zzbie zzbie) {
        this.zzeqy = zzbie;
    }

    public static Context zza(zzbie zzbie) {
        return (Context) zzelg.zza(zzbie.zzacz(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzeqy);
    }
}
