package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzadp implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzaep zzdci;

    public zzadp(zzaep zzaep) {
        this.zzdci = zzaep;
        try {
            zzaep.zzsj();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zzdci.zzsi();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zzdci.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
