package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzbcm extends TextureView implements zzbdf {
    protected final zzbcw zzeew = new zzbcw();
    protected final zzbdg zzeex;

    public zzbcm(Context context) {
        super(context);
        this.zzeex = new zzbdg(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzbcj zzbcj);

    public void zzdj(int i) {
    }

    public void zzdk(int i) {
    }

    public void zzdl(int i) {
    }

    public void zzdm(int i) {
    }

    public void zzdn(int i) {
    }

    public abstract String zzyo();

    @Override // com.google.android.gms.internal.ads.zzbdf
    public abstract void zzys();

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }
}
