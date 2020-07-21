package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcna implements zzela<zzcnw> {
    private final zzelj<Context> zzere;

    private zzcna(zzelj<Context> zzelj) {
        this.zzere = zzelj;
    }

    public static zzcna zzad(zzelj<Context> zzelj) {
        return new zzcna(zzelj);
    }

    public static zzcnw zzcg(Context context) {
        return (zzcnw) zzelg.zza(new zzcnw(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzcg(this.zzere.get());
    }
}
