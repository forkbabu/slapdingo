package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-base@@19.2.0 */
final class zzeec {
    private final ConcurrentHashMap<zzeeb, List<Throwable>> zzhzc = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzhzd = new ReferenceQueue<>();

    zzeec() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzhzd.poll();
        while (poll != null) {
            this.zzhzc.remove(poll);
            poll = this.zzhzd.poll();
        }
        List<Throwable> list = this.zzhzc.get(new zzeeb(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzhzc.putIfAbsent(new zzeeb(th, this.zzhzd), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
