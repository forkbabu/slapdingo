package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbbi implements ThreadFactory {
    private final /* synthetic */ String zzedo;
    private final AtomicInteger zzzl = new AtomicInteger(1);

    zzbbi(String str) {
        this.zzedo = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zzedo;
        int andIncrement = this.zzzl.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
