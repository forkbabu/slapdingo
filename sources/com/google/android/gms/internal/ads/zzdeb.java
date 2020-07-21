package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdeb<T> {
    private final Executor executor;
    private final Set<zzdec<? extends zzddz<T>>> zzgum;

    public zzdeb(Executor executor2, Set<zzdec<? extends zzddz<T>>> set) {
        this.executor = executor2;
        this.zzgum = set;
    }

    public final zzdvf<T> zzt(T t) {
        ArrayList arrayList = new ArrayList(this.zzgum.size());
        for (zzdec<? extends zzddz<T>> zzdec : this.zzgum) {
            zzdvf<? extends zzddz<T>> zzaqm = zzdec.zzaqm();
            if (zzack.zzdaj.get().booleanValue()) {
                zzaqm.addListener(new zzdee(zzdec, zzq.zzld().elapsedRealtime()), zzbbf.zzedm);
            }
            arrayList.add(zzaqm);
        }
        return zzdux.zzk(arrayList).zza(new zzded(arrayList, t), this.executor);
    }
}
