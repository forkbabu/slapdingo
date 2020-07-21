package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdwy;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdwx implements zzdwy.zzb {
    private final /* synthetic */ zzdwi zzhqc;

    zzdwx(zzdwi zzdwi) {
        this.zzhqc = zzdwi;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy.zzb
    public final Class<?> zzaxy() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy.zzb
    public final <Q> zzdwi<Q> zzb(Class<Q> cls) throws GeneralSecurityException {
        if (this.zzhqc.zzaxi().equals(cls)) {
            return this.zzhqc;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    @Override // com.google.android.gms.internal.ads.zzdwy.zzb
    public final zzdwi<?> zzaxw() {
        return this.zzhqc;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy.zzb
    public final Class<?> zzaxx() {
        return this.zzhqc.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzdwy.zzb
    public final Set<Class<?>> zzaxm() {
        return Collections.singleton(this.zzhqc.zzaxi());
    }
}
