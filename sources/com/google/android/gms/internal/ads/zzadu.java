package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzadu extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzdce;
    private final zzadt zzdcj;
    private final Drawable zzdck;

    public zzadu(zzadt zzadt) {
        Drawable drawable;
        int i;
        this.zzdcj = zzadt;
        Uri uri2 = null;
        try {
            IObjectWrapper zzry = zzadt.zzry();
            if (zzry != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzry);
                this.zzdck = drawable;
                uri2 = this.zzdcj.getUri();
                this.uri = uri2;
                double d = 1.0d;
                d = this.zzdcj.getScale();
                this.zzdce = d;
                int i2 = -1;
                i = this.zzdcj.getWidth();
                this.width = i;
                i2 = this.zzdcj.getHeight();
                this.height = i2;
            }
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
        drawable = null;
        this.zzdck = drawable;
        try {
            uri2 = this.zzdcj.getUri();
        } catch (RemoteException e2) {
            zzbba.zzc("", e2);
        }
        this.uri = uri2;
        double d2 = 1.0d;
        try {
            d2 = this.zzdcj.getScale();
        } catch (RemoteException e3) {
            zzbba.zzc("", e3);
        }
        this.zzdce = d2;
        int i22 = -1;
        try {
            i = this.zzdcj.getWidth();
        } catch (RemoteException e4) {
            zzbba.zzc("", e4);
            i = -1;
        }
        this.width = i;
        try {
            i22 = this.zzdcj.getHeight();
        } catch (RemoteException e5) {
            zzbba.zzc("", e5);
        }
        this.height = i22;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzdck;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzdce;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getWidth() {
        return this.width;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getHeight() {
        return this.height;
    }
}
