package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzwa extends zzwd<zzwp> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcia;
    private final /* synthetic */ zzamr zzcib;
    private final /* synthetic */ zzvp zzcic;

    zzwa(zzvp zzvp, Context context, String str, zzamr zzamr) {
        this.zzcic = zzvp;
        this.val$context = context;
        this.zzcia = str;
        this.zzcib = zzamr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzwp zzpm() {
        zzvp.zza(this.val$context, "native_ad");
        return new zzze();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzwp zzpn() throws RemoteException {
        return this.zzcic.zzchs.zza(this.val$context, this.zzcia, this.zzcib);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzwp zza(zzxf zzxf) throws RemoteException {
        return zzxf.zza(ObjectWrapper.wrap(this.val$context), this.zzcia, this.zzcib, 201604000);
    }
}
