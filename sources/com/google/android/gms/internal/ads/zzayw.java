package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzayw {
    private float zzdpz = 1.0f;
    private boolean zzdqf = false;

    public final synchronized void setAppVolume(float f) {
        this.zzdpz = f;
    }

    public final synchronized float zzqc() {
        if (!zzxv()) {
            return 1.0f;
        }
        return this.zzdpz;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzdqf = z;
    }

    public final synchronized boolean zzqd() {
        return this.zzdqf;
    }

    private final synchronized boolean zzxv() {
        return this.zzdpz >= 0.0f;
    }

    public static float zzbi(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return ((float) streamVolume) / ((float) streamMaxVolume);
    }
}
