package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzte {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzsz zzbuq;
    /* access modifiers changed from: private */
    public boolean zzbvd;
    private final Context zzvr;

    zzte(Context context) {
        this.zzvr = context;
    }

    /* access modifiers changed from: package-private */
    public final Future<InputStream> zzb(zzsy zzsy) {
        zzth zzth = new zzth(this);
        zztg zztg = new zztg(this, zzsy, zzth);
        zztk zztk = new zztk(this, zzth);
        synchronized (this.lock) {
            zzsz zzsz = new zzsz(this.zzvr, zzq.zzlk().zzya(), zztg, zztk);
            this.zzbuq = zzsz;
            zzsz.checkAvailabilityAndConnect();
        }
        return zzth;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbuq != null) {
                this.zzbuq.disconnect();
                this.zzbuq = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
