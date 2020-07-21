package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcys implements zzela<Set<String>> {
    private final zzcym zzgrb;

    public zzcys(zzcym zzcym) {
        this.zzgrb = zzcym;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzgrb.zzaqj(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
