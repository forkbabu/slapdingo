package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbe implements zzela<Set<String>> {
    private final zzelj<zzccv> zzfnq;

    public zzcbe(zzelj<zzccv> zzelj) {
        this.zzfnq = zzelj;
    }

    public static Set<String> zza(zzccv zzccv) {
        Set set;
        if (zzccv.zzaly() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzelg.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfnq.get());
    }
}
