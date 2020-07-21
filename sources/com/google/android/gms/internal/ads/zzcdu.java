package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcdu implements zzbhc {
    private final Map zzedc;
    private final zzcdo zzfzb;

    zzcdu(zzcdo zzcdo, Map map) {
        this.zzfzb = zzcdo;
        this.zzedc = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zzak(boolean z) {
        this.zzfzb.zza(this.zzedc, z);
    }
}
