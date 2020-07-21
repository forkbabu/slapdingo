package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzvc extends RemoteCreator<zzwx> {
    public zzvc() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzww zza(Context context, zzvh zzvh, String str, zzamr zzamr, int i) {
        try {
            IBinder zza = ((zzwx) getRemoteCreatorInstance(context)).zza(ObjectWrapper.wrap(context), zzvh, str, zzamr, 201604000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzww) {
                return (zzww) queryLocalInterface;
            }
            return new zzwy(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbba.zzb("Could not create remote AdManager.", e);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzwx getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzwx) {
            return (zzwx) queryLocalInterface;
        }
        return new zzxa(iBinder);
    }
}
