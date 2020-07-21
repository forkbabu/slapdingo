package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzo extends zzauh {
    @Override // com.google.android.gms.internal.ads.zzaui
    public final String getMediationAdapterClassName() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzauj zzauj) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzaur zzaur) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzauz zzauz) {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzxx zzxx) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzyc zzyc) {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final zzyd zzkj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final zzaud zzqv() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzve zzve, zzauq zzauq) throws RemoteException {
        zza(zzauq);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zzb(zzve zzve, zzauq zzauq) throws RemoteException {
        zza(zzauq);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    private static void zza(zzauq zzauq) {
        zzbba.zzfb("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbaq.zzaag.post(new zzzr(zzauq));
    }
}
