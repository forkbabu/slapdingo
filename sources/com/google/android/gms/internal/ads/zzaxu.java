package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzaxu implements Runnable {
    private final /* synthetic */ zzaxr zzdyx;

    zzaxu(zzaxr zzaxr) {
        this.zzdyx = zzaxr;
    }

    public final void run() {
        Thread unused = this.zzdyx.thread = Thread.currentThread();
        this.zzdyx.zzut();
    }
}
