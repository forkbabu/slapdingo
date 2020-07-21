package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdpw implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzebv;
    private zzdqu zzhhv;
    private final String zzhhw;
    private final LinkedBlockingQueue<zzcf.zza> zzhhx = new LinkedBlockingQueue<>();

    public zzdpw(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhhw = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zzebv = handlerThread;
        handlerThread.start();
        this.zzhhv = new zzdqu(context, this.zzebv.getLooper(), this, this, 9200000);
        this.zzhhv.checkAvailabilityAndConnect();
    }

    public final zzcf.zza zzec(int i) {
        zzcf.zza zza;
        try {
            zza = this.zzhhx.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zza = null;
        }
        return zza == null ? zzauy() : zza;
    }

    private final zzdqx zzaux() {
        try {
            return this.zzhhv.zzavm();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzhhx.put(zzauy());
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|11|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        zzape();
        r3.zzebv.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.zzhhx.put(zzauy());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        zzape();
        r3.zzebv.quit();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzdqx r4 = r3.zzaux()
            if (r4 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzdqt r0 = new com.google.android.gms.internal.ads.zzdqt     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = r3.packageName     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r3.zzhhw     // Catch:{ all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdqv r4 = r4.zza(r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzcf$zza r4 = r4.zzavn()     // Catch:{ all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzcf$zza> r0 = r3.zzhhx     // Catch:{ all -> 0x0025 }
            r0.put(r4)     // Catch:{ all -> 0x0025 }
            r3.zzape()
            android.os.HandlerThread r4 = r3.zzebv
            r4.quit()
            return
        L_0x0025:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzcf$zza> r4 = r3.zzhhx     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            com.google.android.gms.internal.ads.zzcf$zza r0 = zzauy()     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            goto L_0x0039
        L_0x002f:
            r4 = move-exception
            r3.zzape()
            android.os.HandlerThread r0 = r3.zzebv
            r0.quit()
            throw r4
        L_0x0039:
            r3.zzape()
            android.os.HandlerThread r4 = r3.zzebv
            r4.quit()
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpw.onConnected(android.os.Bundle):void");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhhx.put(zzauy());
        } catch (InterruptedException unused) {
        }
    }

    private final void zzape() {
        zzdqu zzdqu = this.zzhhv;
        if (zzdqu == null) {
            return;
        }
        if (zzdqu.isConnected() || this.zzhhv.isConnecting()) {
            this.zzhhv.disconnect();
        }
    }

    private static zzcf.zza zzauy() {
        return (zzcf.zza) ((zzegb) zzcf.zza.zzar().zzn(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzbfq());
    }
}
