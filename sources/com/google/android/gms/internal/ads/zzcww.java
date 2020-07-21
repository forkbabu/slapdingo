package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcww implements zzbup {
    private final AtomicReference<zzyc> zzgpm = new AtomicReference<>();

    public final void zzb(zzyc zzyc) {
        this.zzgpm.set(zzyc);
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzb(zzvj zzvj) {
        zzdib.zza(this.zzgpm, new zzcwz(zzvj));
    }
}
