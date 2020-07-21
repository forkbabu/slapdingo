package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzaum extends zzgt implements zzauj {
    public zzaum() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaud zzaud;
        if (i == 1) {
            onRewardedAdOpened();
        } else if (i == 2) {
            onRewardedAdClosed();
        } else if (i == 3) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaud = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                if (queryLocalInterface instanceof zzaud) {
                    zzaud = (zzaud) queryLocalInterface;
                } else {
                    zzaud = new zzauf(readStrongBinder);
                }
            }
            zza(zzaud);
        } else if (i == 4) {
            onRewardedAdFailedToShow(parcel.readInt());
        } else if (i != 5) {
            return false;
        } else {
            zzb((zzuy) zzgw.zza(parcel, zzuy.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
