package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbfb {
    private final ArrayList<zzor> zzekt = new ArrayList<>();
    private long zzeku;

    zzbfb() {
    }

    /* access modifiers changed from: package-private */
    public final long zzaap() {
        Iterator<zzor> it2 = this.zzekt.iterator();
        while (it2.hasNext()) {
            Map<String, List<String>> responseHeaders = it2.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.zzeku = Math.max(this.zzeku, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it2.remove();
            }
        }
        return this.zzeku;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzor zzor) {
        this.zzekt.add(zzor);
    }
}
