package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbcy implements SensorEventListener {
    private final SensorManager zzega;
    private final Object zzegb = new Object();
    private final Display zzegc;
    private final float[] zzegd = new float[9];
    private final float[] zzege = new float[9];
    private float[] zzegf;
    private Handler zzegg;
    private zzbda zzegh;

    zzbcy(Context context) {
        this.zzega = (SensorManager) context.getSystemService("sensor");
        this.zzegc = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        if (this.zzegg == null) {
            Sensor defaultSensor = this.zzega.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzaxv.zzfb("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            zzdrr zzdrr = new zzdrr(handlerThread.getLooper());
            this.zzegg = zzdrr;
            if (!this.zzega.registerListener(this, defaultSensor, 0, zzdrr)) {
                zzaxv.zzfb("SensorManager.registerListener failed.");
                stop();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void stop() {
        if (this.zzegg != null) {
            this.zzega.unregisterListener(this);
            this.zzegg.post(new zzbcx(this));
            this.zzegg = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbda zzbda) {
        this.zzegh = zzbda;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzegb) {
                if (this.zzegf == null) {
                    this.zzegf = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzegd, fArr);
            int rotation = this.zzegc.getRotation();
            if (rotation == 1) {
                SensorManager.remapCoordinateSystem(this.zzegd, 2, 129, this.zzege);
            } else if (rotation == 2) {
                SensorManager.remapCoordinateSystem(this.zzegd, 129, 130, this.zzege);
            } else if (rotation != 3) {
                System.arraycopy(this.zzegd, 0, this.zzege, 0, 9);
            } else {
                SensorManager.remapCoordinateSystem(this.zzegd, 130, 1, this.zzege);
            }
            zzl(1, 3);
            zzl(2, 6);
            zzl(5, 7);
            synchronized (this.zzegb) {
                System.arraycopy(this.zzege, 0, this.zzegf, 0, 9);
            }
            zzbda zzbda = this.zzegh;
            if (zzbda != null) {
                zzbda.zzup();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(float[] fArr) {
        synchronized (this.zzegb) {
            if (this.zzegf == null) {
                return false;
            }
            System.arraycopy(this.zzegf, 0, fArr, 0, this.zzegf.length);
            return true;
        }
    }

    private final void zzl(int i, int i2) {
        float[] fArr = this.zzege;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }
}
