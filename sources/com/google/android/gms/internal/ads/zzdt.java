package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdt implements Runnable {
    private final /* synthetic */ zzdu zzwe;

    zzdt(zzdu zzdu) {
        this.zzwe = zzdu;
    }

    public final void run() {
        boolean z;
        if (this.zzwe.zzwi == null) {
            synchronized (zzdu.zzwg) {
                if (this.zzwe.zzwi == null) {
                    boolean z2 = false;
                    try {
                        z = zzaav.zzcqc.get().booleanValue();
                    } catch (IllegalStateException unused) {
                        z = false;
                    }
                    if (z) {
                        try {
                            zzdu.zzwh = new zztr(this.zzwe.zzwf.zzvr, "ADSHIELD", null);
                        } catch (Throwable unused2) {
                        }
                    }
                    z2 = z;
                    this.zzwe.zzwi = Boolean.valueOf(z2);
                    zzdu.zzwg.open();
                }
            }
        }
    }
}
