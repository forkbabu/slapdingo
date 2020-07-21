package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzagy implements zzahc<zzbfn> {
    zzagy() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbfn zzbfn, Map map) {
        zzbfn zzbfn2 = zzbfn;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbfn2.zzkd();
        } else if ("resume".equals(str)) {
            zzbfn2.zzke();
        }
    }
}
