package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzih {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zzii zzaiv;

    public zzih(Handler handler2, zzii zzii) {
        this.handler = zzii != null ? (Handler) zzpb.checkNotNull(handler2) : null;
        this.zzaiv = zzii;
    }

    public final void zza(zzjj zzjj) {
        if (this.zzaiv != null) {
            this.handler.post(new zzik(this, zzjj));
        }
    }

    public final void zza(String str, long j, long j2) {
        if (this.zzaiv != null) {
            this.handler.post(new zzij(this, str, j, j2));
        }
    }

    public final void zzb(zzhq zzhq) {
        if (this.zzaiv != null) {
            this.handler.post(new zzim(this, zzhq));
        }
    }

    public final void zza(int i, long j, long j2) {
        if (this.zzaiv != null) {
            this.handler.post(new zzil(this, i, j, j2));
        }
    }

    public final void zzb(zzjj zzjj) {
        if (this.zzaiv != null) {
            this.handler.post(new zzio(this, zzjj));
        }
    }

    public final void zzw(int i) {
        if (this.zzaiv != null) {
            this.handler.post(new zzin(this, i));
        }
    }
}
