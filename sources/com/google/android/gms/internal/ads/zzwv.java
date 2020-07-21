package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzwv extends zzgt implements zzww {
    public zzwv() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzww zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzww) {
            return (zzww) queryLocalInterface;
        }
        return new zzwy(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzwj zzwj = null;
        zzyc zzyc = null;
        zzwz zzwz = null;
        zzxk zzxk = null;
        zzwi zzwi = null;
        zzxe zzxe = null;
        switch (i) {
            case 1:
                IObjectWrapper zzkf = zzkf();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzkf);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isReady = isReady();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isReady);
                return true;
            case 4:
                boolean zza = zza((zzve) zzgw.zza(parcel, zzve.CREATOR));
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zza);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzwj) {
                        zzwj = (zzwj) queryLocalInterface;
                    } else {
                        zzwj = new zzwl(readStrongBinder);
                    }
                }
                zza(zzwj);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (queryLocalInterface2 instanceof zzxe) {
                        zzxe = (zzxe) queryLocalInterface2;
                    } else {
                        zzxe = new zzxg(readStrongBinder2);
                    }
                }
                zza(zzxe);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                return true;
            case 11:
                zzkg();
                parcel2.writeNoException();
                return true;
            case 12:
                zzvh zzkh = zzkh();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, zzkh);
                return true;
            case 13:
                zza((zzvh) zzgw.zza(parcel, zzvh.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzaqr.zzah(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza(zzaqx.zzaj(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                zza(zzabr.zzl(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (queryLocalInterface3 instanceof zzwi) {
                        zzwi = (zzwi) queryLocalInterface3;
                    } else {
                        zzwi = new zzwk(readStrongBinder3);
                    }
                }
                zza(zzwi);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface4 instanceof zzxk) {
                        zzxk = (zzxk) queryLocalInterface4;
                    } else {
                        zzxk = new zzxj(readStrongBinder4);
                    }
                }
                zza(zzxk);
                parcel2.writeNoException();
                return true;
            case 22:
                setManualImpressionsEnabled(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isLoading);
                return true;
            case 24:
                zza(zzatp.zzam(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzyi videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 29:
                zza((zzaaa) zzgw.zza(parcel, zzaaa.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                zza((zzyo) zzgw.zza(parcel, zzyo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String adUnitId = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(adUnitId);
                return true;
            case 32:
                zzxe zzkk = zzkk();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzkk);
                return true;
            case 33:
                zzwj zzkl = zzkl();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzkl);
                return true;
            case 34:
                setImmersiveMode(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String zzki = zzki();
                parcel2.writeNoException();
                parcel2.writeString(zzki);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (queryLocalInterface5 instanceof zzwz) {
                        zzwz = (zzwz) queryLocalInterface5;
                    } else {
                        zzwz = new zzxb(readStrongBinder5);
                    }
                }
                zza(zzwz);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgw.zzb(parcel2, adMetadata);
                return true;
            case 38:
                zzbo(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 39:
                zza((zzvo) zzgw.zza(parcel, zzvo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 40:
                zza(zzsj.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 41:
                zzyd zzkj = zzkj();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzkj);
                return true;
            case 42:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    if (queryLocalInterface6 instanceof zzyc) {
                        zzyc = (zzyc) queryLocalInterface6;
                    } else {
                        zzyc = new zzye(readStrongBinder6);
                    }
                }
                zza(zzyc);
                parcel2.writeNoException();
                return true;
        }
    }
}
