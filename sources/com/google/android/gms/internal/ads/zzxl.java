package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzxl extends zzgt implements zzxm {
    public zzxl() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                initialize();
                parcel2.writeNoException();
                return true;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                zzcg(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                setAppMuted(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zza(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float zzqc = zzqc();
                parcel2.writeNoException();
                parcel2.writeFloat(zzqc);
                return true;
            case 8:
                boolean zzqd = zzqd();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zzqd);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzch(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza(zzamq.zzac(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zza(zzaii.zzaa(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzaic> zzqe = zzqe();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzqe);
                return true;
            case 14:
                zza((zzzu) zzgw.zza(parcel, zzzu.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzqf();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
