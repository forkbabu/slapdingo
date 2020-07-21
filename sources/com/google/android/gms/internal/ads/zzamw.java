package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzamw extends zzgt implements zzamx {
    public zzamw() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzamx zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if (queryLocalInterface instanceof zzamx) {
            return (zzamx) queryLocalInterface;
        }
        return new zzamz(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzamy zzamy;
        switch (i) {
            case 1:
                onAdClicked();
                break;
            case 2:
                onAdClosed();
                break;
            case 3:
                onAdFailedToLoad(parcel.readInt());
                break;
            case 4:
                onAdLeftApplication();
                break;
            case 5:
                onAdOpened();
                break;
            case 6:
                onAdLoaded();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzamy = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzamy) {
                        zzamy = (zzamy) queryLocalInterface;
                    } else {
                        zzamy = new zzanb(readStrongBinder);
                    }
                }
                zza(zzamy);
                break;
            case 8:
                onAdImpression();
                break;
            case 9:
                onAppEvent(parcel.readString(), parcel.readString());
                break;
            case 10:
                zza(zzaeo.zzr(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                onVideoEnd();
                break;
            case 12:
                zzdm(parcel.readString());
                break;
            case 13:
                zztt();
                break;
            case 14:
                zzb((zzaub) zzgw.zza(parcel, zzaub.CREATOR));
                break;
            case 15:
                onVideoPause();
                break;
            case 16:
                zza(zzaug.zzao(parcel.readStrongBinder()));
                break;
            case 17:
                zzdc(parcel.readInt());
                break;
            case 18:
                zztu();
                break;
            case 19:
                zzb((Bundle) zzgw.zza(parcel, Bundle.CREATOR));
                break;
            case 20:
                onVideoPlay();
                break;
            case 21:
                zzdn(parcel.readString());
                break;
            case 22:
                zzc(parcel.readInt(), parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
