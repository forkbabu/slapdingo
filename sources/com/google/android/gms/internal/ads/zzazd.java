package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzazd implements Runnable {
    final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzeao;
    private final /* synthetic */ boolean zzeap;
    private final /* synthetic */ boolean zzeaq;

    zzazd(zzaze zzaze, Context context, String str, boolean z, boolean z2) {
        this.val$context = context;
        this.zzeao = str;
        this.zzeap = z;
        this.zzeaq = z2;
    }

    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.val$context);
        builder.setMessage(this.zzeao);
        if (this.zzeap) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.zzeaq) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new zzazg(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
