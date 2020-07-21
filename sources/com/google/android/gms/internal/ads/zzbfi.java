package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbfi implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzele;

    zzbfi(JsResult jsResult) {
        this.zzele = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzele.cancel();
    }
}
