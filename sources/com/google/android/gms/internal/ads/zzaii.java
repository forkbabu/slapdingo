package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzaii extends zzgt implements zzaij {
    public zzaii() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzaij zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzaij) {
            return (zzaij) queryLocalInterface;
        }
        return new zzail(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zze(parcel.createTypedArrayList(zzaic.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
