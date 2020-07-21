package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctl extends zzctn<zzbph> {
    private final zzbxa zzeti;
    private final zzcay zzetk;
    private final zzbif zzgmd;
    private final zzbrx.zza zzgme;

    public zzctl(zzbif zzbif, zzcay zzcay, zzbrx.zza zza, zzbxa zzbxa) {
        this.zzgmd = zzbif;
        this.zzetk = zzcay;
        this.zzgme = zza;
        this.zzeti = zzbxa;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzctn
    public final zzdvf<zzbph> zza(zzdla zzdla, Bundle bundle) {
        return this.zzgmd.zzadp().zza(this.zzgme.zza(zzdla).zzf(bundle).zzaiz()).zza(this.zzeti).zza(this.zzetk).zzaef().zzaex().zzaiq();
    }
}
