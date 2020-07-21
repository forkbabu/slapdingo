package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbos implements zzbua, zzqs {
    private final zzdkk zzfko;
    private final zzbtc zzfoo;
    private final zzbue zzfop;
    private final AtomicBoolean zzfoq = new AtomicBoolean();
    private final AtomicBoolean zzfor = new AtomicBoolean();

    public zzbos(zzdkk zzdkk, zzbtc zzbtc, zzbue zzbue) {
        this.zzfko = zzdkk;
        this.zzfoo = zzbtc;
        this.zzfop = zzbue;
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final synchronized void onAdLoaded() {
        if (this.zzfko.zzgzm != 1) {
            zzaie();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqs
    public final void zza(zzqt zzqt) {
        if (this.zzfko.zzgzm == 1 && zzqt.zzbrd) {
            zzaie();
        }
        if (zzqt.zzbrd && this.zzfor.compareAndSet(false, true)) {
            this.zzfop.zzajb();
        }
    }

    private final void zzaie() {
        if (this.zzfoq.compareAndSet(false, true)) {
            this.zzfoo.onAdImpression();
        }
    }
}
