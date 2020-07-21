package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbul implements zzela<zzbui> {
    private final zzelj<Set<zzbyg<zzo>>> zzfnx;

    private zzbul(zzelj<Set<zzbyg<zzo>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbul zzo(zzelj<Set<zzbyg<zzo>>> zzelj) {
        return new zzbul(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbui(this.zzfnx.get());
    }
}
