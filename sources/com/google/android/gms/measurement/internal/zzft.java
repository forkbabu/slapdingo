package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzg;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzft implements ServiceConnection {
    final /* synthetic */ zzfq zza;
    /* access modifiers changed from: private */
    public final String zzb;

    zzft(zzfq zzfq, String str) {
        this.zza = zzfq;
        this.zzb = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzr().zzi().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzd zza2 = zzg.zza(iBinder);
            if (zza2 == null) {
                this.zza.zza.zzr().zzi().zza("Install Referrer Service implementation was not found");
                return;
            }
            this.zza.zza.zzr().zzx().zza("Install Referrer Service connected");
            this.zza.zza.zzq().zza(new zzfs(this, zza2, this));
        } catch (Exception e) {
            this.zza.zza.zzr().zzi().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzr().zzx().zza("Install Referrer Service disconnected");
    }
}
