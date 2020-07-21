package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzaok extends zzgt implements zzaol {
    public zzaok() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzx(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else if (i != 2) {
            return false;
        } else {
            zzdp(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
