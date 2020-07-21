package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
abstract class zzdve<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zzhoq = new zzdvg();
    private static final Runnable zzhor = new zzdvg();
    private static final Runnable zzhos = new zzdvg();

    zzdve() {
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isDone();

    /* access modifiers changed from: package-private */
    public abstract T zzaxb() throws Exception;

    /* access modifiers changed from: package-private */
    public abstract String zzaxc();

    /* access modifiers changed from: package-private */
    public abstract void zzb(@NullableDecl T t, @NullableDecl Throwable th);

    public final void run() {
        T t;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    t = zzaxb();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zzhoq)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (runnable != zzhor && runnable != zzhos) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable2 = zzhos;
                                if (runnable == runnable2 || compareAndSet(zzhor, runnable2)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = (Runnable) get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        zzb(null, th);
                        return;
                    }
                    return;
                }
            } else {
                t = null;
            }
            if (!compareAndSet(currentThread, zzhoq)) {
                Runnable runnable3 = (Runnable) get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    if (runnable3 != zzhor && runnable3 != zzhos) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable4 = zzhos;
                        if (runnable3 == runnable4 || compareAndSet(zzhor, runnable4)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable3 = (Runnable) get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                zzb(t, null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zzhor)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (((Runnable) getAndSet(zzhoq)) == zzhos) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zzhoq) {
            str = "running=[DONE]";
        } else if (runnable == zzhor) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzaxc = zzaxc();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(zzaxc).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(zzaxc);
        return sb2.toString();
    }
}
