package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzse extends zzgt implements zzsf {
    public zzse() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzsl zzsl;
        if (i == 2) {
            zzww zzdv = zzdv();
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzdv);
            return true;
        } else if (i != 3) {
            return false;
        } else {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzsl = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                if (queryLocalInterface instanceof zzsl) {
                    zzsl = (zzsl) queryLocalInterface;
                } else {
                    zzsl = new zzsn(readStrongBinder);
                }
            }
            zza(zzsl);
            parcel2.writeNoException();
            return true;
        }
    }
}
