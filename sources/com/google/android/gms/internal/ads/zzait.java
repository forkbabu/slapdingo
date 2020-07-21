package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzait extends zzgt implements zzaiq {
    public zzait() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaiv zzaiv;
        if (i == 3) {
            zzyi videoController = getVideoController();
            parcel2.writeNoException();
            zzgw.zza(parcel2, videoController);
            return true;
        } else if (i == 4) {
            destroy();
            parcel2.writeNoException();
            return true;
        } else if (i == 5) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaiv = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                if (queryLocalInterface instanceof zzaiv) {
                    zzaiv = (zzaiv) queryLocalInterface;
                } else {
                    zzaiv = new zzaix(readStrongBinder);
                }
            }
            zza(asInterface, zzaiv);
            parcel2.writeNoException();
            return true;
        } else if (i == 6) {
            zzr(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        } else if (i != 7) {
            return false;
        } else {
            zzado zzsn = zzsn();
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzsn);
            return true;
        }
    }
}
