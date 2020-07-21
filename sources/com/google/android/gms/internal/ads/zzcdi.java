package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcdi implements Runnable {
    private final zzcdg zzfyl;
    private final ViewGroup zzfym;

    zzcdi(zzcdg zzcdg, ViewGroup viewGroup) {
        this.zzfyl = zzcdg;
        this.zzfym = viewGroup;
    }

    public final void run() {
        this.zzfyl.zzb(this.zzfym);
    }
}
