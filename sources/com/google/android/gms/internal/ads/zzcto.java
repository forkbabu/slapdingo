package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcto extends zzctn<zzbzj> {
    private final zzbxa zzeti;
    private final zzcvw zzffj;
    private final zzbif zzgmd;
    private final zzbrx.zza zzgme;

    public zzcto(zzbif zzbif, zzbrx.zza zza, zzcvw zzcvw, zzbxa zzbxa) {
        this.zzgmd = zzbif;
        this.zzgme = zza;
        this.zzffj = zzcvw;
        this.zzeti = zzbxa;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzctn
    public final zzdvf<zzbzj> zza(zzdla zzdla, Bundle bundle) {
        return this.zzgmd.zzado().zzd(this.zzgme.zza(zzdla).zzf(bundle).zzaiz()).zzd(this.zzeti).zzb(this.zzffj).zzafu().zzaex().zzaiq();
    }
}
