package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcvv implements zze {
    private final /* synthetic */ zzdkk zzgmm;
    private final /* synthetic */ zzdkw zzgna;
    private final /* synthetic */ zzbbn zzgod;
    private final /* synthetic */ zzcwb zzgoe;
    private final /* synthetic */ zzcvt zzgof;

    zzcvv(zzcvt zzcvt, zzbbn zzbbn, zzdkw zzdkw, zzdkk zzdkk, zzcwb zzcwb) {
        this.zzgof = zzcvt;
        this.zzgod = zzbbn;
        this.zzgna = zzdkw;
        this.zzgmm = zzdkk;
        this.zzgoe = zzcwb;
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzjz() {
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzka() {
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final void zzh(View view) {
        this.zzgod.set(this.zzgof.zzgoc.zza(this.zzgna, this.zzgmm, view, this.zzgoe));
    }
}
