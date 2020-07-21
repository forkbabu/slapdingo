package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbyo implements zzbyp {
    private final List<String> zzdrh;
    private final zzdpd zzfkp;
    private boolean zzftl;

    public zzbyo(zzdkk zzdkk, zzdpd zzdpd) {
        this.zzdrh = zzdkk.zzdrh;
        this.zzfkp = zzdpd;
    }

    @Override // com.google.android.gms.internal.ads.zzbyp
    public final void zzakb() {
        if (!this.zzftl) {
            this.zzfkp.zzi(this.zzdrh);
            this.zzftl = true;
        }
    }
}
