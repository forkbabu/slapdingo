package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcmw implements zzela<List<String>> {
    public static zzcmw zzaox() {
        return zzcmz.zzggr;
    }

    public static List<String> zzaoy() {
        return (List) zzelg.zza(zzaav.zzrc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzaoy();
    }
}
