package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzaza implements DialogInterface.OnClickListener {
    private final String zzdfg;
    private final zzayv zzeaj;

    zzaza(zzayv zzayv, String str) {
        this.zzeaj = zzayv;
        this.zzdfg = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeaj.zza(this.zzdfg, dialogInterface, i);
    }
}
