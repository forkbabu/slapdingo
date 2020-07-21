package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzauh extends zzgt implements zzaui {
    public zzauh() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzaui zzap(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzaui) {
            return (zzaui) queryLocalInterface;
        }
        return new zzauk(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzauq zzauq = null;
        zzauq zzauq2 = null;
        zzaur zzaur = null;
        zzauj zzauj = null;
        switch (i) {
            case 1:
                zzve zzve = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface instanceof zzauq) {
                        zzauq = (zzauq) queryLocalInterface;
                    } else {
                        zzauq = new zzaus(readStrongBinder);
                    }
                }
                zza(zzve, zzauq);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    if (queryLocalInterface2 instanceof zzauj) {
                        zzauj = (zzauj) queryLocalInterface2;
                    } else {
                        zzauj = new zzaul(readStrongBinder2);
                    }
                }
                zza(zzauj);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isLoaded = isLoaded();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isLoaded);
                return true;
            case 4:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 5:
                zzh(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    if (queryLocalInterface3 instanceof zzaur) {
                        zzaur = (zzaur) queryLocalInterface3;
                    } else {
                        zzaur = new zzauu(readStrongBinder3);
                    }
                }
                zza(zzaur);
                parcel2.writeNoException();
                return true;
            case 7:
                zza((zzauz) zzgw.zza(parcel, zzauz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzya.zzh(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, adMetadata);
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 11:
                zzaud zzqv = zzqv();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzqv);
                return true;
            case 12:
                zzyd zzkj = zzkj();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzkj);
                return true;
            case 13:
                zza(zzyb.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                zzve zzve2 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface4 instanceof zzauq) {
                        zzauq2 = (zzauq) queryLocalInterface4;
                    } else {
                        zzauq2 = new zzaus(readStrongBinder4);
                    }
                }
                zzb(zzve2, zzauq2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
