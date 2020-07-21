package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzagv implements zzahc<zzbfn> {
    zzagv() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbfn zzbfn, Map map) {
        zzbfn zzbfn2 = zzbfn;
        if (zzbfn2.zzabn() != null) {
            zzbfn2.zzabn().zzms();
        }
        zzc zzaav = zzbfn2.zzaav();
        if (zzaav != null) {
            zzaav.close();
            return;
        }
        zzc zzaaw = zzbfn2.zzaaw();
        if (zzaaw != null) {
            zzaaw.close();
        } else {
            zzaxv.zzfd("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
