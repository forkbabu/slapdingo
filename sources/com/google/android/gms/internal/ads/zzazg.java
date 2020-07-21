package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzazg implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzazd zzeav;

    zzazg(zzazd zzazd) {
        this.zzeav = zzazd;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzq.zzkw();
        zzaye.zza(this.zzeav.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
