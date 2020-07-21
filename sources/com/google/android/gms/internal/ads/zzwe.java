package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzwe extends zzwd<zzatj> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzamr zzcib;
    private final /* synthetic */ zzvp zzcic;

    zzwe(zzvp zzvp, Context context, zzamr zzamr) {
        this.zzcic = zzvp;
        this.val$context = context;
        this.zzcib = zzamr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzatj zzpm() {
        zzvp.zza(this.val$context, "rewarded_video");
        return new zzzq();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzatj zzpn() throws RemoteException {
        return this.zzcic.zzchv.zzb(this.val$context, this.zzcib);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzatj zza(zzxf zzxf) throws RemoteException {
        return zzxf.zza(ObjectWrapper.wrap(this.val$context), this.zzcib, 201604000);
    }
}
