package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzrg implements Runnable {
    private final /* synthetic */ zzrh zzbsq;

    zzrg(zzrh zzrh) {
        this.zzbsq = zzrh;
    }

    public final void run() {
        synchronized (this.zzbsq.lock) {
            if (!this.zzbsq.foreground || !this.zzbsq.zzbsr) {
                zzaxv.zzee("App is still foreground");
            } else {
                boolean unused = this.zzbsq.foreground = false;
                zzaxv.zzee("App went background");
                for (zzrj zzrj : this.zzbsq.zzbss) {
                    try {
                        zzrj.zzp(false);
                    } catch (Exception e) {
                        zzbba.zzc("", e);
                    }
                }
            }
        }
    }
}
