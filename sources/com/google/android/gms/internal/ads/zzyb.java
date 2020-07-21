package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzyb extends zzgt implements zzyc {
    public zzyb() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzyc zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzyc) {
            return (zzyc) queryLocalInterface;
        }
        return new zzye(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((zzvj) zzgw.zza(parcel, zzvj.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
