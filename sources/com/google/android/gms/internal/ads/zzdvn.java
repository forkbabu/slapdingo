package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdtu;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvn extends zzdtu.zzj<Void> implements Runnable {
    private final Runnable zzhpa;

    public zzdvn(Runnable runnable) {
        this.zzhpa = (Runnable) zzdsh.checkNotNull(runnable);
    }

    public final void run() {
        try {
            this.zzhpa.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdsk.zzi(th);
        }
    }
}
