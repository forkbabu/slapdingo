package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaku extends zzbbu<zzalf> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final zzaky zzdgq;
    private boolean zzdgr;

    public zzaku(zzaky zzaky) {
        this.zzdgq = zzaky;
    }

    public final void release() {
        synchronized (this.lock) {
            if (!this.zzdgr) {
                this.zzdgr = true;
                zza(new zzakx(this), new zzbbs());
                zza(new zzakw(this), new zzakz(this));
            }
        }
    }
}
