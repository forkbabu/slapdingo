package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcrq extends zzaok {
    private zzcqv<zzaox, zzcsd> zzgkv;
    private final /* synthetic */ zzcrp zzgkw;

    private zzcrq(zzcrp zzcrp, zzcqv<zzaox, zzcsd> zzcqv) {
        this.zzgkw = zzcrp;
        this.zzgkv = zzcqv;
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        View unused = this.zzgkw.view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzgkv.zzgki.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzdp(String str) throws RemoteException {
        this.zzgkv.zzgki.zzc(0, str);
    }
}
