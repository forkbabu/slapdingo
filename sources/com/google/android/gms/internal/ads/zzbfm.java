package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbfm implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzelf;

    zzbfm(JsPromptResult jsPromptResult) {
        this.zzelf = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzelf.cancel();
    }
}
