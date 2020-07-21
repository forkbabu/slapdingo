package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcgm extends zzafs {
    private final String zzfpp;
    private final zzcck zzfuu;
    private final zzccd zzfya;

    public zzcgm(String str, zzccd zzccd, zzcck zzcck) {
        this.zzfpp = str;
        this.zzfya = zzccd;
        this.zzfuu = zzcck;
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final IObjectWrapper zzsb() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfya);
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final String getHeadline() throws RemoteException {
        return this.zzfuu.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final List<?> getImages() throws RemoteException {
        return this.zzfuu.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final List<?> getMuteThisAdReasons() throws RemoteException {
        if (isCustomMuteThisAdEnabled()) {
            return this.zzfuu.getMuteThisAdReasons();
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        return !this.zzfuu.getMuteThisAdReasons().isEmpty() && this.zzfuu.zzalj() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final String getBody() throws RemoteException {
        return this.zzfuu.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final zzadt zzsc() throws RemoteException {
        return this.zzfuu.zzsc();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final String getCallToAction() throws RemoteException {
        return this.zzfuu.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final String getAdvertiser() throws RemoteException {
        return this.zzfuu.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final double getStarRating() throws RemoteException {
        return this.zzfuu.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final String getStore() throws RemoteException {
        return this.zzfuu.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final String getPrice() throws RemoteException {
        return this.zzfuu.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void destroy() throws RemoteException {
        this.zzfya.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final zzyi getVideoController() throws RemoteException {
        return this.zzfuu.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzfya.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzfya.zzi(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzfya.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final zzadl zzsd() throws RemoteException {
        return this.zzfuu.zzsd();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final IObjectWrapper zzse() throws RemoteException {
        return this.zzfuu.zzse();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzfpp;
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final Bundle getExtras() throws RemoteException {
        return this.zzfuu.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void zza(zzafo zzafo) throws RemoteException {
        this.zzfya.zza(zzafo);
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void zza(zzxt zzxt) throws RemoteException {
        this.zzfya.zza(zzxt);
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void zza(zzxp zzxp) throws RemoteException {
        this.zzfya.zza(zzxp);
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void zzsm() {
        this.zzfya.zzsm();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void recordCustomClickGesture() {
        this.zzfya.recordCustomClickGesture();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final boolean isCustomClickGestureEnabled() {
        return this.zzfya.isCustomClickGestureEnabled();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void cancelUnconfirmedClick() throws RemoteException {
        this.zzfya.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final zzado zzsn() throws RemoteException {
        return this.zzfya.zzald().zzsn();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final zzyd zzkj() throws RemoteException {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcwq)).booleanValue()) {
            return null;
        }
        return this.zzfya.zzaih();
    }

    @Override // com.google.android.gms.internal.ads.zzaft
    public final void zza(zzyc zzyc) throws RemoteException {
        this.zzfya.zza(zzyc);
    }
}
