package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzq extends zzatm {
    /* access modifiers changed from: private */
    public zzatq zzckk;

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void destroy() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void pause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void resume() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void setAppPackageName(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void setCustomData(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void show() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zza(zzath zzath) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zza(zzwz zzwz) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final zzyd zzkj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final boolean zzqw() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zza(zzatw zzatw) throws RemoteException {
        zzbba.zzfb("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbaq.zzaag.post(new zzzt(this));
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zza(zzatq zzatq) throws RemoteException {
        this.zzckk = zzatq;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }
}
