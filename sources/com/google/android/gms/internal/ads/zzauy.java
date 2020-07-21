package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzauy {
    public static zzaui zzd(Context context, String str, zzamr zzamr) {
        try {
            IBinder zzd = ((zzauo) zzbaz.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzaux.zzbxr)).zzd(ObjectWrapper.wrap(context), str, zzamr, 201604000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzaui) {
                return (zzaui) queryLocalInterface;
            }
            return new zzauk(zzd);
        } catch (RemoteException | zzbbb e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
