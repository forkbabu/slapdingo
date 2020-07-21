package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzuz extends RemoteCreator<zzwu> {
    public zzuz() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzwp zza(Context context, String str, zzamr zzamr) {
        try {
            IBinder zzc = ((zzwu) getRemoteCreatorInstance(context)).zzc(ObjectWrapper.wrap(context), str, zzamr, 201604000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzwp) {
                return (zzwp) queryLocalInterface;
            }
            return new zzwr(zzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbba.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzwu getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzwu) {
            return (zzwu) queryLocalInterface;
        }
        return new zzwt(iBinder);
    }
}
