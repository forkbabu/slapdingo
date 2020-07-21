package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzahy extends zzahv {
    private final /* synthetic */ zzbbn zzbvf;

    zzahy(zzahz zzahz, zzbbn zzbbn) {
        this.zzbvf = zzbbn;
    }

    @Override // com.google.android.gms.internal.ads.zzahs
    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zzbvf.set(parcelFileDescriptor);
    }
}
