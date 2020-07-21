package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzfu implements Callable {
    private final zzcf.zza.C0006zza zzabb;
    private final zzex zzwf;

    public zzfu(zzex zzex, zzcf.zza.C0006zza zza) {
        this.zzwf = zzex;
        this.zzabb = zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcz */
    public final Void call() throws Exception {
        if (this.zzwf.zzcq() != null) {
            this.zzwf.zzcq().get();
        }
        zzcf.zza zzcp = this.zzwf.zzcp();
        if (zzcp == null) {
            return null;
        }
        try {
            synchronized (this.zzabb) {
                zzcf.zza.C0006zza zza = this.zzabb;
                byte[] byteArray = zzcp.toByteArray();
                zza.zza(byteArray, 0, byteArray.length, zzefo.zzber());
            }
            return null;
        } catch (zzegl unused) {
            return null;
        }
    }
}
