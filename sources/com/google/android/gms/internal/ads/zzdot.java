package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdot extends zzbwv<zzdpa> implements zzdos<zzdor> {
    zzdot(Set<zzbyg<zzdpa>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdos
    public final void zza(zzdod<zzdor, ?> zzdod) {
        zza(new zzdow(zzdod));
    }

    @Override // com.google.android.gms.internal.ads.zzdos
    public final void zzb(zzdod<zzdor, ?> zzdod) {
        zza(new zzdov(zzdod));
    }

    @Override // com.google.android.gms.internal.ads.zzdos
    public final void zza(zzdod<zzdor, ?> zzdod, Throwable th) {
        zza(new zzdoy(zzdod, th));
    }

    @Override // com.google.android.gms.internal.ads.zzdos
    public final void zzc(zzdod<zzdor, ?> zzdod) {
        zza(new zzdox(zzdod));
    }
}
