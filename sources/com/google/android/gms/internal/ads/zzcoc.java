package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcoc implements zzela<zzcoa> {
    private final zzelj<Context> zzere;

    public zzcoc(zzelj<Context> zzelj) {
        this.zzere = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcoa(this.zzere.get());
    }
}
