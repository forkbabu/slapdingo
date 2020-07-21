package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxt {
    public static void zzao(Context context) {
        if (zzbau.zzbt(context) && !zzbau.zzyl()) {
            zzdvf<?> zzwq = new zzaxw(context).zzwq();
            zzaxv.zzfc("Updating ad debug logging enablement.");
            zzbbj.zza(zzwq, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
