package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final /* synthetic */ class zzdpl implements Callable {
    private final Context zzclf;

    zzdpl(Context context) {
        this.zzclf = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return zzdpm.zzcj(this.zzclf);
    }
}
