package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzaxr {
    /* access modifiers changed from: private */
    public volatile Thread thread;
    private final Runnable zzdyr = new zzaxu(this);
    private boolean zzdys = false;

    public abstract void zzut();

    public final zzdvf<?> zzwq() {
        return zzbbf.zzedi.zzf(this.zzdyr);
    }
}
