package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzfa implements ThreadFactory {
    private final ThreadFactory zzzk = Executors.defaultThreadFactory();
    private final AtomicInteger zzzl = new AtomicInteger(1);

    zzfa() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzzk.newThread(runnable);
        int andIncrement = this.zzzl.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
