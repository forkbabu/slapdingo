package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzpr implements ThreadFactory {
    private final /* synthetic */ String zzbkj;

    zzpr(String str) {
        this.zzbkj = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zzbkj);
    }
}
