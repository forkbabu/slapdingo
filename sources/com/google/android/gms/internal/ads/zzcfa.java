package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcfa implements zzdrx {
    private final String zzdfo;
    private final int zzeal;
    private final int zzeam;
    private final double zzgav;

    zzcfa(String str, double d, int i, int i2) {
        this.zzdfo = str;
        this.zzgav = d;
        this.zzeal = i;
        this.zzeam = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        String str = this.zzdfo;
        return new zzadf(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzgav, this.zzeal, this.zzeam);
    }
}
