package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzapw implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapu zzdmk;

    zzapw(zzapu zzapu) {
        this.zzdmk = zzapu;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdmk.zzdw("User canceled the download.");
    }
}
