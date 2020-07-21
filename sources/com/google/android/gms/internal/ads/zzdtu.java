package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.PdfBoolean;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzdtu<V> extends zzdwa implements zzdvf<V> {
    /* access modifiers changed from: private */
    public static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL = new Object();
    private static final Logger zzhnb = Logger.getLogger(zzdtu.class.getName());
    /* access modifiers changed from: private */
    public static final zza zzhnc;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile Object value;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzk waiters;

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static abstract class zza {
        private zza() {
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract void zza(zzk zzk, Thread thread);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdtu<?> zzdtu, zzd zzd, zzd zzd2);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdtu<?> zzdtu, zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdtu<?> zzdtu, Object obj, Object obj2);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zzb {
        static final zzb zzhnd = new zzb(new Throwable("Failure occurred while trying to finish a future.") {
            /* class com.google.android.gms.internal.ads.zzdtu.zzb.AnonymousClass1 */

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        zzb(Throwable th) {
            this.exception = (Throwable) zzdsh.checkNotNull(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zzd {
        static final zzd zzhng = new zzd(null, null);
        final Executor executor;
        @NullableDecl
        zzd next;
        final Runnable task;

        zzd(Runnable runnable, Executor executor2) {
            this.task = runnable;
            this.executor = executor2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    interface zzg<V> extends zzdvf<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zzh extends zza {
        private zzh() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final void zza(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final void zza(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, zzk zzk, zzk zzk2) {
            synchronized (zzdtu) {
                if (zzdtu.waiters != zzk) {
                    return false;
                }
                zzk unused = ((zzdtu) zzdtu).waiters = zzk2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, zzd zzd, zzd zzd2) {
            synchronized (zzdtu) {
                if (zzdtu.listeners != zzd) {
                    return false;
                }
                zzd unused = ((zzdtu) zzdtu).listeners = zzd2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, Object obj, Object obj2) {
            synchronized (zzdtu) {
                if (zzdtu.value != obj) {
                    return false;
                }
                Object unused = zzdtu.value = obj2;
                return true;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zzi extends zza {
        static final Unsafe zzhni;
        static final long zzhnj;
        static final long zzhnk;
        static final long zzhnl;
        static final long zzhnm;
        static final long zzhnn;

        private zzi() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final void zza(zzk zzk, Thread thread) {
            zzhni.putObject(zzk, zzhnm, thread);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final void zza(zzk zzk, zzk zzk2) {
            zzhni.putObject(zzk, zzhnn, zzk2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, zzk zzk, zzk zzk2) {
            return zzhni.compareAndSwapObject(zzdtu, zzhnk, zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, zzd zzd, zzd zzd2) {
            return zzhni.compareAndSwapObject(zzdtu, zzhnj, zzd, zzd2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, Object obj, Object obj2) {
            return zzhni.compareAndSwapObject(zzdtu, zzhnl, obj, obj2);
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
        static {
            /*
                sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                goto L_0x0010
            L_0x0005:
                com.google.android.gms.internal.ads.zzdtu$zzi$1 r0 = new com.google.android.gms.internal.ads.zzdtu$zzi$1     // Catch:{ PrivilegedActionException -> 0x005f }
                r0.<init>()     // Catch:{ PrivilegedActionException -> 0x005f }
                java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x005f }
                sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x005f }
            L_0x0010:
                java.lang.Class<com.google.android.gms.internal.ads.zzdtu> r1 = com.google.android.gms.internal.ads.zzdtu.class
                java.lang.String r2 = "waiters"
                java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r2 = r0.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0055 }
                com.google.android.gms.internal.ads.zzdtu.zzi.zzhnk = r2     // Catch:{ Exception -> 0x0055 }
                java.lang.String r2 = "listeners"
                java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r2 = r0.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0055 }
                com.google.android.gms.internal.ads.zzdtu.zzi.zzhnj = r2     // Catch:{ Exception -> 0x0055 }
                java.lang.String r2 = "value"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                com.google.android.gms.internal.ads.zzdtu.zzi.zzhnl = r1     // Catch:{ Exception -> 0x0055 }
                java.lang.Class<com.google.android.gms.internal.ads.zzdtu$zzk> r1 = com.google.android.gms.internal.ads.zzdtu.zzk.class
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                com.google.android.gms.internal.ads.zzdtu.zzi.zzhnm = r1     // Catch:{ Exception -> 0x0055 }
                java.lang.Class<com.google.android.gms.internal.ads.zzdtu$zzk> r1 = com.google.android.gms.internal.ads.zzdtu.zzk.class
                java.lang.String r2 = "next"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                com.google.android.gms.internal.ads.zzdtu.zzi.zzhnn = r1     // Catch:{ Exception -> 0x0055 }
                com.google.android.gms.internal.ads.zzdtu.zzi.zzhni = r0     // Catch:{ Exception -> 0x0055 }
                return
            L_0x0055:
                r0 = move-exception
                com.google.android.gms.internal.ads.zzdsk.zzh(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005f:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtu.zzi.<clinit>():void");
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static abstract class zzj<V> extends zzdtu<V> implements zzg<V> {
        zzj() {
        }

        @Override // java.util.concurrent.Future, com.google.android.gms.internal.ads.zzdtu
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return zzdtu.super.get(j, timeUnit);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zzk {
        static final zzk zzhno = new zzk(false);
        @NullableDecl
        volatile zzk next;
        @NullableDecl
        volatile Thread thread;

        private zzk(boolean z) {
        }

        zzk() {
            zzdtu.zzhnc.zza(this, Thread.currentThread());
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zzk zzk) {
            zzdtu.zzhnc.zza(this, zzk);
        }
    }

    private final void zza(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zzhno) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (zzhnc.zza((zzdtu<?>) this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zzc {
        static final zzc zzhne;
        static final zzc zzhnf;
        @NullableDecl
        final Throwable cause;
        final boolean wasInterrupted;

        zzc(boolean z, @NullableDecl Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }

        static {
            if (zzdtu.GENERATE_CANCELLATION_CAUSES) {
                zzhnf = null;
                zzhne = null;
                return;
            }
            zzhnf = new zzc(false, null);
            zzhne = new zzc(true, null);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zze<V> implements Runnable {
        final zzdvf<? extends V> future;
        final zzdtu<V> zzhnh;

        zze(zzdtu<V> zzdtu, zzdvf<? extends V> zzdvf) {
            this.zzhnh = zzdtu;
            this.future = zzdvf;
        }

        public final void run() {
            if (this.zzhnh.value == this) {
                if (zzdtu.zzhnc.zza((zzdtu<?>) this.zzhnh, (Object) this, zzdtu.getFutureValue(this.future))) {
                    zzdtu.zza(this.zzhnh);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zzf extends zza {
        final AtomicReferenceFieldUpdater<zzdtu, zzd> listenersUpdater;
        final AtomicReferenceFieldUpdater<zzdtu, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<zzk, zzk> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<zzk, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<zzdtu, zzk> waitersUpdater;

        zzf(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdtu, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdtu, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdtu, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final void zza(zzk zzk, Thread thread) {
            this.waiterThreadUpdater.lazySet(zzk, thread);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final void zza(zzk zzk, zzk zzk2) {
            this.waiterNextUpdater.lazySet(zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, zzk zzk, zzk zzk2) {
            return this.waitersUpdater.compareAndSet(zzdtu, zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, zzd zzd, zzd zzd2) {
            return this.listenersUpdater.compareAndSet(zzdtu, zzd, zzd2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzdtu.zza
        public final boolean zza(zzdtu<?> zzdtu, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(zzdtu, obj, obj2);
        }
    }

    protected zzdtu() {
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof zze))) {
                return zzae(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zzhno) {
                    zzk zzk3 = new zzk();
                    do {
                        zzk3.zzb(zzk2);
                        if (zzhnc.zza((zzdtu<?>) this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zze))) {
                                        return zzae(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zza(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zza(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zzhno);
                }
                return zzae(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof zze))) {
                    return zzae(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzdtu = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(zzdtu).length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(zzdtu);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zze))) {
                return zzae(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zzhno) {
                zzk zzk3 = new zzk();
                do {
                    zzk3.zzb(zzk2);
                    if (zzhnc.zza((zzdtu<?>) this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zze))));
                        return zzae(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zzhno);
            }
            return zzae(this.value);
        }
        throw new InterruptedException();
    }

    private static V zzae(Object obj) throws ExecutionException {
        if (obj instanceof zzc) {
            Throwable th = ((zzc) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzb) {
            throw new ExecutionException(((zzb) obj).exception);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof zze)) & (obj != null);
    }

    public boolean isCancelled() {
        return this.value instanceof zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.google.android.gms.internal.ads.zzdtu$zza} */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean cancel(boolean z) {
        zzc zzc2;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zze)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            zzc2 = new zzc(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            zzc2 = zzc.zzhne;
        } else {
            zzc2 = zzc.zzhnf;
        }
        boolean z2 = false;
        zzdtu zzdtu = this;
        while (true) {
            if (zzhnc.zza(zzdtu, obj, zzc2)) {
                if (z) {
                    zzdtu.interruptTask();
                }
                zza(zzdtu);
                if (!(obj instanceof zze)) {
                    return true;
                }
                zzdvf<? extends V> zzdvf = ((zze) obj).future;
                if (zzdvf instanceof zzg) {
                    zzdtu = (zzdtu) zzdvf;
                    obj = zzdtu.value;
                    if (!(obj == null) && !(obj instanceof zze)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    zzdvf.cancel(z);
                    return true;
                }
            } else {
                obj = zzdtu.value;
                if (!(obj instanceof zze)) {
                    return z2;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof zzc) && ((zzc) obj).wasInterrupted;
    }

    @Override // com.google.android.gms.internal.ads.zzdvf
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzdsh.checkNotNull(runnable, "Runnable was null.");
        zzdsh.checkNotNull(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zzhng) {
            zza(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzhnc.zza((zzdtu<?>) this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zzhng);
        zza(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = NULL;
        }
        if (!zzhnc.zza(this, (Object) null, v)) {
            return false;
        }
        zza(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (!zzhnc.zza(this, (Object) null, new zzb((Throwable) zzdsh.checkNotNull(th)))) {
            return false;
        }
        zza(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean setFuture(zzdvf<? extends V> zzdvf) {
        zze zze2;
        zzb zzb2;
        zzdsh.checkNotNull(zzdvf);
        Object obj = this.value;
        if (obj == null) {
            if (zzdvf.isDone()) {
                if (!zzhnc.zza(this, (Object) null, getFutureValue(zzdvf))) {
                    return false;
                }
                zza(this);
                return true;
            }
            zze2 = new zze(this, zzdvf);
            if (zzhnc.zza(this, (Object) null, zze2)) {
                try {
                    zzdvf.addListener(zze2, zzdum.INSTANCE);
                } catch (Throwable unused) {
                    zzb2 = zzb.zzhnd;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzc) {
            zzdvf.cancel(((zzc) obj).wasInterrupted);
        }
        return false;
        zzhnc.zza(this, zze2, zzb2);
        return true;
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(zzdvf<?> zzdvf) {
        Throwable zza2;
        if (zzdvf instanceof zzg) {
            Object obj = ((zzdtu) zzdvf).value;
            if (!(obj instanceof zzc)) {
                return obj;
            }
            zzc zzc2 = (zzc) obj;
            if (!zzc2.wasInterrupted) {
                return obj;
            }
            if (zzc2.cause != null) {
                return new zzc(false, zzc2.cause);
            }
            return zzc.zzhnf;
        } else if ((zzdvf instanceof zzdwa) && (zza2 = zzdvz.zza((zzdwa) zzdvf)) != null) {
            return new zzb(zza2);
        } else {
            boolean isCancelled = zzdvf.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
                return zzc.zzhnf;
            }
            try {
                Object uninterruptibly = getUninterruptibly(zzdvf);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                String valueOf = String.valueOf(zzdvf);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new zzc(false, new IllegalArgumentException(sb.toString()));
            } catch (ExecutionException e) {
                if (!isCancelled) {
                    return new zzb(e.getCause());
                }
                String valueOf2 = String.valueOf(zzdvf);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 84);
                sb2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb2.append(valueOf2);
                return new zzc(false, new IllegalArgumentException(sb2.toString(), e));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new zzc(false, e2);
                }
                String valueOf3 = String.valueOf(zzdvf);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 77);
                sb3.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb3.append(valueOf3);
                return new zzb(new IllegalArgumentException(sb3.toString(), e2));
            } catch (Throwable th) {
                return new zzb(th);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:26:0x0002 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:27:0x0002 */
    /* JADX DEBUG: Additional 1 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.google.android.gms.internal.ads.zzdtu$zza} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.gms.internal.ads.zzdtu$zza} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.google.android.gms.internal.ads.zzdtu$zza} */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    public static void zza(zzdtu<?> zzdtu) {
        zzd zzd2;
        zzd zzd3;
        zzd zzd4 = null;
        zzdtu zzdtu2 = zzdtu;
        while (true) {
            zzk zzk2 = zzdtu2.waiters;
            if (zzhnc.zza((zzdtu<?>) zzdtu2, zzk2, zzk.zzhno)) {
                while (zzk2 != null) {
                    Thread thread = zzk2.thread;
                    if (thread != null) {
                        zzk2.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzk2 = zzk2.next;
                }
                zzdtu2.afterDone();
                do {
                    zzd2 = zzdtu2.listeners;
                } while (!zzhnc.zza((zzdtu<?>) zzdtu2, zzd2, zzd.zzhng));
                while (true) {
                    zzd3 = zzd4;
                    zzd4 = zzd2;
                    if (zzd4 == null) {
                        break;
                    }
                    zzd2 = zzd4.next;
                    zzd4.next = zzd3;
                }
                while (zzd3 != null) {
                    zzd4 = zzd3.next;
                    Runnable runnable = zzd3.task;
                    if (runnable instanceof zze) {
                        zze zze2 = (zze) runnable;
                        zzdtu2 = zze2.zzhnh;
                        if (zzdtu2.value == zze2) {
                            if (!zzhnc.zza(zzdtu2, zze2, getFutureValue(zze2.future))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zza(runnable, zzd3.executor);
                    }
                    zzd3 = zzd4;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdwa
    @NullableDecl
    public final Throwable zzawt() {
        if (!(this instanceof zzg)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzb) {
            return ((zzb) obj).exception;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zza(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.value;
            if (obj instanceof zze) {
                sb.append(", setFuture=[");
                zza(sb, ((zze) obj).future);
                sb.append("]");
            } else {
                try {
                    str = zzdsi.emptyToNull(pendingToString());
                } catch (RuntimeException | StackOverflowError e) {
                    String valueOf = String.valueOf(e.getClass());
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 38);
                    sb2.append("Exception thrown from implementation: ");
                    sb2.append(valueOf);
                    str = sb2.toString();
                }
                if (str != null) {
                    sb.append(", info=[");
                    sb.append(str);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zza(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    private final void zza(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            zza(sb, uninterruptibly);
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zza(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzhnb;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e);
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zza2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", PdfBoolean.FALSE));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        try {
            zza2 = new zzi();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            zza2 = new zzh();
        }
        zzhnc = zza2;
        if (th != null) {
            zzhnb.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzhnb.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }
}
