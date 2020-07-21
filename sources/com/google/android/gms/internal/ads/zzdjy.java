package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdjy extends zzauh {
    private final String zzbum;
    private final zzdkv zzfri;
    private final Context zzgov;
    private final zzdjq zzgyz;
    private final zzdiu zzgza;
    /* access modifiers changed from: private */
    public zzchj zzgzb;

    public zzdjy(String str, zzdjq zzdjq, Context context, zzdiu zzdiu, zzdkv zzdkv) {
        this.zzbum = str;
        this.zzgyz = zzdjq;
        this.zzgza = zzdiu;
        this.zzfri = zzdkv;
        this.zzgov = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void zza(zzve zzve, zzauq zzauq) throws RemoteException {
        zza(zzve, zzauq, zzdks.zzham);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void zzb(zzve zzve, zzauq zzauq) throws RemoteException {
        zza(zzve, zzauq, zzdks.zzhan);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zza(iObjectWrapper, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzgzb == null) {
            zzaxv.zzfd("Rewarded can not be shown before loaded");
            this.zzgza.zzd(new zzuy(2, "The ad is not ready.", "com.google.android.gms.ads"));
            return;
        }
        this.zzgzb.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgzb == null || this.zzgzb.zzaih() == null) {
            return null;
        }
        return this.zzgzb.zzaih().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchj zzchj = this.zzgzb;
        return zzchj != null && !zzchj.zzana();
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzauj zzauj) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgza.zzb(zzauj);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzaur zzaur) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgza.zzb(zzaur);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzxx zzxx) {
        if (zzxx == null) {
            this.zzgza.zza(null);
        } else {
            this.zzgza.zza(new zzdjx(this, zzxx));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchj zzchj = this.zzgzb;
        return zzchj != null ? zzchj.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final zzaud zzqv() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchj zzchj = this.zzgzb;
        if (zzchj != null) {
            return zzchj.zzqv();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void zza(zzauz zzauz) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdkv zzdkv = this.zzfri;
        zzdkv.zzdur = zzauz.zzdur;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcob)).booleanValue()) {
            zzdkv.zzdus = zzauz.zzdus;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final zzyd zzkj() {
        zzchj zzchj;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcwq)).booleanValue() && (zzchj = this.zzgzb) != null) {
            return zzchj.zzaih();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void zza(zzyc zzyc) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzgza.zzc(zzyc);
    }

    private final synchronized void zza(zzve zzve, zzauq zzauq, int i) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgza.zzb(zzauq);
        zzq.zzkw();
        if (zzaye.zzbf(this.zzgov) && zzve.zzchg == null) {
            zzaxv.zzfb("Failed to load the ad because app ID is missing.");
            this.zzgza.onAdFailedToLoad(8);
        } else if (this.zzgzb == null) {
            zzdjn zzdjn = new zzdjn(null);
            this.zzgyz.zzdy(i);
            this.zzgyz.zza(zzve, this.zzbum, zzdjn, new zzdka(this));
        }
    }
}
