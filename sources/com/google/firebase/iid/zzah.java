package com.google.firebase.iid;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
final /* synthetic */ class zzah implements Runnable {
    private final zzac zza;
    private final IBinder zzb;

    zzah(zzac zzac, IBinder iBinder) {
        this.zza = zzac;
        this.zzb = iBinder;
    }

    public final void run() {
        zzac zzac = this.zza;
        IBinder iBinder = this.zzb;
        synchronized (zzac) {
            if (iBinder == null) {
                zzac.zza(0, "Null service connection");
                return;
            }
            try {
                zzac.zzc = new zzal(iBinder);
                zzac.zza = 2;
                zzac.zza();
            } catch (RemoteException e) {
                zzac.zza(0, e.getMessage());
            }
        }
    }
}
