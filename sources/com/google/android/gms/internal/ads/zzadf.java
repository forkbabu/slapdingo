package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzadf extends zzads {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzdcd;
    private final double zzdce;

    public zzadf(Drawable drawable, Uri uri2, double d, int i, int i2) {
        this.zzdcd = drawable;
        this.uri = uri2;
        this.zzdce = d;
        this.width = i;
        this.height = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final IObjectWrapper zzry() throws RemoteException {
        return ObjectWrapper.wrap(this.zzdcd);
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final Uri getUri() throws RemoteException {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final double getScale() {
        return this.zzdce;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final int getWidth() {
        return this.width;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final int getHeight() {
        return this.height;
    }
}
