package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzckh implements zzdpa {
    private zztm zzgdn;
    private Map<zzdor, zzckj> zzgdx;

    zzckh(zztm zztm, Map<zzdor, zzckj> map) {
        this.zzgdx = map;
        this.zzgdn = zztm;
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zza(zzdor zzdor, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zzb(zzdor zzdor, String str) {
        if (this.zzgdx.containsKey(zzdor)) {
            this.zzgdn.zza(this.zzgdx.get(zzdor).zzgdz);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zza(zzdor zzdor, String str, Throwable th) {
        if (this.zzgdx.containsKey(zzdor)) {
            this.zzgdn.zza(this.zzgdx.get(zzdor).zzgeb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpa
    public final void zzc(zzdor zzdor, String str) {
        if (this.zzgdx.containsKey(zzdor)) {
            this.zzgdn.zza(this.zzgdx.get(zzdor).zzgea);
        }
    }
}
