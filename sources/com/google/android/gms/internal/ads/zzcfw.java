package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcfw implements zzqs {
    private final zzbfn zzeot;

    zzcfw(zzbfn zzbfn) {
        this.zzeot = zzbfn;
    }

    @Override // com.google.android.gms.internal.ads.zzqs
    public final void zza(zzqt zzqt) {
        zzbfn zzbfn = this.zzeot;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzqt.zzbrd ? "1" : "0");
        zzbfn.zza("onAdVisibilityChanged", hashMap);
    }
}
