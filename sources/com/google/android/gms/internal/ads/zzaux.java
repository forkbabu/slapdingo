package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzaux implements zzbbc {
    static final zzbbc zzbxr = new zzaux();

    private zzaux() {
    }

    @Override // com.google.android.gms.internal.ads.zzbbc
    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzauo) {
            return (zzauo) queryLocalInterface;
        }
        return new zzaun(iBinder);
    }
}
