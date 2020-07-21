package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzapv {
    private final zzbfn zzdfp;
    private final boolean zzdmi;
    private final String zzdmj;

    public zzapv(zzbfn zzbfn, Map<String, String> map) {
        this.zzdfp = zzbfn;
        this.zzdmj = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzdmi = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzdmi = true;
        }
    }

    public final void execute() {
        int i;
        if (this.zzdfp == null) {
            zzaxv.zzfd("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdmj)) {
            zzq.zzky();
            i = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdmj)) {
            zzq.zzky();
            i = 6;
        } else if (this.zzdmi) {
            i = -1;
        } else {
            i = zzq.zzky().zzxn();
        }
        this.zzdfp.setRequestedOrientation(i);
    }
}
