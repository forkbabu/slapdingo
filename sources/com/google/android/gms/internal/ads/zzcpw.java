package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcpw implements zzela<zzcpx> {
    private final zzelj<Context> zzere;

    private zzcpw(zzelj<Context> zzelj) {
        this.zzere = zzelj;
    }

    public static zzcpw zzaf(zzelj<Context> zzelj) {
        return new zzcpw(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcpx(this.zzere.get());
    }
}
