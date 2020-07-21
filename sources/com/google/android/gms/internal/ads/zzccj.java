package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzccj {
    private zzado zzckd;

    public zzccj(zzccb zzccb) {
        this.zzckd = zzccb;
    }

    public final synchronized zzado zzsn() {
        return this.zzckd;
    }

    public final synchronized void zza(zzado zzado) {
        this.zzckd = zzado;
    }
}
