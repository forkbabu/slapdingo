package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzvt extends zzwd<zzawr> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzamr zzcib;

    zzvt(zzvp zzvp, Context context, zzamr zzamr) {
        this.val$context = context;
        this.zzcib = zzamr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* bridge */ /* synthetic */ zzawr zzpm() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzpo */
    public final zzawr zzpn() {
        try {
            return ((zzaww) zzbaz.zza(this.val$context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzvw.zzbxr)).zzd(ObjectWrapper.wrap(this.val$context), this.zzcib, 201604000);
        } catch (RemoteException | zzbbb | NullPointerException unused) {
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwd
    public final /* synthetic */ zzawr zza(zzxf zzxf) throws RemoteException {
        return zzxf.zzb(ObjectWrapper.wrap(this.val$context), this.zzcib, 201604000);
    }
}
