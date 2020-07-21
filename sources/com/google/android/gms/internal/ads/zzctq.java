package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctq extends zzctn<zzchj> {
    private final zzbxa zzeti;
    private final zzbif zzgmd;
    private final zzbrx.zza zzgme;

    public zzctq(zzbif zzbif, zzbrx.zza zza, zzbxa zzbxa) {
        this.zzgmd = zzbif;
        this.zzgme = zza;
        this.zzeti = zzbxa;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzctn
    public final zzdvf<zzchj> zza(zzdla zzdla, Bundle bundle) {
        return this.zzgmd.zzadq().zze(this.zzgme.zza(zzdla).zzf(bundle).zzaiz()).zze(this.zzeti).zzafz().zzaex().zzaiq();
    }
}
