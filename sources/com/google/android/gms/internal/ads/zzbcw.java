package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbcw {
    private final long zzefx = TimeUnit.MILLISECONDS.toNanos(((Long) zzwg.zzpw().zzd(zzaav.zzcmd)).longValue());
    private long zzefy;
    private boolean zzefz = true;

    zzbcw() {
    }

    public final void zzyu() {
        this.zzefz = true;
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbcj zzbcj) {
        if (zzbcj != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzefz || Math.abs(timestamp - this.zzefy) >= this.zzefx) {
                this.zzefz = false;
                this.zzefy = timestamp;
                zzaye.zzdzw.post(new zzbcv(this, zzbcj));
            }
        }
    }
}
