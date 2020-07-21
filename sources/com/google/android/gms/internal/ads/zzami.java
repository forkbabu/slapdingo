package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzami implements Runnable {
    private final Context zzcjz;
    private final zzamj zzdhz;
    private final String zzdia;

    zzami(zzamj zzamj, Context context, String str) {
        this.zzdhz = zzamj;
        this.zzcjz = context;
        this.zzdia = str;
    }

    public final void run() {
        zzamj.zze(this.zzcjz, this.zzdia);
    }
}
