package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbdd implements Runnable {
    private boolean zzbsr = false;
    private zzbco zzefv;

    zzbdd(zzbco zzbco) {
        this.zzefv = zzbco;
    }

    public final void run() {
        if (!this.zzbsr) {
            this.zzefv.zzzb();
            zzzs();
        }
    }

    public final void pause() {
        this.zzbsr = true;
        this.zzefv.zzzb();
    }

    public final void resume() {
        this.zzbsr = false;
        zzzs();
    }

    private final void zzzs() {
        zzaye.zzdzw.removeCallbacks(this);
        zzaye.zzdzw.postDelayed(this, 250);
    }
}
