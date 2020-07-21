package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblj implements zzbld {
    private final zzaxx zzdyn;

    public zzblj(zzaxx zzaxx) {
        this.zzdyn = zzaxx;
    }

    @Override // com.google.android.gms.internal.ads.zzbld
    public final void zzl(Map<String, String> map) {
        String str = map.get("value");
        if ("auto_collect_location".equals(map.get("key"))) {
            this.zzdyn.zzaq(Boolean.parseBoolean(str));
        }
    }
}
