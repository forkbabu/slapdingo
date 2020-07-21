package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdnl implements ThreadFactory {
    private final AtomicInteger zzzl = new AtomicInteger(1);

    zzdnl() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zzzl.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
