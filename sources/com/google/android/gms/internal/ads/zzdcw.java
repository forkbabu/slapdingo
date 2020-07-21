package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcw implements zzela<zzdcu> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Bundle> zzgtm;

    private zzdcw(zzelj<zzdvi> zzelj, zzelj<Bundle> zzelj2) {
        this.zzerc = zzelj;
        this.zzgtm = zzelj2;
    }

    public static zzdcw zzbe(zzelj<zzdvi> zzelj, zzelj<Bundle> zzelj2) {
        return new zzdcw(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdcu(this.zzerc.get(), this.zzgtm.get());
    }
}
