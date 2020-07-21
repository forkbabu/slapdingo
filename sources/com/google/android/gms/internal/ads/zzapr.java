package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzapr implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapo zzdlt;

    zzapr(zzapo zzapo) {
        this.zzdlt = zzapo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent createIntent = this.zzdlt.createIntent();
        zzq.zzkw();
        zzaye.zza(this.zzdlt.zzvr, createIntent);
    }
}
