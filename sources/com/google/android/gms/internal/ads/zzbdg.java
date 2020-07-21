package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbdg implements AudioManager.OnAudioFocusChangeListener {
    private float zzdj = 1.0f;
    private boolean zzeff;
    private final AudioManager zzeie;
    private final zzbdf zzeif;
    private boolean zzeig;
    private boolean zzeih;

    public zzbdg(Context context, zzbdf zzbdf) {
        this.zzeie = (AudioManager) context.getSystemService("audio");
        this.zzeif = zzbdf;
    }

    public final void setMuted(boolean z) {
        this.zzeih = z;
        zzzv();
    }

    public final void setVolume(float f) {
        this.zzdj = f;
        zzzv();
    }

    public final float getVolume() {
        float f = this.zzeih ? 0.0f : this.zzdj;
        if (this.zzeig) {
            return f;
        }
        return 0.0f;
    }

    public final void zzzt() {
        this.zzeff = true;
        zzzv();
    }

    public final void zzzu() {
        this.zzeff = false;
        zzzv();
    }

    public final void onAudioFocusChange(int i) {
        this.zzeig = i > 0;
        this.zzeif.zzys();
    }

    private final void zzzv() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = this.zzeff && !this.zzeih && this.zzdj > 0.0f;
        if (z4 && !(z2 = this.zzeig)) {
            AudioManager audioManager = this.zzeie;
            if (audioManager != null && !z2) {
                if (audioManager.requestAudioFocus(this, 3, 2) == 1) {
                    z3 = true;
                }
                this.zzeig = z3;
            }
            this.zzeif.zzys();
        } else if (!z4 && (z = this.zzeig)) {
            AudioManager audioManager2 = this.zzeie;
            if (audioManager2 != null && z) {
                if (audioManager2.abandonAudioFocus(this) == 0) {
                    z3 = true;
                }
                this.zzeig = z3;
            }
            this.zzeif.zzys();
        }
    }
}
