package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzxh extends zzgu implements zzxf {
    zzxh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzww zza(IObjectWrapper iObjectWrapper, zzvh zzvh, String str, zzamr zzamr, int i) throws RemoteException {
        zzww zzww;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzvh);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamr);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzww = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzww) {
                zzww = (zzww) queryLocalInterface;
            } else {
                zzww = new zzwy(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzww;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzww zzb(IObjectWrapper iObjectWrapper, zzvh zzvh, String str, zzamr zzamr, int i) throws RemoteException {
        zzww zzww;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzvh);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamr);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzww = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzww) {
                zzww = (zzww) queryLocalInterface;
            } else {
                zzww = new zzwy(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzww;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzwp zza(IObjectWrapper iObjectWrapper, String str, zzamr zzamr, int i) throws RemoteException {
        zzwp zzwp;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamr);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzwp = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzwp) {
                zzwp = (zzwp) queryLocalInterface;
            } else {
                zzwp = new zzwr(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzwp;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzxm zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzxm zzxm;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxm = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzxm) {
                zzxm = (zzxm) queryLocalInterface;
            } else {
                zzxm = new zzxo(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxm;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzadx zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
        zzadx zzp = zzadw.zzp(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzatj zza(IObjectWrapper iObjectWrapper, zzamr zzamr, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamr);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken);
        zzatj zzal = zzatm.zzal(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzal;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzaqt zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        zzaqt zzai = zzaqw.zzai(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzai;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzaqi zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken);
        zzaqi zzag = zzaqh.zzag(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzag;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzxm zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzxm zzxm;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxm = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzxm) {
                zzxm = (zzxm) queryLocalInterface;
            } else {
                zzxm = new zzxo(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxm;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzww zza(IObjectWrapper iObjectWrapper, zzvh zzvh, String str, int i) throws RemoteException {
        zzww zzww;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzvh);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzww = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzww) {
                zzww = (zzww) queryLocalInterface;
            } else {
                zzww = new zzwy(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzww;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzaea zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper3);
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken);
        zzaea zzq = zzaed.zzq(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzaui zzb(IObjectWrapper iObjectWrapper, String str, zzamr zzamr, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamr);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken);
        zzaui zzap = zzauh.zzap(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzap;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzww zzc(IObjectWrapper iObjectWrapper, zzvh zzvh, String str, zzamr zzamr, int i) throws RemoteException {
        zzww zzww;
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzvh);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamr);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken);
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzww = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzww) {
                zzww = (zzww) queryLocalInterface;
            } else {
                zzww = new zzwy(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzww;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final zzawr zzb(IObjectWrapper iObjectWrapper, zzamr zzamr, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(obtainAndWriteInterfaceToken, zzamr);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken);
        zzawr zzaq = zzawu.zzaq(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzaq;
    }
}
