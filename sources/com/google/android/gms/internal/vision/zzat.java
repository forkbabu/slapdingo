package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzat extends ContentObserver {
    zzat(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzaq.zzfe.set(true);
    }
}
