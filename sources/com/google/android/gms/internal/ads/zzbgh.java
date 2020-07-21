package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbgh extends zzyh {
    private final Object lock = new Object();
    private boolean zzadp;
    private boolean zzadq;
    private int zzaer;
    private zzyj zzdjy;
    private final zzbdb zzeez;
    private final boolean zzeok;
    private final boolean zzeol;
    private boolean zzeom;
    private boolean zzeon = true;
    private float zzeoo;
    private float zzeop;
    private float zzeoq;
    private zzaff zzeor;

    public zzbgh(zzbdb zzbdb, float f, boolean z, boolean z2) {
        this.zzeez = zzbdb;
        this.zzeoo = f;
        this.zzeok = z;
        this.zzeol = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void play() {
        zzf("play", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void pause() {
        zzf("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void stop() {
        zzf("stop", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void mute(boolean z) {
        zzf(z ? "mute" : "unmute", null);
    }

    public final void zzb(zzaaa zzaaa) {
        boolean z = zzaaa.zzado;
        boolean z2 = zzaaa.zzadp;
        boolean z3 = zzaaa.zzadq;
        synchronized (this.lock) {
            this.zzadp = z2;
            this.zzadq = z3;
        }
        zzf("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    private final void zzf(String str, Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbbf.zzedl.execute(new zzbgk(this, hashMap));
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeon;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzaer;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzeoq;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final float getDuration() {
        float f;
        synchronized (this.lock) {
            f = this.zzeoo;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final float getCurrentTime() {
        float f;
        synchronized (this.lock) {
            f = this.zzeop;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void zza(zzyj zzyj) {
        synchronized (this.lock) {
            this.zzdjy = zzyj;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final zzyj zzqi() throws RemoteException {
        zzyj zzyj;
        synchronized (this.lock) {
            zzyj = this.zzdjy;
        }
        return zzyj;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeok && this.zzadp;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    if (this.zzadq && this.zzeol) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
        }
        return z;
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzeop = f;
        }
    }

    public final void zzacn() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzeon;
            i = this.zzaer;
            this.zzaer = 3;
        }
        zza(i, 3, z, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(float r4, float r5, int r6, boolean r7, float r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            float r1 = r3.zzeoo     // Catch:{ all -> 0x004f }
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0012
            float r1 = r3.zzeoq     // Catch:{ all -> 0x004f }
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            r3.zzeoo = r5     // Catch:{ all -> 0x004f }
            r3.zzeop = r4     // Catch:{ all -> 0x004f }
            boolean r4 = r3.zzeon     // Catch:{ all -> 0x004f }
            r3.zzeon = r7     // Catch:{ all -> 0x004f }
            int r5 = r3.zzaer     // Catch:{ all -> 0x004f }
            r3.zzaer = r6     // Catch:{ all -> 0x004f }
            float r2 = r3.zzeoq     // Catch:{ all -> 0x004f }
            r3.zzeoq = r8     // Catch:{ all -> 0x004f }
            float r8 = r8 - r2
            float r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x004f }
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbdb r8 = r3.zzeez     // Catch:{ all -> 0x004f }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x004f }
            r8.invalidate()     // Catch:{ all -> 0x004f }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzaff r8 = r3.zzeor     // Catch:{ RemoteException -> 0x0045 }
            if (r8 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzaff r8 = r3.zzeor     // Catch:{ RemoteException -> 0x0045 }
            r8.zzsl()     // Catch:{ RemoteException -> 0x0045 }
            goto L_0x004b
        L_0x0045:
            r8 = move-exception
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbba.zze(r0, r8)
        L_0x004b:
            r3.zza(r5, r6, r4, r7)
            return
        L_0x004f:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgh.zza(float, float, int, boolean, float):void");
    }

    public final void zza(zzaff zzaff) {
        synchronized (this.lock) {
            this.zzeor = zzaff;
        }
    }

    private final void zza(int i, int i2, boolean z, boolean z2) {
        zzbbf.zzedl.execute(new zzbgj(this, i, i2, z, z2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = !this.zzeom && i2 == 1;
            boolean z6 = z4 && i2 == 1;
            boolean z7 = z4 && i2 == 2;
            boolean z8 = z4 && i2 == 3;
            boolean z9 = z != z2;
            if (this.zzeom || z5) {
                z3 = true;
            }
            this.zzeom = z3;
            if (z5) {
                try {
                    if (this.zzdjy != null) {
                        this.zzdjy.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzbba.zze("#007 Could not call remote method.", e);
                }
            }
            if (z6 && this.zzdjy != null) {
                this.zzdjy.onVideoPlay();
            }
            if (z7 && this.zzdjy != null) {
                this.zzdjy.onVideoPause();
            }
            if (z8) {
                if (this.zzdjy != null) {
                    this.zzdjy.onVideoEnd();
                }
                this.zzeez.zzzr();
            }
            if (z9 && this.zzdjy != null) {
                this.zzdjy.onVideoMute(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Map map) {
        this.zzeez.zza("pubVideoCmd", map);
    }
}
