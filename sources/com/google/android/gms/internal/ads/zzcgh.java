package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcgh extends zzaeg {
    private final String zzfpp;
    private final zzcck zzfuu;
    private final zzccd zzfya;

    public zzcgh(String str, zzccd zzccd, zzcck zzcck) {
        this.zzfpp = str;
        this.zzfya = zzccd;
        this.zzfuu = zzcck;
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final IObjectWrapper zzsb() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfya);
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final String getHeadline() throws RemoteException {
        return this.zzfuu.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final List<?> getImages() throws RemoteException {
        return this.zzfuu.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final String getBody() throws RemoteException {
        return this.zzfuu.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final zzadt zzsc() throws RemoteException {
        return this.zzfuu.zzsc();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final String getCallToAction() throws RemoteException {
        return this.zzfuu.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final double getStarRating() throws RemoteException {
        return this.zzfuu.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final String getStore() throws RemoteException {
        return this.zzfuu.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final String getPrice() throws RemoteException {
        return this.zzfuu.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final Bundle getExtras() throws RemoteException {
        return this.zzfuu.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final void destroy() throws RemoteException {
        this.zzfya.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final zzyi getVideoController() throws RemoteException {
        return this.zzfuu.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzfya.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzfya.zzi(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzfya.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final zzadl zzsd() throws RemoteException {
        return this.zzfuu.zzsd();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final IObjectWrapper zzse() throws RemoteException {
        return this.zzfuu.zzse();
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzfpp;
    }
}
