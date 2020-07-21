package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzayf implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzaye zzeaa;

    zzayf(zzaye zzaye, Context context) {
        this.zzeaa = zzaye;
        this.val$context = context;
    }

    public final void run() {
        synchronized (this.zzeaa.zzdzx) {
            String unused = this.zzeaa.zzbil = zzaye.zzar(this.val$context);
            this.zzeaa.zzdzx.notifyAll();
        }
    }
}
