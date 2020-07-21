package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrj implements zzbva {
    private final Context zzaah;
    private final zzbbd zzbov;
    private final zzaxx zzdyn;
    private final zzclx zzfju;
    private final zzdla zzfpv;

    public zzbrj(Context context, zzdla zzdla, zzbbd zzbbd, zzaxx zzaxx, zzclx zzclx) {
        this.zzaah = context;
        this.zzfpv = zzdla;
        this.zzbov = zzbbd;
        this.zzdyn = zzaxx;
        this.zzfju = zzclx;
    }

    @Override // com.google.android.gms.internal.ads.zzbva
    public final void zzb(zzdkw zzdkw) {
    }

    @Override // com.google.android.gms.internal.ads.zzbva
    public final void zzd(zzasm zzasm) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcry)).booleanValue()) {
            zzq.zzle().zza(this.zzaah, this.zzbov, this.zzfpv.zzhaz, this.zzdyn.zzwz());
        }
        this.zzfju.zzaoq();
    }
}
