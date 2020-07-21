package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdke extends zzatm {
    private final zzdkv zzfri;
    private boolean zzgpw = false;
    private final zzdjq zzgyz;
    private final zzdiu zzgza;
    /* access modifiers changed from: private */
    public zzchj zzgzb;

    public zzdke(zzdjq zzdjq, zzdiu zzdiu, zzdkv zzdkv) {
        this.zzgyz = zzdjq;
        this.zzgza = zzdiu;
        this.zzfri = zzdkv;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void setAppPackageName(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void zza(zzatw zzatw) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (!zzaax.zzcs(zzatw.zzbum)) {
            if (zzapx()) {
                if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcua)).booleanValue()) {
                    return;
                }
            }
            zzdjn zzdjn = new zzdjn(null);
            this.zzgzb = null;
            this.zzgyz.zzdy(zzdks.zzhal);
            this.zzgyz.zza(zzatw.zzdpj, zzatw.zzbum, zzdjn, new zzdkd(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void destroy() throws RemoteException {
        zzl(null);
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzgza.zza(null);
        if (this.zzgzb != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgzb.zzaig().zzcc(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void pause() {
        zzj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgzb != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgzb.zzaig().zzca(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void resume() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgzb != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgzb.zzaig().zzcb(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void show() throws RemoteException {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzgzb != null) {
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                    this.zzgzb.zzb(this.zzgpw, activity);
                }
            }
            activity = null;
            this.zzgzb.zzb(this.zzgpw, activity);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final boolean zzqw() {
        zzchj zzchj = this.zzgzb;
        return zzchj != null && zzchj.zzqw();
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgzb == null || this.zzgzb.zzaih() == null) {
            return null;
        }
        return this.zzgzb.zzaih().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzapx();
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zza(zzatq zzatq) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzgza.zzb(zzatq);
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zza(zzath zzath) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzgza.zzb(zzath);
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final void zza(zzwz zzwz) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzwz == null) {
            this.zzgza.zza(null);
        } else {
            this.zzgza.zza(new zzdkg(this, zzwz));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzchj zzchj = this.zzgzb;
        return zzchj != null ? zzchj.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzfri.zzdur = str;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcob)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzfri.zzdus = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgpw = z;
    }

    @Override // com.google.android.gms.internal.ads.zzatj
    public final synchronized zzyd zzkj() throws RemoteException {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcwq)).booleanValue()) {
            return null;
        }
        if (this.zzgzb == null) {
            return null;
        }
        return this.zzgzb.zzaih();
    }

    private final synchronized boolean zzapx() {
        return this.zzgzb != null && !this.zzgzb.isClosed();
    }
}
