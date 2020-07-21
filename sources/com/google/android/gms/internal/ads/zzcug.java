package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcug implements zzela<zzcuf> {
    private final zzelj<Context> zzere;
    private final zzelj<zzchm> zzgkp;

    public zzcug(zzelj<Context> zzelj, zzelj<zzchm> zzelj2) {
        this.zzere = zzelj;
        this.zzgkp = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcuf(this.zzere.get(), this.zzgkp.get());
    }
}
