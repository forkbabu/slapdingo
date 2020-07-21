package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzqe {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zzqf zzbmq;

    public zzqe(Handler handler2, zzqf zzqf) {
        this.handler = zzqf != null ? (Handler) zzpb.checkNotNull(handler2) : null;
        this.zzbmq = zzqf;
    }

    public final void zza(zzjj zzjj) {
        if (this.zzbmq != null) {
            this.handler.post(new zzqh(this, zzjj));
        }
    }

    public final void zza(String str, long j, long j2) {
        if (this.zzbmq != null) {
            this.handler.post(new zzqg(this, str, j, j2));
        }
    }

    public final void zzb(zzhq zzhq) {
        if (this.zzbmq != null) {
            this.handler.post(new zzqj(this, zzhq));
        }
    }

    public final void zze(int i, long j) {
        if (this.zzbmq != null) {
            this.handler.post(new zzqi(this, i, j));
        }
    }

    public final void zza(int i, int i2, int i3, float f) {
        if (this.zzbmq != null) {
            this.handler.post(new zzql(this, i, i2, i3, f));
        }
    }

    public final void zza(Surface surface) {
        if (this.zzbmq != null) {
            this.handler.post(new zzqk(this, surface));
        }
    }

    public final void zzb(zzjj zzjj) {
        if (this.zzbmq != null) {
            this.handler.post(new zzqm(this, zzjj));
        }
    }
}
