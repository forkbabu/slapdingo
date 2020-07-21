package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzayk extends BroadcastReceiver {
    private final /* synthetic */ zzaye zzeaa;

    private zzayk(zzaye zzaye) {
        this.zzeaa = zzaye;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            boolean unused = this.zzeaa.zzyp = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            boolean unused2 = this.zzeaa.zzyp = false;
        }
    }

    /* synthetic */ zzayk(zzaye zzaye, zzayg zzayg) {
        this(zzaye);
    }
}
