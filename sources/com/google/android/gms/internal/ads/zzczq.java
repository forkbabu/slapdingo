package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczq implements zzela<zzczo> {
    private final zzelj<Set<String>> zzgry;

    private zzczq(zzelj<Set<String>> zzelj) {
        this.zzgry = zzelj;
    }

    public static zzczq zzal(zzelj<Set<String>> zzelj) {
        return new zzczq(zzelj);
    }

    public static zzczo zzd(Set<String> set) {
        return new zzczo(set);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzd(this.zzgry.get());
    }
}
