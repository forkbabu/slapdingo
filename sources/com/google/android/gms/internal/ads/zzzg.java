package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzzg extends zzwn {
    final /* synthetic */ zzze zzckf;

    private zzzg(zzze zzze) {
        this.zzckf = zzze;
    }

    @Override // com.google.android.gms.internal.ads.zzwo
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwo
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwo
    public final String zzki() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwo
    public final void zzb(zzve zzve) throws RemoteException {
        zza(zzve, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzwo
    public final void zza(zzve zzve, int i) throws RemoteException {
        zzbba.zzfb("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbaq.zzaag.post(new zzzj(this));
    }
}
