package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqc implements Handler.Callback, Choreographer.FrameCallback {
    private static final zzqc zzbmb = new zzqc();
    private final Handler handler;
    public volatile long zzbma;
    private final HandlerThread zzbmc;
    private Choreographer zzbmd;
    private int zzbme;

    public static zzqc zzjo() {
        return zzbmb;
    }

    private zzqc() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        this.zzbmc = handlerThread;
        handlerThread.start();
        Handler handler2 = new Handler(this.zzbmc.getLooper(), this);
        this.handler = handler2;
        handler2.sendEmptyMessage(0);
    }

    public final void zzjp() {
        this.handler.sendEmptyMessage(1);
    }

    public final void zzjq() {
        this.handler.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.zzbma = j;
        this.zzbmd.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zzbmd = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            int i2 = this.zzbme + 1;
            this.zzbme = i2;
            if (i2 == 1) {
                this.zzbmd.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.zzbme - 1;
            this.zzbme = i3;
            if (i3 == 0) {
                this.zzbmd.removeFrameCallback(this);
                this.zzbma = 0;
            }
            return true;
        }
    }
}
