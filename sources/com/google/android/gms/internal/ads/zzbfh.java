package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbfh implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzele;

    zzbfh(JsResult jsResult) {
        this.zzele = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzele.cancel();
    }
}
