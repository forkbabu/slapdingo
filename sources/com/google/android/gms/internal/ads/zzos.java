package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzos {
    private final Map<String, String> zzbiw = new HashMap();
    private Map<String, String> zzbix;

    public final synchronized Map<String, String> zzir() {
        if (this.zzbix == null) {
            this.zzbix = Collections.unmodifiableMap(new HashMap(this.zzbiw));
        }
        return this.zzbix;
    }
}
