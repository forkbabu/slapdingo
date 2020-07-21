package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzax extends ContentObserver {
    private final /* synthetic */ zzav zzfy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzax(zzav zzav, Handler handler) {
        super(null);
        this.zzfy = zzav;
    }

    public final void onChange(boolean z) {
        this.zzfy.zzw();
    }
}
