package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctj implements zzela<zzcte> {
    private final zzelj<Context> zzere;
    private final zzelj<zzcbc> zzgkp;

    public zzctj(zzelj<Context> zzelj, zzelj<zzcbc> zzelj2) {
        this.zzere = zzelj;
        this.zzgkp = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcte(this.zzere.get(), this.zzgkp.get());
    }
}
