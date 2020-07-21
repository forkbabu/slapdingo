package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbfl implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzelf;
    private final /* synthetic */ EditText zzelg;

    zzbfl(JsPromptResult jsPromptResult, EditText editText) {
        this.zzelf = jsPromptResult;
        this.zzelg = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzelf.confirm(this.zzelg.getText().toString());
    }
}
