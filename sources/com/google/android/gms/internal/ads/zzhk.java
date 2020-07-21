package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzhk extends Handler {
    private final /* synthetic */ zzhh zzafy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzhk(zzhh zzhh, Looper looper) {
        super(looper);
        this.zzafy = zzhh;
    }

    public final void handleMessage(Message message) {
        this.zzafy.zza(message);
    }
}
