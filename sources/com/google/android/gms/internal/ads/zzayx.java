package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzayx implements DialogInterface.OnClickListener {
    private final zzayv zzeaj;
    private final int zzeak;
    private final int zzeal;
    private final int zzeam;

    zzayx(zzayv zzayv, int i, int i2, int i3) {
        this.zzeaj = zzayv;
        this.zzeak = i;
        this.zzeal = i2;
        this.zzeam = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeaj.zza(this.zzeak, this.zzeal, this.zzeam, dialogInterface, i);
    }
}
