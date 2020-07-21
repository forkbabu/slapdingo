package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzvz extends zzwd<zzxm> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvp zzcic;

    zzvz(zzvp zzvp, Context context) {
        this.zzcic = zzvp;
        this.val$context = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzxm zzpm() {
        zzvp.zza(this.val$context, "mobile_ads_settings");
        return new zzzk();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzxm zzpn() throws RemoteException {
        return this.zzcic.zzcht.zzi(this.val$context);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzxm zza(zzxf zzxf) throws RemoteException {
        return zzxf.zza(ObjectWrapper.wrap(this.val$context), 201604000);
    }
}
