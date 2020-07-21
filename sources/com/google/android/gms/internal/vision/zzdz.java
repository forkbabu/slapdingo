package com.google.android.gms.internal.vision;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzdz {
    private final ConcurrentHashMap<zzec, List<Throwable>> zzmr = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzms = new ReferenceQueue<>();

    zzdz() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzms.poll();
        while (poll != null) {
            this.zzmr.remove(poll);
            poll = this.zzms.poll();
        }
        List<Throwable> list = this.zzmr.get(new zzec(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzmr.putIfAbsent(new zzec(th, this.zzms), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
