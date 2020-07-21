package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcdm implements zzahc {
    private final zzcdn zzfyr;
    private final zzafo zzfys;

    zzcdm(zzcdn zzcdn, zzafo zzafo) {
        this.zzfyr = zzcdn;
        this.zzfys = zzafo;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map map) {
        zzcdn zzcdn = this.zzfyr;
        zzafo zzafo = this.zzfys;
        try {
            zzcdn.zzfyx = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzaxv.zzfb("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzcdn.zzfyw = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzafo == null) {
            zzaxv.zzee("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzafo.onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }
}
