package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzaeo extends zzgt implements zzaep {
    public zzaeo() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzaep zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (queryLocalInterface instanceof zzaep) {
            return (zzaep) queryLocalInterface;
        }
        return new zzaer(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String zzcw = zzcw(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzcw);
                return true;
            case 2:
                zzadt zzcx = zzcx(parcel.readString());
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzcx);
                return true;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                return true;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                return true;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 7:
                zzyi videoController = getVideoController();
                parcel2.writeNoException();
                zzgw.zza(parcel2, videoController);
                return true;
            case 8:
                destroy();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper zzsg = zzsg();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzsg);
                return true;
            case 10:
                boolean zzp = zzp(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zzp);
                return true;
            case 11:
                IObjectWrapper zzsb = zzsb();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzsb);
                return true;
            case 12:
                boolean zzsh = zzsh();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zzsh);
                return true;
            case 13:
                boolean zzsi = zzsi();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, zzsi);
                return true;
            case 14:
                zzq(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zzsj();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
