package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaqg extends RemoteCreator<zzaqj> {
    public zzaqg() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzaqi zzc(Activity activity) {
        try {
            IBinder zzae = ((zzaqj) getRemoteCreatorInstance(activity)).zzae(ObjectWrapper.wrap(activity));
            if (zzae == null) {
                return null;
            }
            IInterface queryLocalInterface = zzae.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzaqi) {
                return (zzaqi) queryLocalInterface;
            }
            return new zzaqk(zzae);
        } catch (RemoteException e) {
            zzbba.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            zzbba.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzaqj getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzaqj) {
            return (zzaqj) queryLocalInterface;
        }
        return new zzaqm(iBinder);
    }
}
