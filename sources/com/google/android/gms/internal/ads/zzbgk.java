package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbgk implements Runnable {
    private final Map zzedc;
    private final zzbgh zzeos;

    zzbgk(zzbgh zzbgh, Map map) {
        this.zzeos = zzbgh;
        this.zzedc = map;
    }

    public final void run() {
        this.zzeos.zzk(this.zzedc);
    }
}
