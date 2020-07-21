package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcnb implements zzela<String> {
    private final zzelj<Context> zzere;

    private zzcnb(zzelj<Context> zzelj) {
        this.zzere = zzelj;
    }

    public static zzcnb zzae(zzelj<Context> zzelj) {
        return new zzcnb(zzelj);
    }

    public static String zzch(Context context) {
        return (String) zzelg.zza(context.getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzch(this.zzere.get());
    }
}
