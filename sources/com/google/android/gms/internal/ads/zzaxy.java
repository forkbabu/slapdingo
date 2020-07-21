package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxy extends zzdrr {
    public zzaxy(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzq.zzla().zza(e, "AdMobHandler.handleMessage");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr
    public final void zzb(Message message) {
        try {
            super.zzb(message);
        } catch (Throwable th) {
            zzq.zzkw();
            zzaye.zza(zzq.zzla().getApplicationContext(), th);
            throw th;
        }
    }
}
