package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzajs implements Runnable {
    private final zzajt zzdfj;
    private final zzahc zzdfk;
    private final Map zzdfl;

    zzajs(zzajt zzajt, zzahc zzahc, Map map) {
        this.zzdfj = zzajt;
        this.zzdfk = zzahc;
        this.zzdfl = map;
    }

    public final void run() {
        this.zzdfj.zza(this.zzdfk, this.zzdfl);
    }
}
