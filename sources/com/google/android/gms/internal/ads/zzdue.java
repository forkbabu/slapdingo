package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdtu;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
abstract class zzdue<OutputT> extends zzdtu.zzj<OutputT> {
    private static final Logger zzhnb = Logger.getLogger(zzdue.class.getName());
    private static final zzb zzhoa;
    private volatile int remaining;
    /* access modifiers changed from: private */
    public volatile Set<Throwable> seenExceptions = null;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static abstract class zzb {
        private zzb() {
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzdue zzdue, Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        public abstract int zzc(zzdue zzdue);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zzc extends zzb {
        private zzc() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdue.zzb
        public final void zza(zzdue zzdue, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzdue) {
                if (zzdue.seenExceptions == null) {
                    Set unused = zzdue.seenExceptions = (Set) set2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdue.zzb
        public final int zzc(zzdue zzdue) {
            int zzb;
            synchronized (zzdue) {
                zzb = zzdue.zzb(zzdue);
            }
            return zzb;
        }
    }

    zzdue(int i) {
        this.remaining = i;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzh(Set<Throwable> set);

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zza extends zzb {
        private final AtomicReferenceFieldUpdater<zzdue, Set<Throwable>> zzhob;
        private final AtomicIntegerFieldUpdater<zzdue> zzhoc;

        zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzhob = atomicReferenceFieldUpdater;
            this.zzhoc = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdue.zzb
        public final void zza(zzdue zzdue, Set<Throwable> set, Set<Throwable> set2) {
            this.zzhob.compareAndSet(zzdue, null, set2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdue.zzb
        public final int zzc(zzdue zzdue) {
            return this.zzhoc.decrementAndGet(zzdue);
        }
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> zzawy() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzh(newSetFromMap);
        zzhoa.zza(this, null, newSetFromMap);
        return this.seenExceptions;
    }

    /* access modifiers changed from: package-private */
    public final int zzawz() {
        return zzhoa.zzc(this);
    }

    /* access modifiers changed from: package-private */
    public final void zzaxa() {
        this.seenExceptions = null;
    }

    static /* synthetic */ int zzb(zzdue zzdue) {
        int i = zzdue.remaining - 1;
        zzdue.remaining = i;
        return i;
    }

    static {
        Throwable th;
        zzb zzb2;
        try {
            zzb2 = new zza(AtomicReferenceFieldUpdater.newUpdater(zzdue.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzdue.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            zzb2 = new zzc();
            th = th2;
        }
        zzhoa = zzb2;
        if (th != null) {
            zzhnb.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }
}
