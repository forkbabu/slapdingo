package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzapq implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapo zzdlt;

    zzapq(zzapo zzapo) {
        this.zzdlt = zzapo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdlt.zzdw("Operation denied by user.");
    }
}
