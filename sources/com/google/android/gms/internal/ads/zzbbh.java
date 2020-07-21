package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbbh implements Executor {
    private final Handler zzedn = new zzaxy(Looper.getMainLooper());

    zzbbh() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzq.zzkw();
                zzaye.zza(zzq.zzla().getApplicationContext(), th);
                throw th;
            }
        } else {
            this.zzedn.post(runnable);
        }
    }
}
