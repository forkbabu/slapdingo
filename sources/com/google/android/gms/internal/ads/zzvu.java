package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzvu extends zzwd<zzaqi> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzvp zzcic;

    zzvu(zzvp zzvp, Activity activity) {
        this.zzcic = zzvp;
        this.val$activity = activity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzaqi zzpm() {
        zzvp.zza(this.val$activity, "ad_overlay");
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzaqi zzpn() throws RemoteException {
        return this.zzcic.zzchx.zzc(this.val$activity);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzaqi zza(zzxf zzxf) throws RemoteException {
        return zzxf.zzb(ObjectWrapper.wrap(this.val$activity));
    }
}
