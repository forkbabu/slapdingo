package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcmx implements zzela<ApplicationInfo> {
    private final zzelj<Context> zzere;

    private zzcmx(zzelj<Context> zzelj) {
        this.zzere = zzelj;
    }

    public static zzcmx zzac(zzelj<Context> zzelj) {
        return new zzcmx(zzelj);
    }

    public static ApplicationInfo zzcf(Context context) {
        return (ApplicationInfo) zzelg.zza(context.getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzcf(this.zzere.get());
    }
}
