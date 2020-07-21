package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcpk implements zzduu<ParcelFileDescriptor> {
    private final /* synthetic */ zzasg zzgim;

    zzcpk(zzcoy zzcoy, zzasg zzasg) {
        this.zzgim = zzasg;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        try {
            this.zzgim.zza(zzazi.zzc(th));
        } catch (RemoteException e) {
            zzaxv.zza("Service can't call client", e);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.zzgim.zzb(parcelFileDescriptor);
        } catch (RemoteException e) {
            zzaxv.zza("Service can't call client", e);
        }
    }
}
