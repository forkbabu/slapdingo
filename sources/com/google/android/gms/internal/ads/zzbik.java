package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbik implements zzela<WeakReference<Context>> {
    private final zzbie zzeqy;

    public zzbik(zzbie zzbie) {
        this.zzeqy = zzbie;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (WeakReference) zzelg.zza(this.zzeqy.zzada(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
