package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzahb implements zzahc<zzbfn> {
    zzahb() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbfn zzbfn, Map map) {
        zzbfn zzbfn2 = zzbfn;
        if (map.keySet().contains("start")) {
            zzbfn2.zzaaz().zzabz();
        } else if (map.keySet().contains("stop")) {
            zzbfn2.zzaaz().zzaca();
        } else if (map.keySet().contains("cancel")) {
            zzbfn2.zzaaz().zzacb();
        }
    }
}
