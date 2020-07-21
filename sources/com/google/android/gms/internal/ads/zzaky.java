package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaky extends zzbbu<zzaju> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzazj<zzaju> zzdgc;
    private boolean zzdgt;
    private int zzdgu;

    public zzaky(zzazj<zzaju> zzazj) {
        this.zzdgc = zzazj;
        this.zzdgt = false;
        this.zzdgu = 0;
    }

    public final zzaku zztb() {
        zzaku zzaku = new zzaku(this);
        synchronized (this.lock) {
            zza(new zzalb(this, zzaku), new zzala(this, zzaku));
            Preconditions.checkState(this.zzdgu >= 0);
            this.zzdgu++;
        }
        return zzaku;
    }

    /* access modifiers changed from: protected */
    public final void zztc() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdgu > 0);
            zzaxv.zzeh("Releasing 1 reference for JS Engine");
            this.zzdgu--;
            zzte();
        }
    }

    public final void zztd() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdgu >= 0);
            zzaxv.zzeh("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdgt = true;
            zzte();
        }
    }

    private final void zzte() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdgu >= 0);
            if (!this.zzdgt || this.zzdgu != 0) {
                zzaxv.zzeh("There are still references to the engine. Not destroying.");
            } else {
                zzaxv.zzeh("No reference is left (including root). Cleaning up engine.");
                zza(new zzald(this), new zzbbs());
            }
        }
    }
}
