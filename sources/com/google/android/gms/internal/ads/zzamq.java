package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzamq extends zzgt implements zzamr {
    public zzamq() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzamr zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzamr) {
            return (zzamr) queryLocalInterface;
        }
        return new zzamt(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzams zzdh = zzdh(parcel.readString());
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzdh);
        } else if (i == 2) {
            boolean zzdi = zzdi(parcel.readString());
            parcel2.writeNoException();
            zzgw.writeBoolean(parcel2, zzdi);
        } else if (i != 3) {
            return false;
        } else {
            zzaox zzdl = zzdl(parcel.readString());
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzdl);
        }
        return true;
    }
}
