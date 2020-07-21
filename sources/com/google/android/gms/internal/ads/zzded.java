package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzded implements Callable {
    private final Object zzdhw;
    private final List zzgtt;

    zzded(List list, Object obj) {
        this.zzgtt = list;
        this.zzdhw = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        List<zzdvf> list = this.zzgtt;
        Object obj = this.zzdhw;
        for (zzdvf zzdvf : list) {
            zzddz zzddz = (zzddz) zzdvf.get();
            if (zzddz != null) {
                zzddz.zzs(obj);
            }
        }
        return obj;
    }
}
