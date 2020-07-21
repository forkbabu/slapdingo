package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzasc extends zzgt implements zzarz {
    public zzasc() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            zzase zzase = null;
            zzasg zzasg = null;
            zzasg zzasg2 = null;
            zzasg zzasg3 = null;
            zzasg zzasg4 = null;
            if (i == 2) {
                zzart zzart = (zzart) zzgw.zza(parcel, zzart.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzase) {
                        zzase = (zzase) queryLocalInterface;
                    } else {
                        zzase = new zzasd(readStrongBinder);
                    }
                }
                zza(zzart, zzase);
                parcel2.writeNoException();
            } else if (i == 4) {
                zzasm zzasm = (zzasm) zzgw.zza(parcel, zzasm.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface2 instanceof zzasg) {
                        zzasg4 = (zzasg) queryLocalInterface2;
                    } else {
                        zzasg4 = new zzasi(readStrongBinder2);
                    }
                }
                zza(zzasm, zzasg4);
                parcel2.writeNoException();
            } else if (i == 5) {
                zzasm zzasm2 = (zzasm) zzgw.zza(parcel, zzasm.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface3 instanceof zzasg) {
                        zzasg3 = (zzasg) queryLocalInterface3;
                    } else {
                        zzasg3 = new zzasi(readStrongBinder3);
                    }
                }
                zzb(zzasm2, zzasg3);
                parcel2.writeNoException();
            } else if (i == 6) {
                zzasm zzasm3 = (zzasm) zzgw.zza(parcel, zzasm.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface4 instanceof zzasg) {
                        zzasg2 = (zzasg) queryLocalInterface4;
                    } else {
                        zzasg2 = new zzasi(readStrongBinder4);
                    }
                }
                zzc(zzasm3, zzasg2);
                parcel2.writeNoException();
            } else if (i != 7) {
                return false;
            } else {
                String readString = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface5 instanceof zzasg) {
                        zzasg = (zzasg) queryLocalInterface5;
                    } else {
                        zzasg = new zzasi(readStrongBinder5);
                    }
                }
                zza(readString, zzasg);
                parcel2.writeNoException();
            }
        } else {
            zzarv zza = zza((zzart) zzgw.zza(parcel, zzart.CREATOR));
            parcel2.writeNoException();
            zzgw.zzb(parcel2, zza);
        }
        return true;
    }
}
