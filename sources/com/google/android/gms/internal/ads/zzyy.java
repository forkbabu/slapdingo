package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzyy implements InitializationStatus {
    private final zzyt zzcjx;

    zzyy(zzyt zzyt) {
        this.zzcjx = zzyt;
    }

    @Override // com.google.android.gms.ads.initialization.InitializationStatus
    public final Map getAdapterStatusMap() {
        zzyt zzyt = this.zzcjx;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzyx(zzyt));
        return hashMap;
    }
}
