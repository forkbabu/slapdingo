package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zztr {
    zzgy zzbxp;
    boolean zzbxq;

    public final zztv zzf(byte[] bArr) {
        return new zztv(this, bArr);
    }

    public zztr(Context context, String str, String str2) {
        zzaav.initialize(context);
        try {
            this.zzbxp = (zzgy) zzbaz.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zztu.zzbxr);
            ObjectWrapper.wrap(context);
            this.zzbxp.zza(ObjectWrapper.wrap(context), str, null);
            this.zzbxq = true;
        } catch (RemoteException | zzbbb | NullPointerException unused) {
            zzbba.zzee("Cannot dynamite load clearcut");
        }
    }

    public zztr(Context context) {
        zzaav.initialize(context);
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcte)).booleanValue()) {
            try {
                this.zzbxp = (zzgy) zzbaz.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zztt.zzbxr);
                ObjectWrapper.wrap(context);
                this.zzbxp.zza(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzbxq = true;
            } catch (RemoteException | zzbbb | NullPointerException unused) {
                zzbba.zzee("Cannot dynamite load clearcut");
            }
        }
    }

    public zztr() {
    }
}
