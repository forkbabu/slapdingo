package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzaib implements Runnable {
    private final /* synthetic */ zzahw zzdeq;

    zzaib(zzahw zzahw) {
        this.zzdeq = zzahw;
    }

    public final void run() {
        this.zzdeq.disconnect();
    }
}
