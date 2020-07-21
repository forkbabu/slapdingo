package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzxi extends zzgt implements zzxf {
    public zzxi() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzww zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvh) zzgw.zza(parcel, zzvh.CREATOR), parcel.readString(), zzamq.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza);
                return true;
            case 2:
                zzww zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvh) zzgw.zza(parcel, zzvh.CREATOR), parcel.readString(), zzamq.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzb);
                return true;
            case 3:
                zzwp zza2 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzamq.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza2);
                return true;
            case 4:
                zzxm zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzc);
                return true;
            case 5:
                zzadx zza3 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza3);
                return true;
            case 6:
                zzatj zza4 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzamq.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza4);
                return true;
            case 7:
                zzaqt zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzd);
                return true;
            case 8:
                zzaqi zzb2 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzb2);
                return true;
            case 9:
                zzxm zza5 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza5);
                return true;
            case 10:
                zzww zza6 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvh) zzgw.zza(parcel, zzvh.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza6);
                return true;
            case 11:
                zzaea zza7 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, zza7);
                return true;
            case 12:
                zzaui zzb3 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzamq.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzb3);
                return true;
            case 13:
                zzww zzc2 = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvh) zzgw.zza(parcel, zzvh.CREATOR), parcel.readString(), zzamq.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzc2);
                return true;
            case 14:
                zzawr zzb4 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzamq.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzb4);
                return true;
            default:
                return false;
        }
    }
}
