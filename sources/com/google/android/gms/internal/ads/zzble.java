package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzble implements zzbld {
    private zzaxx zzdyn;

    public zzble(zzaxx zzaxx) {
        this.zzdyn = zzaxx;
    }

    @Override // com.google.android.gms.internal.ads.zzbld
    public final void zzl(Map<String, String> map) {
        this.zzdyn.zzap(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
