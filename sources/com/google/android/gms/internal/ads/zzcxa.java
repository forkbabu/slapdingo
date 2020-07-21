package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcxa implements AppEventListener {
    private zzxe zzgpq;

    public final synchronized void zzb(zzxe zzxe) {
        this.zzgpq = zzxe;
    }

    public final synchronized zzxe zzapv() {
        return this.zzgpq;
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzgpq != null) {
            try {
                this.zzgpq.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzaxv.zzd("Remote Exception at onAppEvent.", e);
            }
        }
    }
}
