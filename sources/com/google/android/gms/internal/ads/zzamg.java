package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzamg extends zzbhx {
    private final AppMeasurementSdk zzdhy;

    zzamg(AppMeasurementSdk appMeasurementSdk) {
        this.zzdhy = appMeasurementSdk;
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final void performAction(Bundle bundle) throws RemoteException {
        this.zzdhy.performAction(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.zzdhy.performActionWithResponse(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdhy.logEvent(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzdhy.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.zzdhy.getUserProperties(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.zzdhy.getMaxUserProperties(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.zzdhy.setConditionalUserProperty(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdhy.clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.zzdhy.getConditionalUserProperties(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final String getAppInstanceId() throws RemoteException {
        return this.zzdhy.getAppInstanceId();
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final String getGmpAppId() throws RemoteException {
        return this.zzdhy.getGmpAppId();
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final long generateEventId() throws RemoteException {
        return this.zzdhy.generateEventId();
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.zzdhy.beginAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final void endAdUnitExposure(String str) throws RemoteException {
        this.zzdhy.endAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.zzdhy.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final String getCurrentScreenName() throws RemoteException {
        return this.zzdhy.getCurrentScreenName();
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final String getCurrentScreenClass() throws RemoteException {
        return this.zzdhy.getCurrentScreenClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbhy
    public final String getAppIdOrigin() throws RemoteException {
        return this.zzdhy.getAppIdOrigin();
    }
}
