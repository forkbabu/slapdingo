package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzast {
    /* access modifiers changed from: private */
    public WeakHashMap<Context, zzasv> zzdud = new WeakHashMap<>();

    public final Future<zzasr> zzu(Context context) {
        return zzbbf.zzedh.zze(new zzasw(this, context));
    }
}
