package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcxj {
    /* access modifiers changed from: private */
    public zzyd zzadl;
    /* access modifiers changed from: private */
    public boolean zzaeu = false;
    private final String zzbum;
    private final zzcxn<zzbpb> zzgpz;

    public zzcxj(zzcxn<zzbpb> zzcxn, String str) {
        this.zzgpz = zzcxn;
        this.zzbum = str;
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgpz.isLoading();
    }

    public final synchronized void zza(zzve zzve, int i) throws RemoteException {
        this.zzadl = null;
        this.zzaeu = this.zzgpz.zza(zzve, this.zzbum, new zzcxo(i), new zzcxi(this));
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            if (this.zzadl == null) {
                return null;
            }
            return this.zzadl.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaxv.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final synchronized String zzki() {
        try {
            if (this.zzadl == null) {
                return null;
            }
            return this.zzadl.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaxv.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
