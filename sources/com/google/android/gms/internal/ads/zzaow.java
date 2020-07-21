package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzaow extends zzgt implements zzaox {
    public zzaow() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzaox zzaf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzaox) {
            return (zzaox) queryLocalInterface;
        }
        return new zzaoz(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaoy zzaoy;
        zzaoy zzaoy2;
        zzaol zzaol = null;
        zzaos zzaou = null;
        zzaor zzaot = null;
        zzaos zzaou2 = null;
        zzaom zzaoo = null;
        if (i == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String readString = parcel.readString();
            Bundle bundle = (Bundle) zzgw.zza(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzgw.zza(parcel, Bundle.CREATOR);
            zzvh zzvh = (zzvh) zzgw.zza(parcel, zzvh.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaoy = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                if (queryLocalInterface instanceof zzaoy) {
                    zzaoy2 = (zzaoy) queryLocalInterface;
                } else {
                    zzaoy2 = new zzapa(readStrongBinder);
                }
                zzaoy = zzaoy2;
            }
            zza(asInterface, readString, bundle, bundle2, zzvh, zzaoy);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzapl zztr = zztr();
            parcel2.writeNoException();
            zzgw.zzb(parcel2, zztr);
        } else if (i == 3) {
            zzapl zzts = zzts();
            parcel2.writeNoException();
            zzgw.zzb(parcel2, zzts);
        } else if (i == 5) {
            zzyi videoController = getVideoController();
            parcel2.writeNoException();
            zzgw.zza(parcel2, videoController);
        } else if (i == 10) {
            zzy(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    zzve zzve = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                    IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        if (queryLocalInterface2 instanceof zzaol) {
                            zzaol = (zzaol) queryLocalInterface2;
                        } else {
                            zzaol = new zzaon(readStrongBinder2);
                        }
                    }
                    zza(readString2, readString3, zzve, asInterface2, zzaol, zzamw.zzad(parcel.readStrongBinder()), (zzvh) zzgw.zza(parcel, zzvh.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 14:
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    zzve zzve2 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                    IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        if (queryLocalInterface3 instanceof zzaom) {
                            zzaoo = (zzaom) queryLocalInterface3;
                        } else {
                            zzaoo = new zzaoo(readStrongBinder3);
                        }
                    }
                    zza(readString4, readString5, zzve2, asInterface3, zzaoo, zzamw.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 15:
                    boolean zzz = zzz(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzgw.writeBoolean(parcel2, zzz);
                    break;
                case 16:
                    String readString6 = parcel.readString();
                    String readString7 = parcel.readString();
                    zzve zzve3 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                    IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        if (queryLocalInterface4 instanceof zzaos) {
                            zzaou2 = (zzaos) queryLocalInterface4;
                        } else {
                            zzaou2 = new zzaou(readStrongBinder4);
                        }
                    }
                    zza(readString6, readString7, zzve3, asInterface4, zzaou2, zzamw.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 17:
                    boolean zzaa = zzaa(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzgw.writeBoolean(parcel2, zzaa);
                    break;
                case 18:
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    zzve zzve4 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                    IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder5 = parcel.readStrongBinder();
                    if (readStrongBinder5 != null) {
                        IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        if (queryLocalInterface5 instanceof zzaor) {
                            zzaot = (zzaor) queryLocalInterface5;
                        } else {
                            zzaot = new zzaot(readStrongBinder5);
                        }
                    }
                    zza(readString8, readString9, zzve4, asInterface5, zzaot, zzamw.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 19:
                    zzdq(parcel.readString());
                    parcel2.writeNoException();
                    break;
                case 20:
                    String readString10 = parcel.readString();
                    String readString11 = parcel.readString();
                    zzve zzve5 = (zzve) zzgw.zza(parcel, zzve.CREATOR);
                    IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder readStrongBinder6 = parcel.readStrongBinder();
                    if (readStrongBinder6 != null) {
                        IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        if (queryLocalInterface6 instanceof zzaos) {
                            zzaou = (zzaos) queryLocalInterface6;
                        } else {
                            zzaou = new zzaou(readStrongBinder6);
                        }
                    }
                    zzb(readString10, readString11, zzve5, asInterface6, zzaou, zzamw.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
        } else {
            zza(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
            parcel2.writeNoException();
        }
        return true;
    }
}
