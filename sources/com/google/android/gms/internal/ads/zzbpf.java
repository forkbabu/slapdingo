package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbpf<AdT> implements zzbpc<AdT> {
    private final Map<String, zzcqt<AdT>> zzfpf;

    zzbpf(Map<String, zzcqt<AdT>> map) {
        this.zzfpf = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final zzcqt<AdT> zze(int i, String str) {
        return this.zzfpf.get(str);
    }
}
