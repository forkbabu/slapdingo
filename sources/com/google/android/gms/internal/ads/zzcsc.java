package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsc extends zzaua implements zzbtt {
    private zzatx zzglg;
    private zzbtw zzglh;
    private zzbyx zzgli;

    public final synchronized void zza(zzatx zzatx) {
        this.zzglg = zzatx;
    }

    @Override // com.google.android.gms.internal.ads.zzbtt
    public final synchronized void zza(zzbtw zzbtw) {
        this.zzglh = zzbtw;
    }

    public final synchronized void zza(zzbyx zzbyx) {
        this.zzgli = zzbyx;
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzaf(iObjectWrapper);
        }
        if (this.zzgli != null) {
            this.zzgli.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzd(iObjectWrapper, i);
        }
        if (this.zzgli != null) {
            this.zzgli.zzdv(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzai(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzaub zzaub) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zza(iObjectWrapper, zzaub);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzak(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzaj(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zze(iObjectWrapper, i);
        }
        if (this.zzglh != null) {
            this.zzglh.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzal(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzam(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzah(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzah(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzag(iObjectWrapper);
        }
        if (this.zzglh != null) {
            this.zzglh.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzglg != null) {
            this.zzglg.zzb(bundle);
        }
    }
}
