package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzaml implements Runnable {
    private final Context zzcjz;
    private final zzamj zzdhz;

    zzaml(zzamj zzamj, Context context) {
        this.zzdhz = zzamj;
        this.zzcjz = context;
    }

    public final void run() {
        zzamj.zzo(this.zzcjz);
    }
}
