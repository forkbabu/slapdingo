package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbmo implements zzela<Set<zzbyg<zzqs>>> {
    private final zzbmn zzfmt;
    private final zzelj<zzbos> zzfmy;

    public zzbmo(zzbmn zzbmn, zzelj<zzbos> zzelj) {
        this.zzfmt = zzbmn;
        this.zzfmy = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(Collections.singleton(new zzbyg(this.zzfmy.get(), zzbbf.zzedm)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
