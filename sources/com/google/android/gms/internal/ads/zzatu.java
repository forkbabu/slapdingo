package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzatu extends RemoteCreator<zzato> {
    public zzatu() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public final zzatj zzb(Context context, zzamr zzamr) {
        try {
            IBinder zzc = ((zzato) getRemoteCreatorInstance(context)).zzc(ObjectWrapper.wrap(context), zzamr, 201604000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzatj) {
                return (zzatj) queryLocalInterface;
            }
            return new zzatl(zzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbba.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzato getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzato) {
            return (zzato) queryLocalInterface;
        }
        return new zzatn(iBinder);
    }
}
