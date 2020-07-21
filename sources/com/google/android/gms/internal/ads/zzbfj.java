package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbfj implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzelf;

    zzbfj(JsPromptResult jsPromptResult) {
        this.zzelf = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzelf.cancel();
    }
}
