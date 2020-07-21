package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdhi implements zzbsq, zzbuf, zzdim {
    private final zzdmi zzgwx;
    private final AtomicReference<zzsg> zzgwy = new AtomicReference<>();
    private final AtomicReference<zzsl> zzgwz = new AtomicReference<>();
    private final AtomicReference<zzbuf> zzgxa = new AtomicReference<>();
    private zzdhi zzgxb = null;

    public zzdhi(zzdmi zzdmi) {
        this.zzgwx = zzdmi;
    }

    public static zzdhi zzb(zzdhi zzdhi) {
        zzdhi zzdhi2 = new zzdhi(zzdhi.zzgwx);
        zzdhi2.zzb((zzdim) zzdhi);
        return zzdhi2;
    }

    public final void zzb(zzsg zzsg) {
        this.zzgwy.set(zzsg);
    }

    public final void zzb(zzsl zzsl) {
        this.zzgwz.set(zzsl);
    }

    public final void zza(zzbuf zzbuf) {
        this.zzgxa.set(zzbuf);
    }

    public final void zzb(zzsf zzsf) {
        zzdhi zzdhi = this;
        while (true) {
            zzdhi zzdhi2 = zzdhi.zzgxb;
            if (zzdhi2 != null) {
                zzdhi = zzdhi2;
            } else {
                zzdib.zza(zzdhi.zzgwy, new zzdhh(zzsf));
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsq
    public final void onAdFailedToLoad(int i) {
        zzdhi zzdhi = this;
        while (true) {
            zzdhi zzdhi2 = zzdhi.zzgxb;
            if (zzdhi2 != null) {
                zzdhi = zzdhi2;
            } else {
                zzdib.zza(zzdhi.zzgwy, new zzdhk(i));
                return;
            }
        }
    }

    public final void onAdClosed() {
        zzdhi zzdhi = this;
        while (true) {
            zzdhi zzdhi2 = zzdhi.zzgxb;
            if (zzdhi2 != null) {
                zzdhi = zzdhi2;
            } else {
                zzdhi.zzgwx.onAdClosed();
                zzdib.zza(zzdhi.zzgwz, zzdhj.zzgxc);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void zzajb() {
        zzdhi zzdhi = this;
        while (true) {
            zzdhi zzdhi2 = zzdhi.zzgxb;
            if (zzdhi2 != null) {
                zzdhi = zzdhi2;
            } else {
                zzdib.zza(zzdhi.zzgxa, zzdhm.zzgxc);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdim
    public final void zzb(zzdim zzdim) {
        this.zzgxb = (zzdhi) zzdim;
    }
}
