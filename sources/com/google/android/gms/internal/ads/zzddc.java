package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzddc implements zzela<zzdda> {
    private final zzelj<Context> zzere;
    private final zzelj<String> zzexl;

    private zzddc(zzelj<Context> zzelj, zzelj<String> zzelj2) {
        this.zzere = zzelj;
        this.zzexl = zzelj2;
    }

    public static zzddc zzbf(zzelj<Context> zzelj, zzelj<String> zzelj2) {
        return new zzddc(zzelj, zzelj2);
    }

    public static zzdda zzu(Context context, String str) {
        return new zzdda(context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzu(this.zzere.get(), this.zzexl.get());
    }
}
