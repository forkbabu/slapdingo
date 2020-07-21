package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbgl implements zzbgn {
    private final zzbfn zzeot;

    zzbgl(zzbfn zzbfn) {
        this.zzeot = zzbfn;
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final void zzh(Uri uri) {
        zzbgz zzaaz = this.zzeot.zzaaz();
        if (zzaaz == null) {
            zzaxv.zzfb("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaaz.zzh(uri);
        }
    }
}
