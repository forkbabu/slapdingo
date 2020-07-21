package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzbw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.opencv.features2d.FeatureDetector;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdpy implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final long startTime;
    private final HandlerThread zzebv;
    private zzdqu zzhhv;
    private final LinkedBlockingQueue<zzdrf> zzhhx;
    private final String zzhhz;
    private final String zzhia;
    private final int zzhib = 1;
    private final zzdpm zzvv;
    private final zzgo zzvx;

    public zzdpy(Context context, int i, zzgo zzgo, String str, String str2, String str3, zzdpm zzdpm) {
        this.zzhhz = str;
        this.zzvx = zzgo;
        this.zzhia = str2;
        this.zzvv = zzdpm;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzebv = handlerThread;
        handlerThread.start();
        this.startTime = System.currentTimeMillis();
        this.zzhhv = new zzdqu(context, this.zzebv.getLooper(), this, this, 19621000);
        this.zzhhx = new LinkedBlockingQueue<>();
        this.zzhhv.checkAvailabilityAndConnect();
    }

    public final zzdrf zzed(int i) {
        zzdrf zzdrf;
        try {
            zzdrf = this.zzhhx.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzb(FeatureDetector.PYRAMID_SIMPLEBLOB, this.startTime, e);
            zzdrf = null;
        }
        zzb(3004, this.startTime, null);
        if (zzdrf != null) {
            if (zzdrf.status == 7) {
                zzdpm.zzb(zzbw.zza.zzc.DISABLED);
            } else {
                zzdpm.zzb(zzbw.zza.zzc.ENABLED);
            }
        }
        return zzdrf == null ? zzauz() : zzdrf;
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
            zzb(4011, this.startTime, null);
            this.zzhhx.put(zzauz());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzdqx zzaux = zzaux();
        if (zzaux != null) {
            try {
                zzdrf zza = zzaux.zza(new zzdrd(this.zzhib, this.zzvx, this.zzhhz, this.zzhia));
                zzb(5011, this.startTime, null);
                this.zzhhx.put(zza);
            } catch (Throwable th) {
                zzb(FeatureDetector.PYRAMID_DENSE, this.startTime, new Exception(th));
            } finally {
                zzape();
                this.zzebv.quit();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzb(4012, this.startTime, null);
            this.zzhhx.put(zzauz());
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

    private static zzdrf zzauz() {
        return new zzdrf(null, 1);
    }

    private final void zzb(int i, long j, Exception exc) {
        zzdpm zzdpm = this.zzvv;
        if (zzdpm != null) {
            zzdpm.zza(i, System.currentTimeMillis() - j, exc);
        }
    }
}
