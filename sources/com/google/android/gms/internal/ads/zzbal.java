package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbal extends BroadcastReceiver {
    private final /* synthetic */ zzbam zzece;

    zzbal(zzbam zzbam) {
        this.zzece = zzbam;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzece.zzc(context, intent);
    }
}
