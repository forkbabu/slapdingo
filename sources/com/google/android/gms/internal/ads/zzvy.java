package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzvy extends zzwd<zzww> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcia;
    private final /* synthetic */ zzvp zzcic;
    private final /* synthetic */ zzvh zzcid;

    zzvy(zzvp zzvp, Context context, zzvh zzvh, String str) {
        this.zzcic = zzvp;
        this.val$context = context;
        this.zzcid = zzvh;
        this.zzcia = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzww zzpm() {
        zzvp.zza(this.val$context, FirebaseAnalytics.Event.SEARCH);
        return new zzzi();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzww zzpn() throws RemoteException {
        return this.zzcic.zzchr.zza(this.val$context, this.zzcid, this.zzcia, null, 3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzww zza(zzxf zzxf) throws RemoteException {
        return zzxf.zza(ObjectWrapper.wrap(this.val$context), this.zzcid, this.zzcia, 201604000);
    }
}
