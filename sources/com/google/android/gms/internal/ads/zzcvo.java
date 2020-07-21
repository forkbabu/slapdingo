package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvo implements zze {
    private final zzbyk zzfnk;
    private final zzbtc zzfuv;
    private final zzbsk zzfuw;
    private final zzblu zzfux;
    private final zzbyj zzfuz;
    private AtomicBoolean zzgny = new AtomicBoolean(false);

    zzcvo(zzbsk zzbsk, zzbtc zzbtc, zzbyk zzbyk, zzbyj zzbyj, zzblu zzblu) {
        this.zzfuw = zzbsk;
        this.zzfuv = zzbtc;
        this.zzfnk = zzbyk;
        this.zzfuz = zzbyj;
        this.zzfux = zzblu;
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final synchronized void zzh(View view) {
        if (this.zzgny.compareAndSet(false, true)) {
            this.zzfux.onAdImpression();
            this.zzfuz.zzv(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjz() {
        if (this.zzgny.get()) {
            this.zzfuw.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzka() {
        if (this.zzgny.get()) {
            this.zzfuv.onAdImpression();
            this.zzfnk.zzakb();
        }
    }
}
