package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbuo extends zzbwv<zzbup> implements zzbtd, zzbuf {
    private final zzdkk zzfko;
    private AtomicBoolean zzfry = new AtomicBoolean();

    public zzbuo(Set<zzbyg<zzbup>> set, zzdkk zzdkk) {
        super(set);
        this.zzfko = zzdkk;
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final void onAdImpression() {
        if (this.zzfko.zzgzl == 2 || this.zzfko.zzgzl == 5 || this.zzfko.zzgzl == 4) {
            zzajc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void zzajb() {
        if (this.zzfko.zzgzl == 1) {
            zzajc();
        }
    }

    private final void zzajc() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcwy)).booleanValue() && this.zzfry.compareAndSet(false, true) && this.zzfko.zzhaf != null && this.zzfko.zzhaf.type == 3) {
            zza(new zzbun(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbup zzbup) throws Exception {
        zzbup.zzb(this.zzfko.zzhaf);
    }
}
