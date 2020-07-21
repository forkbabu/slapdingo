package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzamv extends zzgt implements zzams {
    public zzamv() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzamx zzamx = null;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvh zzvh = (zzvh) zzgw.zza(parcel, zzvh.CREATOR);
                zzve zzve = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface instanceof zzamx) {
                        zzamx = (zzamx) queryLocalInterface;
                    } else {
                        zzamx = new zzamz(readStrongBinder);
                    }
                }
                zza(asInterface, zzvh, zzve, readString, zzamx);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper zztj = zztj();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztj);
                return true;
            case 3:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzve zzve2 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface2 instanceof zzamx) {
                        zzamx = (zzamx) queryLocalInterface2;
                    } else {
                        zzamx = new zzamz(readStrongBinder2);
                    }
                }
                zza(asInterface2, zzve2, readString2, zzamx);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzvh zzvh2 = (zzvh) zzgw.zza(parcel, zzvh.CREATOR);
                zzve zzve3 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface3 instanceof zzamx) {
                        zzamx = (zzamx) queryLocalInterface3;
                    } else {
                        zzamx = new zzamz(readStrongBinder3);
                    }
                }
                zza(asInterface3, zzvh2, zzve3, readString3, readString4, zzamx);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzve zzve4 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface4 instanceof zzamx) {
                        zzamx = (zzamx) queryLocalInterface4;
                    } else {
                        zzamx = new zzamz(readStrongBinder4);
                    }
                }
                zza(asInterface4, zzve4, readString5, readString6, zzamx);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzve) zzgw.zza(parcel, zzve.CREATOR), parcel.readString(), zzaua.zzan(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza((zzve) zzgw.zza(parcel, zzve.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isInitialized);
                return true;
            case 14:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzve zzve5 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface5 instanceof zzamx) {
                        zzamx = (zzamx) queryLocalInterface5;
                    } else {
                        zzamx = new zzamz(readStrongBinder5);
                    }
                }
                zza(asInterface5, zzve5, readString7, readString8, zzamx, (zzadj) zzgw.zza(parcel, zzadj.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzana zztk = zztk();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztk);
                return true;
            case 16:
                zzanf zztl = zztl();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztl);
                return true;
            case 17:
                Bundle zztm = zztm();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zztm);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle zztn = zztn();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zztn);
                return true;
            case 20:
                zza((zzve) zzgw.zza(parcel, zzve.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzs(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zzto = zzto();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zzto);
                return true;
            case 23:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaua.zzan(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzaep zztp = zztp();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztp);
                return true;
            case 25:
                setImmersiveMode(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzyi videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 27:
                zzang zztq = zztq();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zztq);
                return true;
            case 28:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzve zzve6 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface6 instanceof zzamx) {
                        zzamx = (zzamx) queryLocalInterface6;
                    } else {
                        zzamx = new zzamz(readStrongBinder6);
                    }
                }
                zzb(asInterface6, zzve6, readString9, zzamx);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                zzt(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaih.zzz(parcel.readStrongBinder()), parcel.createTypedArrayList(zzaim.CREATOR));
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzve zzve7 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                String readString10 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface7 instanceof zzamx) {
                        zzamx = (zzamx) queryLocalInterface7;
                    } else {
                        zzamx = new zzamz(readStrongBinder7);
                    }
                }
                zzc(asInterface7, zzve7, readString10, zzamx);
                parcel2.writeNoException();
                return true;
            case 33:
                zzapl zztr = zztr();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zztr);
                return true;
            case 34:
                zzapl zzts = zzts();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zzts);
                return true;
        }
    }
}
