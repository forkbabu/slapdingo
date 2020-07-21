package com.google.android.gms.internal.ads;

import android.location.Location;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdbg implements zzdrx {
    private final zzdbe zzgsx;

    zzdbg(zzdbe zzdbe) {
        this.zzgsx = zzdbe;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        zzdbe zzdbe = this.zzgsx;
        Location location = (Location) obj;
        if (location != null) {
            return location;
        }
        return zzdbe.zzfpv.zzhay.zznb;
    }
}
