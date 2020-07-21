package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzben extends zzaxr {
    final zzbdb zzeez;
    private final String zzefl;
    private final String[] zzefm;
    final zzbes zzekc;

    zzben(zzbdb zzbdb, zzbes zzbes, String str, String[] strArr) {
        this.zzeez = zzbdb;
        this.zzekc = zzbes;
        this.zzefl = str;
        this.zzefm = strArr;
        zzq.zzls().zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzut() {
        try {
            this.zzekc.zze(this.zzefl, this.zzefm);
        } finally {
            zzaye.zzdzw.post(new zzbeq(this));
        }
    }
}
