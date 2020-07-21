package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzyh extends zzgt implements zzyi {
    public zzyh() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzyi zzk(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (queryLocalInterface instanceof zzyi) {
            return (zzyi) queryLocalInterface;
        }
        return new zzyk(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgt
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzyj zzyj;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                return true;
            case 2:
                pause();
                parcel2.writeNoException();
                return true;
            case 3:
                mute(zzgw.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean isMuted = isMuted();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isMuted);
                return true;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                return true;
            case 6:
                float duration = getDuration();
                parcel2.writeNoException();
                parcel2.writeFloat(duration);
                return true;
            case 7:
                float currentTime = getCurrentTime();
                parcel2.writeNoException();
                parcel2.writeFloat(currentTime);
                return true;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzyj = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (queryLocalInterface instanceof zzyj) {
                        zzyj = (zzyj) queryLocalInterface;
                    } else {
                        zzyj = new zzyl(readStrongBinder);
                    }
                }
                zza(zzyj);
                parcel2.writeNoException();
                return true;
            case 9:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                return true;
            case 10:
                boolean isCustomControlsEnabled = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isCustomControlsEnabled);
                return true;
            case 11:
                zzyj zzqi = zzqi();
                parcel2.writeNoException();
                zzgw.zza(parcel2, zzqi);
                return true;
            case 12:
                boolean isClickToExpandEnabled = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzgw.writeBoolean(parcel2, isClickToExpandEnabled);
                return true;
            case 13:
                stop();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
