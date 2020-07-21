package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpp {
    public static void beginSection(String str) {
        if (zzpo.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzpo.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
