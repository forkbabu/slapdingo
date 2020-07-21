package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzws extends zzgt implements zzwp {
    public zzws() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzwj zzwj = null;
        zzxk zzxk = null;
        switch (i) {
            case 1:
                zzwo zzqb = zzqb();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzqb);
                return true;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzwj) {
                        zzwj = (zzwj) queryLocalInterface;
                    } else {
                        zzwj = new zzwl(readStrongBinder);
                    }
                }
                zzb(zzwj);
                parcel2.writeNoException();
                return true;
            case 3:
                zza(zzaes.zzs(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                zza(zzaex.zzt(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                zza(parcel.readString(), zzafd.zzv(parcel.readStrongBinder()), zzaey.zzu(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zza((zzadj) zzgw.zza(parcel, zzadj.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface2 instanceof zzxk) {
                        zzxk = (zzxk) queryLocalInterface2;
                    } else {
                        zzxk = new zzxj(readStrongBinder2);
                    }
                }
                zzb(zzxk);
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzafg.zzw(parcel.readStrongBinder()), (zzvh) zzgw.zza(parcel, zzvh.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                zza((PublisherAdViewOptions) zzgw.zza(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                zza(zzafl.zzx(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zza((zzaio) zzgw.zza(parcel, zzaio.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzaiz.zzab(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
