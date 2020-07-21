package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbft implements zzduu<Map<String, String>> {
    private final /* synthetic */ zzbfq zzemb;
    private final /* synthetic */ List zzemc;
    private final /* synthetic */ String zzemd;

    zzbft(zzbfq zzbfq, List list, String str) {
        this.zzemb = zzbfq;
        this.zzemc = list;
        this.zzemd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(Map<String, String> map) {
        this.zzemb.zza(map, this.zzemc, this.zzemd);
    }
}
