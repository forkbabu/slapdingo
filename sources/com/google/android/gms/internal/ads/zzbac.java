package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbac {
    private Handler handler = null;
    private final Object lock = new Object();
    private HandlerThread zzebv = null;
    private int zzebw = 0;

    public final Looper zzya() {
        Looper looper;
        synchronized (this.lock) {
            if (this.zzebw != 0) {
                Preconditions.checkNotNull(this.zzebv, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzebv == null) {
                zzaxv.zzeh("Starting the looper thread.");
                HandlerThread handlerThread = new HandlerThread("LooperProvider");
                this.zzebv = handlerThread;
                handlerThread.start();
                this.handler = new zzdrr(this.zzebv.getLooper());
                zzaxv.zzeh("Looper thread started.");
            } else {
                zzaxv.zzeh("Resuming the looper thread");
                this.lock.notifyAll();
            }
            this.zzebw++;
            looper = this.zzebv.getLooper();
        }
        return looper;
    }

    public final Handler getHandler() {
        return this.handler;
    }
}
