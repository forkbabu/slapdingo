package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcuy extends zzaua {
    private final /* synthetic */ zzbui zzgnd;
    private final /* synthetic */ zzbsk zzgne;
    private final /* synthetic */ zzbtl zzgnf;
    private final /* synthetic */ zzbyq zzgng;

    zzcuy(zzcuu zzcuu, zzbui zzbui, zzbsk zzbsk, zzbtl zzbtl, zzbyq zzbyq) {
        this.zzgnd = zzbui;
        this.zzgne = zzbsk;
        this.zzgnf = zzbtl;
        this.zzgng = zzbyq;
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.zzgnd.zzue();
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzgnd.zzud();
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzgne.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzgnf.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zza(IObjectWrapper iObjectWrapper, zzaub zzaub) {
        this.zzgng.zza(zzaub);
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzgng.zzsq();
    }

    @Override // com.google.android.gms.internal.ads.zzatx
    public final void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzgnf.onRewardedVideoCompleted();
    }
}
