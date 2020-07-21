package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbiv implements zzela<zzata> {
    private final zzelj<Context> zzere;

    public zzbiv(zzelj<Context> zzelj) {
        this.zzere = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        Context context = this.zzere.get();
        return (zzata) zzelg.zza(new zzasy(context, new zzatb(context).zzuy()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
