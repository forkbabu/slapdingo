package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbwy implements Runnable {
    private final Object zzdhw;
    private final zzbwx zzfsq;

    zzbwy(zzbwx zzbwx, Object obj) {
        this.zzfsq = zzbwx;
        this.zzdhw = obj;
    }

    public final void run() {
        try {
            this.zzfsq.zzp(this.zzdhw);
        } catch (Throwable th) {
            zzq.zzla().zzb(th, "EventEmitter.notify");
            zzaxv.zza("Event emitter exception.", th);
        }
    }
}
