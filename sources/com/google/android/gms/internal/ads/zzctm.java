package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctm extends zzctn<zzbnc> {
    private final zzbxa zzeti;
    private final zzcay zzetk;
    private final zzcvw zzffj;
    private final ViewGroup zzfng;
    private final zzbus zzfot;
    private final zzbif zzgmd;
    private final zzbrx.zza zzgme;

    public zzctm(zzbif zzbif, zzbrx.zza zza, zzcvw zzcvw, zzbxa zzbxa, zzcay zzcay, zzbus zzbus, ViewGroup viewGroup) {
        this.zzgmd = zzbif;
        this.zzgme = zza;
        this.zzffj = zzcvw;
        this.zzeti = zzbxa;
        this.zzetk = zzcay;
        this.zzfot = zzbus;
        this.zzfng = viewGroup;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzctn
    public final zzdvf<zzbnc> zza(zzdla zzdla, Bundle bundle) {
        return this.zzgmd.zzadl().zzc(this.zzgme.zza(zzdla).zzf(bundle).zzaiz()).zzc(this.zzeti).zza(this.zzffj).zzb(this.zzetk).zza(new zzbou(this.zzfot)).zzb(new zzbnb(this.zzfng)).zzafk().zzaex().zzaiq();
    }
}
