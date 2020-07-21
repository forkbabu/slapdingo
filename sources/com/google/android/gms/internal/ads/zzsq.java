package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzsq {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final Runnable zzbup = new zzst(this);
    /* access modifiers changed from: private */
    public zzsz zzbuq;
    /* access modifiers changed from: private */
    public zztd zzbur;
    private Context zzvr;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.Context r1 = r2.zzvr     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zzvr = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaav.zzcsh     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.connect()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaav.zzcsg     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzss r3 = new com.google.android.gms.internal.ads.zzss     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzre r1 = com.google.android.gms.ads.internal.zzq.zzkz()     // Catch:{ all -> 0x0048 }
            r1.zza(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsq.initialize(android.content.Context):void");
    }

    public final void zzmu() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcsi)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                zzq.zzkw();
                zzaye.zzdzw.removeCallbacks(this.zzbup);
                zzq.zzkw();
                zzaye.zzdzw.postDelayed(this.zzbup, ((Long) zzwg.zzpw().zzd(zzaav.zzcsj)).longValue());
            }
        }
    }

    public final zzsx zza(zzsy zzsy) {
        synchronized (this.lock) {
            if (this.zzbur == null) {
                zzsx zzsx = new zzsx();
                return zzsx;
            }
            try {
                zzsx zza = this.zzbur.zza(zzsy);
                return zza;
            } catch (RemoteException e) {
                zzaxv.zzc("Unable to call into cache service.", e);
                return new zzsx();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            android.content.Context r1 = r3.zzvr     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzsz r1 = r3.zzbuq     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.google.android.gms.internal.ads.zzsv r1 = new com.google.android.gms.internal.ads.zzsv     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzsu r2 = new com.google.android.gms.internal.ads.zzsu     // Catch:{ all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzsz r1 = r3.zza(r1, r2)     // Catch:{ all -> 0x0023 }
            r3.zzbuq = r1     // Catch:{ all -> 0x0023 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsq.connect():void");
    }

    private final synchronized zzsz zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzsz(this.zzvr, zzq.zzlk().zzya(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbuq != null) {
                if (this.zzbuq.isConnected() || this.zzbuq.isConnecting()) {
                    this.zzbuq.disconnect();
                }
                this.zzbuq = null;
                this.zzbur = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
