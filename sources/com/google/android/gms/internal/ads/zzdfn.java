package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfn implements zzela<zzdfl> {
    private final zzelj<Context> zzfqq;

    public zzdfn(zzelj<Context> zzelj) {
        this.zzfqq = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdfl(this.zzfqq.get());
    }
}
